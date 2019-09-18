package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 * <p>
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 */
public class PartitionWEqualSum {
    /**
     * O(n^2) - time
     * @param arr
     * @return
     */
    public boolean canThreePartsEqualSum(int[] arr) {
        // find sum to index i, see if rest of array can be divided into two to find target sum
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }

        int p1 = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            p1 += arr[i];
            sum -= arr[i];
            if (canTwoPartsEqualSum(arr, i + 1, p1, sum)) return true;
        }

        return false;
    }

    private boolean canTwoPartsEqualSum(int[] arr, int startIdx, int target, int sum) {
        int p2 = 0;
        for (int i = startIdx; i < arr.length; i++) {
            p2 += arr[i];
            sum -= arr[i];
            if (p2 == target && sum == target) return true;
        }
        return false;
    }

    @Test
    public void testCanThreePartsEqualSum() {
        assertTrue(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        assertFalse(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        assertTrue(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        assertTrue(canThreePartsEqualSum(new int[]{18, 12, -18, 18, -19, -1, 10, 10}));
        assertTrue(canThreePartsEqualSum(new int[]{2, 8, 15, -5, 0, 9, -3, 4}));

    }


    /**
     * O(n) - time
     * @param arr
     * @return
     */
    public boolean canThreePartsEqualSumBetter(int[] arr) {
        // find sum to index i, see if rest of array can be divided into two to find target sum
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }

        if (sum % 3 != 0) return false;

        int partSum = sum / 3;
        int tempSum = 0;
        int count = 0;
        for (int n: arr) {
            tempSum += n;
            if (partSum == tempSum) {
                count++;
                tempSum = 0;
            }
        }
        return count == 3;
    }

    @Test
    public void testCanThreePartsEqualSumBetter() {
        assertTrue(canThreePartsEqualSumBetter(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        assertFalse(canThreePartsEqualSumBetter(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        assertTrue(canThreePartsEqualSumBetter(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        assertTrue(canThreePartsEqualSumBetter(new int[]{18, 12, -18, 18, -19, -1, 10, 10}));
        assertTrue(canThreePartsEqualSumBetter(new int[]{2, 8, 15, -5, 0, 9, -3, 4}));

    }
}
