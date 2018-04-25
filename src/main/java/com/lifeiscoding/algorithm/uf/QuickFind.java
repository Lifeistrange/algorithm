package com.lifeiscoding.algorithm.uf;

import java.util.Scanner;

public class QuickFind extends UF {
    QuickFind(int n) {
        super(n);
    }

    public static void main(String[] args) {
        UF uf = new QuickFind(10);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            if (uf.connected(p, q)) continue;

            uf.union(p, q);
            System.out.println(p + "," + q);
        }
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);

        if (pid == qid) return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) id[i] = qid;
        }
        count--;
    }
}
