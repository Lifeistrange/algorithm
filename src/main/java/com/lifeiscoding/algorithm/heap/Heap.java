package com.lifeiscoding.algorithm.heap;

public abstract class Heap<Key extends Comparable<Key>> {

    Comparable[] pq;

    protected boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    protected void exch(int i, int j) {
        Key t = (Key) pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    abstract void swim(int k);

    abstract void sink(int k);

}
