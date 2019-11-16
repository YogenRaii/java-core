package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        int[] lps = findLps(A);

        int i = 0;
        int j = 0;
        while (j < A.length() && i < B.length()) {
            // A - pattern
            // B - text
            if (A.charAt(j) == B.charAt(i)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return A.substring(j).equals(B.substring(0, B.length() - j));

    }

    private int[] findLps(String str) {
        int[] lps = new int[str.length()];

        int j = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else if (str.charAt(i) != str.charAt(j) && j != 0) {
                j = lps[j - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }

    @Test
    public void test() {
        assertTrue(rotateString("abcde", "cdeab"));
        assertTrue(rotateString("abcde", "bcdea"));
        assertTrue(rotateString("abcde", "abcde"));
        assertFalse(rotateString("abcde", "abcdf"));
        assertTrue(rotateString("bbbacddceeb", "ceebbbbacdd"));
    }
}
