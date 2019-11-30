package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Maximum subarray sum with max one deletion allowed
 *
 * https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 */
public class MaxSubArrWOneDeletion {
    /**
     * We only need to track two variables: the maximum sum we can get (with / without) a deletion.
     *
     * For the maximum without a deletion, it is purely Kadane's algorithm.
     *
     * For the maximum with a deletion, we can either discard current number, or, add current number to previous maximum with a deletion.
     *
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        int maxSum = arr[0];
        int currWO = arr[0];  // track sum without deletion i.e. Kadane's algorithm
        int currWith = arr[0]; // track sum with deletion

        for (int i = 1; i < arr.length; i++) {
            currWith = Math.max(currWith + arr[i], currWO);

            currWO = Math.max(arr[i], arr[i] + currWO);

            maxSum = Math.max(Math.max(currWith, currWO), maxSum);
        }

        return maxSum;
    }

    @Test
    public void test() {
        assertEquals(3, maximumSum(new int[] {1,-2,-2,3}));
        assertEquals(4, maximumSum(new int[] {1,-2,0,3}));
        assertEquals(-1, maximumSum(new int[] {-1,-1,-1,-1}));
    }
}
