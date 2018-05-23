package com.lifeiscoding.algorithm.search;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public abstract class ISTTest {

    @Test
    public void testST(IST<String, Integer> st) {
        String[] str = new String[]{"a", "c", "b", "d", "o", "a", "s", "i", "d", "f", "h", "b", "k", "d", "b", "f", "g", "j", "k", "s", "d"};
        for (int i = 0; i < str.length; i++) {
            String key = str[i];
            st.put(key, i);
        }

        for (String s : st.keys()) {
            System.out.println(s + " " + st.get(s));
        }
    }

}