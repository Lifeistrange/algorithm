package com.lifeiscoding.algorithm.sort;

public class Quick3way extends Sort {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;

        int[] se = partition(a, lo, hi);
        sort(a, lo, se[0]);
        sort(a, se[1], hi);

    }

    public int[] partition(Comparable[] a, int lo, int hi) {
        Comparable mid = a[lo];
        int lt = lo, i = lo+1, gt = hi;
        while (i <= gt) {
            int cmp = a[i].compareTo(mid);
            if (cmp < 0) exch(a, i++, lt++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;
        }
        return new int[]{lt - 1, gt + 1};
    }
}
