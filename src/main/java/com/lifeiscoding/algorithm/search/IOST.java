package com.lifeiscoding.algorithm.search;

public interface IOST<Key extends Comparable<Key>, Value> extends IST<Key, Value> {
    Key floor(Key key);

    Key ceiling(Key key);

    Key select(int k);

    Key min();

    Key max();

    void deleteMin();

    void deleteMax();

    int rank(Key key);

    int size(Key lo, Key hi);

    Iterable<Key> keys(Key lo, Key hi);

}
