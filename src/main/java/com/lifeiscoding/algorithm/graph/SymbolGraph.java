package com.lifeiscoding.algorithm.graph;

import com.lifeiscoding.algorithm.search.ST;
import com.lifeiscoding.algorithm.search.SequentialSearchST;

public class SymbolGraph implements ISymbolGraph {

    private ST<String, Integer> st;
    private String[] keys;
    private IGraph G;

    public SymbolGraph(String[] stream, String sp) {
        st = new SequentialSearchST<>();
        for (String line : stream) {
            String[] a = line.split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String name : st.keys())
            keys[st.get(name)] = name;
        G = new Graph(st.size());
        for (String line : stream) {
            String[] a = line.split(sp);
            int v = st.get(a[0]);
            for (int i = 0; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    @Override
    public boolean contains(String key) {
        return st.contains(key);
    }

    @Override
    public int index(String key) {
        return st.get(key);
    }

    @Override
    public String name(int v) {
        return keys[v];
    }

    @Override
    public IGraph G() {
        return G;
    }
}
