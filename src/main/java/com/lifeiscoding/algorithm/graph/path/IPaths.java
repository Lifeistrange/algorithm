package com.lifeiscoding.algorithm.graph.path;

public interface IPaths {
    boolean hasPathTo(int v);

    Iterable<Integer> pathTo(int v);
}
