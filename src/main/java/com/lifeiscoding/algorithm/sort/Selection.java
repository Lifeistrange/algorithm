package com.lifeiscoding.algorithm.sort;

public class Selection extends Sort{

    @Override
    public void sort(Comparable[] a) {
        for (int x = 0; x < a.length; x++) {
            int min = x;
            for (int y = x; y < a.length; y++)
                if (less(a[y], a[min])) min = y;
            exch(a, x, min);
        }
    }
}
