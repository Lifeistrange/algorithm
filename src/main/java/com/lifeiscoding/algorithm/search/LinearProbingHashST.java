package com.lifeiscoding.algorithm.search;

public class LinearProbingHashST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int M) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<>(M);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null)
                t.put(keys[i], values[i]);
            keys = t.keys;
            values = t.values;
            this.M = t.M;
        }
    }

    @Override
    public void put(Key key, Value value) {
        if (N >= M / 2) resize(2 * M);
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key))
                return values[i];
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) resize(M / 2);
    }

    @Override
    public int size() {
        // TODO: LinearProbingHashST size method
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        // TODO: LinearProbingHashST keys method
        return null;
    }
}
