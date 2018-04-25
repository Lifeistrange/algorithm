package com.lifeiscoding.algorithm.sort;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MergeTest extends SortTest{

    @Test
    public void testSort() {
        testSort(new Merge());
    }
}