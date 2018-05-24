package com.lifeiscoding.algorithm.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchST<Key extends Comparable<Key>, Value> extends OST<Key, Value> {

    private Key[] keys;

    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Object[capacity];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        return keys[i - 1];
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        int lo_index = rank(lo);
        int hi_index = rank(hi);
        return Arrays.asList(this.keys).subList(lo_index, hi_index);
    }

    @Override
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0)
            return values[i];
        else
            return null;
    }


    @Override
    public void delete(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (i = i + 1; i < N; i++) {
                keys[i - 1] = keys[i];
                values[i - 1] = values[i];
            }
        }
        keys[i] = null;
        values[i] = null;
        N--;
    }

    @Override
    public int size() {
        return N;
    }
}
