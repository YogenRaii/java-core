package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an int array nums of length n. Split it into strictly decreasing subsequences. Output the min number of subsequences you can get by splitting.
 *
 * Example 1:
 *
 * Input: [5, 2, 4, 3, 1, 6]
 * Output: 3
 * Explanation:
 * You can split this array into: [5, 2, 1], [4, 3], [6]. And there are 3 subsequences you get.
 * Or you can split it into [5, 4, 3], [2, 1], [6]. Also 3 subsequences.
 * But [5, 4, 3, 2, 1], [6] is not legal because [5, 4, 3, 2, 1] is not a subsuquence of the original array.
 * Example 2:
 *
 * Input: [2, 9, 12, 13, 4, 7, 6, 5, 10]
 * Output: 4
 * Explanation: [2], [9, 4], [12, 10], [13, 7, 6, 5]
 * Example 3:
 *
 * Input: [1, 1, 1]
 * Output: 3
 * Explanation: Because of the strictly descending order you have to split it into 3 subsequences: [1], [1], [1]
 */
public class DecreasingSubsequence {
    public int decreasingSubseqences(int[] arr) {
        int len = 0;
        int n = arr.length;

        if (n == 0) return 0;

        int[] seq = new int[n];

        for (int a: arr) {
            int idx = search(seq, 0, len, a);

            seq[idx] = a;

            if (idx == len) len++;
        }

        return len;
    }

    private int search(int[] arr, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    @Test
    public void test() {
        assertEquals(3, decreasingSubseqences(new int[] {5, 2, 4, 3, 1, 6}));
        assertEquals(4, decreasingSubseqences(new int[] {2, 9, 12, 13, 4, 7, 6, 5, 10}));
        assertEquals(3, decreasingSubseqences(new int[] {1, 1, 1}));
    }
}
