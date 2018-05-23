package com.lifeiscoding.algorithm.search;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SequentialSearchSTTest extends ISTTest{

    @Test
    public void testST(){
        ST<String, Integer> st = new SequentialSearchST<>();
        super.testST(st);
    }

}