package com.lifeiscoding.algorithm.heap;

public class TreeHeap<Key extends Comparable<Key>> extends Heap<Key> {
    @Override
    protected void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    @Override
    protected void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    @Override
    public void insert(Key k) {
        pq[++N] = k;
        swim(N);
    }
}
