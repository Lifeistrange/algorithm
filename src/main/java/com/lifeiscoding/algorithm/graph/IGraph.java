package com.lifeiscoding.algorithm.graph;

public interface IGraph {
    int V();

    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    String toString();
}
