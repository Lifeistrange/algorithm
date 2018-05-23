package com.lifeiscoding.algorithm.pq.maxpq;

public interface IPQ<Key extends Comparable<Key>> {

    void insert(Key v);

    boolean isEmpty();

    int size();
}
