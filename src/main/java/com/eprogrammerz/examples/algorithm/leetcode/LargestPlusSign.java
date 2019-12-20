package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/largest-plus-sign/
 */
public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N];
        for (int[] mine : mines) {
            int r = mine[0];
            int c = mine[1];
            matrix[r][c] = 1;
        }

        int[][] left = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    left[i][j] = (j > 0 ? left[i][j - 1] : 0) + 1;
                }
            }
        }

        int[][] right = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    right[i][j] = (j < N - 1 ? right[i][j + 1] : 0) + 1;
                }
            }
        }

        int[][] top = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0)
                    top[i][j] = (i > 0 ? top[i - 1][j] : 0) + 1;
            }

        }

        int[][] bottom = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    bottom[i][j] = (i < N - 1 ? bottom[i + 1][j] : 0) + 1;
                }
            }
        }

        int order = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    int curr = Math.min(Math.min(left[i][j], right[i][j]),
                            Math.min(top[i][j], bottom[i][j]));
                    order = Math.max(order, curr);
                }
            }
        }
        return order;
    }

    @Test
    public void test() {
        assertEquals(2, orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
    }
}
