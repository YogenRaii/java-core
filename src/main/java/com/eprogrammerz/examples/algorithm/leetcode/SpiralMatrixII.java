package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int val = 0;
        for (int i = 0; i <= (n / 2); i++) {
            int row = i;
            int col = i;
            // top
            for (; col < n - i; col++) {
                m[row][col] = ++val;
            }

            col--;
            row++;
            // right
            for (; row < n - i; row++) {
                m[row][col] = ++val;
            }

            // bottom
            row--;
            col--;
            for (; col >= i; col--) {
                m[row][col] = ++val;
            }

            // left
            row--;
            col++;
            for (; row > i; row--) {
                m[row][col] = ++val;
            }
        }
        return m;
    }

    @Test
    public void test() {
        int[][] matrix = generateMatrix(3);
        int[][] expected = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        assertThat(matrix, is(expected));
    }
}
