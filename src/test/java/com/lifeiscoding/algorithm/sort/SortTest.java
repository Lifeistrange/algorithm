package com.lifeiscoding.algorithm.sort;

public abstract class SortTest {

    public void testSort(Sort sort) {
        String[] str = new String[]{"a", "c", "b", "d", "o", "a", "s", "i", "d", "f", "h", "b", "k", "d", "b", "f", "g", "j", "k", "s", "d"};
        Sort.show(str);
        sort.sort(str);
        assert Sort.isSorted(str);
        Sort.show(str);
    }
}
