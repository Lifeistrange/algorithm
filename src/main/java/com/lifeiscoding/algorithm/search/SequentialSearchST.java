package com.lifeiscoding.algorithm.search;

import java.util.ArrayList;
import java.util.List;

public class SequentialSearchST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {

    private Node first;

    @Override
    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }

    @Override
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        List<Key> keys = new ArrayList<>();
        for (Node x = first; x != null; x = x.next) {
            keys.add(x.key);
        }
        return keys;
    }

    private class Node {
        Key key;

        Value value;

        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
