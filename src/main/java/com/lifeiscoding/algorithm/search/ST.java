package com.lifeiscoding.algorithm.search;

public abstract class ST<Key extends Comparable<Key>, Value> implements IST<Key, Value> {

    @Override
    public void delete(Key key) {
        put(key, null);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
