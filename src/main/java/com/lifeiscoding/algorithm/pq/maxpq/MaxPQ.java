package com.lifeiscoding.algorithm.pq.maxpq;

import com.lifeiscoding.algorithm.heap.TreeHeap;

public class MaxPQ<Key extends Comparable<Key>> extends TreeHeap<Key> implements IMaxPQ<Key> {

    public MaxPQ() {
        pq = (Key[]) new Comparable[1];
    }

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max + 1];
    }

    public MaxPQ(Key[] a) {
        pq = a;
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public Key max() {
        return pq[1];
    }
}
