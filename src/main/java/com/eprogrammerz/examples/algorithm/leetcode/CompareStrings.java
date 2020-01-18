package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;

/**
 * One string A strictly smaller than other B if the count(firstSamllestChar A) < count(firstSmallestChar B)
 *
 * for given array of strings with B, return C[j] where C[j] represents count of smaller strings than C[j] in A
 */
public class CompareStrings {
    // Time O(m * n) where m -> length of B, n -> length of A
    public int[] compareStrings(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");

        Map<String, int[]> map = new HashMap<>();

        for (String aa: a) {
            map.put(aa, count(aa));
        }

        int len = b.length;

        int[] res = new int[len];

        for (int i = 0; i < len; i++) { // O(m * n)
            res[i] = countStrings(a, map, b[i]);
        }

        return res;
    }

    private int countStrings(String[] arr, Map<String, int[]> map, String str) {
        int count = 0;

        int[] bCount = count(str);

        for (String a: arr) {
            int[] aCount = map.get(a);

            // if b is strictly larger, then count + 1
            int aVal = 0;
            int bVal = 0;
            for (int i = 0; i < 26; i++) {
                if (aCount[i] > 0 && aVal == 0) aVal = aCount[i];

                if (bCount[i] > 0 && bVal == 0) bVal = bCount[i];
            }

            if (bVal > aVal) count++;
        }

        return count;
    }

    private int[] count(String str) {
        int[] arr  = new int[26];

        for (char ch: str.toCharArray()) {
            arr[ch - 'a']++;
        }

        return arr;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[] { 3, 2}, compareStrings("abcd aabc bd", "aaa aa"));
    }
}
