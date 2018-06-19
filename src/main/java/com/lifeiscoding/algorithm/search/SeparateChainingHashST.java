package com.lifeiscoding.algorithm.search;

public class SeparateChainingHashST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private int N = 0;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    @Override
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    @Override
    public int size() {
        // TODO: SeparateChainingHashST size method
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO: SeparateChainingHashST keys method
        return null;
    }
}
