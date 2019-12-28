package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class MiniFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int min = Integer.MAX_VALUE;

        int m = A.length;
        int n = A[0].length;

        int[][] mem = new int[m][n];

        mem[0] = A[0];

        for (int r = 1; r < A.length; r++) {

            for (int i = 0; i < n; i++) {
                int curr;
                if (i == 0) {
                    curr = Math.min(mem[r - 1][i], mem[r - 1][i + 1]);
                } else if (i == n - 1) {
                    curr = Math.min(mem[r - 1][i - 1], mem[r - 1][i]);
                } else {
                    curr = Math.min(mem[r - 1][i - 1], Math.min(mem[r - 1][i], mem[r - 1][i + 1]));
                }
                mem[r][i] = curr + A[r][i];
            }
        }

        int currMin = findMin(mem[m - 1]);
        if (min > currMin) min = currMin;

        return min;
    }

    private int findMin(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }

        return min;
    }

    @Test
    public void test1() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertEquals(12, minFallingPathSum(mat));
    }

    @Test
    public void test2() {
        int[][] mat = {{-51, -35, 74}, {-62, 14, -53}, {94, 61, -10}};
        assertEquals(-98, minFallingPathSum(mat));
    }
}
