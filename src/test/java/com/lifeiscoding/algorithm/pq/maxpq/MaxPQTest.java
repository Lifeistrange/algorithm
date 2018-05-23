package com.lifeiscoding.algorithm.pq.maxpq;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MaxPQTest {

    @Test
    public void testPQ() {
        MaxPQ<String> maxPQ = new MaxPQ<>(8);
        maxPQ.insert("a");
        maxPQ.insert("c");
        maxPQ.insert("b");
        maxPQ.insert("d");
        maxPQ.insert("o");
        maxPQ.insert("a");
        maxPQ.insert("s");
        maxPQ.insert("i");
        assert maxPQ.max().equals("s");
        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.delMax());
        }
    }
}