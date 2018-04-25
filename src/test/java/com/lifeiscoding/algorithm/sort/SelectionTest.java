package com.lifeiscoding.algorithm.sort;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SelectionTest extends SortTest{

    @Test
    public void testSort() {
        testSort(new Selection());
    }
}