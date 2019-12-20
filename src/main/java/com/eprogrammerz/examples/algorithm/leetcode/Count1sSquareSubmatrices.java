package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */
public class Count1sSquareSubmatrices {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int count = 0;

        int[][] mem = new int[m + 1][n + 1];

        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                if (matrix[row - 1][col - 1] == 1) {
                    mem[row][col] = 1 + Math.min(mem[row - 1][col - 1],
                            Math.min(mem[row - 1][col], mem[row][col - 1]));
                    count += mem[row][col];
                }
            }
        }

        return count;
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        assertEquals(15, countSquares(matrix));
    }
}
