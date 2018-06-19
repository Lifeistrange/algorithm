package com.lifeiscoding.algorithm.search;


import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> extends OST<Key, Value> {

    private Node root;

    @Override
    public Key floor(Key key) {
        return floor(root, key);
    }

    private Key floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp <= 0) {
            return floor(x.left, key);
        } else {
            Key result = floor(x.right, key);
            if (result == null) return x.key;
            else return result;
        }
    }

    @Override
    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    private Key ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            Key result = floor(x.left, key);
            if (result == null) return x.key;
            else return result;
        } else {
            return floor(x.right, key);
        }
    }

    @Override
    public Key select(int k) {
        return select(root, k);
    }

    private Key select(Node x, int k) {
        if (x == null) return null;
        if (size(x.left) > k) return select(x.left, k);
        else if (size(x.left) < k) return select(x.right, k - size(x.left) - 1);
        else return x.key;
    }

    @Override
    public Key min() {
        Node x = min(root);
        if (x == null) return null;
        else return x.key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    @Override
    public Key max() {
        return max(root);
    }

    private Key max(Node x) {
        if (x.right == null) return x.key;
        return max(x.right);
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        List<Key> list = new ArrayList<>();
        keys(root, list, lo, hi);
        return list;
    }

    private void keys(Node x, List<Key> list, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, list, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) list.add(x.key);
        if (cmphi >= 0) keys(x.right, list, lo, hi);

    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = x.key.compareTo(key);
        if (cmp < 0) x.right = put(x.right, key, value);
        else if (cmp > 0) x.left = put(x.left, key, value);
        else x.value = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        if (x.key.compareTo(key) == 0) {
            return x.value;
        } else if (x.key.compareTo(key) < 0) {
            return get(x.right, key);
        } else {
            return get(x.left, key);
        }
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }


    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return delete(x.left, key);
        else if (cmp > 0) return delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    public Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.N;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }
}
