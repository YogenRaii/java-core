package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * We have two integer sequences A and B of the same non-zero length.
 *
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
 *
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 *
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 *
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 *
 * https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
 */
public class MinSwapToMakeIncreasing {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;

        int[] fix = new int[n];
        int[] swap = new int[n];

        fix[0] = 0;
        swap[1] = 1;

        for (int i = 1; i < n; i++) {
            if (A[i - 1] >= B[i] || B[i - 1] >= A[i]) {
                fix[i] = fix[i - 1];
                swap[i] = swap[i - 1] + 1;
            } else if (A[i - 1] >= A[i] || B[i - 1] >= B[i]) {
                fix[i] = swap[i - 1];
                swap[i] = fix[i - 1] + 1;
            } else {
                int min = Math.min(fix[ i -1], swap[i - 1]);
                fix[i] = min;
                swap[i] = min + 1;
            }
        }

        return Math.min(swap[n - 1], fix[n - 1]);
    }

    @Test
    public void test() {
        assertEquals(1, minSwap(new int[]{0, 4, 4, 5, 9}, new int[]{0, 1, 6, 8, 10}));
        assertEquals(1, minSwap(new int[]{3, 3, 8, 9, 109}, new int[]{1, 7, 4, 6, 8}));
    }
}
