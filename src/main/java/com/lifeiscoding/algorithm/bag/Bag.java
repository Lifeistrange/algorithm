package com.lifeiscoding.algorithm.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Key> implements Iterable<Key> {

    private Key[] keys;

    private int capacity = 64;

    private int size = 0;

    public Bag() {
        this.keys = (Key[]) new Object[this.capacity];
    }

    public Bag(int capacity) {
        this.capacity = capacity;
        this.keys = (Key[]) new Object[this.capacity];
    }

    @Override
    public Iterator<Key> iterator() {
        return new Iterator<Key>() {
            private int next_index = 0;

            @Override
            public boolean hasNext() {
                return next_index < size;
            }

            @Override
            public Key next() {

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return keys[next_index++];
            }
        };
    }

    public void add(Key key) {
        if (size == capacity)
            resize(this.capacity * 2);
        keys[size++] = key;
    }

    private void resize(int capacity) {
        Key[] tmp = keys;
        keys = (Key[]) new Object[capacity];
        System.arraycopy(tmp, 0, keys, 0, size);
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
