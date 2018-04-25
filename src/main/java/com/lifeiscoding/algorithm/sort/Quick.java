package com.lifeiscoding.algorithm.sort;

public class Quick extends Sort {

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);

    }

    public int partition(Comparable[] a, int lo, int hi) {
        Comparable mid = a[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], mid)) if (i == hi) {
                break;
            }
            while (less(mid, a[--j])) if (j == lo) {
                break;
            }

            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, j, lo);
        return j;
    }
}
