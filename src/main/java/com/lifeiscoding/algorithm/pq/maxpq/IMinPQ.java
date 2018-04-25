package com.lifeiscoding.algorithm.pq.maxpq;

public interface IMinPQ<Key extends Comparable<Key>> extends IPQ {

    Key min();

    Key delMin();
}
