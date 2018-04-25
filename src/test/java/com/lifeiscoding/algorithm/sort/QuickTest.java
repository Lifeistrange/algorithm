package com.lifeiscoding.algorithm.sort;

import org.testng.annotations.Test;

public class QuickTest extends SortTest{

    @Test(groups = "sort")
    public void testSort() {
        testSort(new Quick());
    }
}