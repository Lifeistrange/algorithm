package com.lifeiscoding.algorithm.uf;

public abstract class UF {
    protected int[] id;

    protected int count;

    UF(int n) {
        id = new int[n];
        count = n;
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int p);

    public abstract void union(int p, int q);

}
