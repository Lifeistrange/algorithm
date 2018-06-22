package com.lifeiscoding.algorithm.graph.caculate;

public interface IPaths {
    boolean hasPathTo(int v);

    Iterable<Integer> pathTo(int v);
}
