package com.lifeiscoding.algorithm.graph;

public interface IDigraph {
    int V();

    int E();

    void addEdge(int v, int w);

    Iterable<Integer> adj(int v);

    IDigraph reverse();

    String toString();
}
