package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class MaxSubmatrixSum {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int[][] height = new int[m][n];
        height[0] = matrix[0];

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[i][j] = height[i - 1][j] + matrix[i][j];
            }
        }

        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int[] curr = new int[n];
                if (i > 0) curr = height[i - 1];
                int currMax = maxSum(height[j], curr, k);
                if (currMax <= k) {
                    max = Math.max(currMax, max);
                }

            }
        }
        return max;
    }

    private int maxSum(int[] height, int[] minus, int k) {
        int max = 0;
        int curr = 0;

        for (int i = 0; i < height.length; i++) {
            int h = height[i] - minus[i];
            curr = Math.max(0, curr) + h;
            if (curr <= k) max = Math.max(curr, max);
        }
        return max;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][] {{2,2,-1}};
        assertEquals(3, maxSumSubmatrix(matrix, 3));
    }
}
