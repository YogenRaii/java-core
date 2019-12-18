package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class MaxRectangleArea {
    /**
     * Time O((mn)^2)
     * Space O(1)
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    // search for largest rectangle possible
                    // if at any point encountered 0, then discontinue
                    int len = 0;
                    int wid = n - j;
                    for (int r = 0; r < m - i; r++) {
                        if (matrix[r + i][j] == '0') break;

                        for (int c = 0; c < wid; c++) {
                            if (matrix[r + i][c + j] == '0') {
                                max = Math.max(len * wid, max);
                                wid = Math.min(wid, c);
                                break;
                            }
                        }
                        len++;
                    }
                    max = Math.max(len * wid, max);

                }
            }
        }
        return max;
    }

    @Test
    public void test() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        assertEquals(6, maximalRectangle(matrix));
    }

    @Test
    public void test2() {
        char[][] matrix = new char[][]{
                {'1', '1', '1', '1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '1', '1', '0'},
                {'1', '1', '1', '1', '1', '0', '0', '0'},
                {'0', '1', '1', '1', '1', '0', '0', '0'}
        };
        assertEquals(21, maximalRectangle(matrix));
    }
}
