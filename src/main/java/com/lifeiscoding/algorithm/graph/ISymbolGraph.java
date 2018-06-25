package com.lifeiscoding.algorithm.graph;

public interface ISymbolGraph {

    boolean contains(String key);

    int index(String key);

    String name(int v);

    IGraph G();
}
