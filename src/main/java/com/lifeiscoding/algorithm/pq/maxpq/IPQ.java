package com.lifeiscoding.algorithm.pq.maxpq;

public interface IPQ<Key extends Comparable<Key>> {

    public void Insert(Key v);

    boolean isEmpty();

    int size();
}
