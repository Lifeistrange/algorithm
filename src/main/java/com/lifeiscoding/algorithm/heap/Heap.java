package com.lifeiscoding.algorithm.heap;

public abstract class Heap<Key extends Comparable<Key>> {

    protected Key[] pq;

    protected int N = 0;

    protected boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    protected void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    public int size() {return N;}

    public boolean isEmpty() {return N == 0;}

    abstract void swim(int k);

    abstract void sink(int k);

    abstract void insert(Key k);
}
