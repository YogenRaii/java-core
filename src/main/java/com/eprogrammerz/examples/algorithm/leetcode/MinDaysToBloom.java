package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of roses. roses[i] means rose i will bloom on day roses[i]. Also given an int k,
 * which is the minimum number of adjacent bloom roses required for a bouquet, and an int n, which is the number of bouquets we need.
 * Return the earliest day that we can get n bouquets of roses.
 * <p>
 * Example:
 * Input: roses = [1, 2, 4, 9, 3, 4, 1], k = 2, n = 2
 * Output: 4
 * Explanation:
 * day 1: [b, n, n, n, n, n, b]
 * The first and the last rose bloom.
 * <p>
 * day 2: [b, b, n, n, n, n, b]
 * The second rose blooms. Here the first two bloom roses make a bouquet.
 * <p>
 * day 3: [b, b, n, n, b, n, b]
 * <p>
 * day 4: [b, b, b, n, b, b, b]
 * Here the last three bloom roses make a bouquet, meeting the required n = 2 bouquets of bloom roses. So return day 4.
 */
public class MinDaysToBloom {
    @Test
    public void test() {
        assertEquals(4, minDaysBloom(new int[]{1, 2, 4, 9, 3, 4, 1}, 2, 2));
        assertEquals(6, minDaysBloom(new int[]{1, 5, 6, 2}, 1, 4));
        assertEquals(1, minDaysBloom(new int[]{1, 1, 1, 1}, 4, 1));
    }

    public int minDaysBloom(int[] roses, int k, int n) {
        int len = roses.length;
        if (len == 0) return 0;

        int lo = min(roses);
        int hi = max(roses);

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (bouquets(roses, mid, k) < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private int bouquets(int[] roses, int day, int k) {
        int running = 0;
        int count = 0;

        for (int i = 0; i < roses.length; i++) {
            if (roses[i] < day) {
                running++;
            }

            if (running == k) {
                count++;
                running = 0;
            }
        }

        return count;
    }

    private int min(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    private int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }
}
