package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Insert max a into string str so that they will 2 consecutive a
 * if str has more than 2 a's, then return -1
 */
public class MaxInsertOfA {
    public int countMaxInsert(String str) {
        int count = 0;
        int aCount = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                aCount++;
                if (aCount > 2) return -1;
            } else {
                if (aCount == 2) {
                    aCount = 0;
                } else if (aCount > 0) {
                    count += aCount;
                    aCount = 0;
                } else {
                    count += 2;
                    aCount = 0;
                }
            }
        }
        if (str.charAt(str.length() - 1) != 'a') {
            count += 2;
        } else {
            count += (2 - aCount);
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(3, countMaxInsert("aabab"));
        assertEquals(2, countMaxInsert("aababa"));
        assertEquals(8, countMaxInsert("dog"));
        assertEquals(0, countMaxInsert("aa"));
        assertEquals(-1, countMaxInsert("baaaa"));
    }
}
