package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Return number of character to be added to make a given string 'word' a anagram of palindrome.
 */
public class Anadrome {
    public int changeToAnadrome(String word) {
        int[] map = new int[128];
        int n = word.length();
        for (int i = 0; i < n; i++) {
            map[word.charAt(i)]++;
        }

        int odds = 0;

        for (int count: map) {
            if (count % 2 != 0) odds++;
        }

        if (odds == 0) return 0;
        return odds - 1;
    }

    @Test
    public void test() {
        assertEquals(1, changeToAnadrome("abcb"));
        assertEquals(2, changeToAnadrome("abc"));
        assertEquals(0, changeToAnadrome("tatoo"));
    }
}
