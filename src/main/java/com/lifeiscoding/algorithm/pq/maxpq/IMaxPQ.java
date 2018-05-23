package com.lifeiscoding.algorithm.pq.maxpq;

public interface IMaxPQ<Key extends Comparable<Key>> extends IPQ<Key> {

    Key max();

    Key delMax();
}
