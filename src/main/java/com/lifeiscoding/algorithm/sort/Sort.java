package com.lifeiscoding.algorithm.sort;

public abstract class Sort {

    protected static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    protected static void exch(Comparable[] a, int x, int y) {
        Comparable tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    protected static void show(Comparable[] a) {
        for (Comparable x : a)
            System.out.print(x + " ");
        System.out.println();
    }

    protected static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public abstract void sort(Comparable[] a);
}
