package com.lifeiscoding.algorithm.search;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BinarySearchSTTest extends ISTTest{

    @Test
    public void testST(){
        ST<String, Integer> st = new BinarySearchST<>(32);
        super.testST(st);
    }

}