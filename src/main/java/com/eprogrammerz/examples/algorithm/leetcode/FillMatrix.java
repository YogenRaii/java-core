package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Given a NxN matrix. Fill the integers from 1 to n*n to this matrix that makes the sum of each row, each column and the two diagonals equal.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: null
 * Explanation: We need to fill [1, 2, 3, 4] into a 2x2 matrix, which is not possible so return null.
 * Example 2:
 * <p>
 * Input: n = 3
 * Output:
 * [[8, 3, 4],
 * [1, 5, 9],
 * [6, 7, 2]]
 * Explanation: We need to fill [1, 2, 3... 9] into a 3x3 matrix. This is one way to do it
 * Each row [8, 3, 4] [1, 5, 9] [6, 7, 2] sum is 15.
 * Each column [8, 1, 6] [3, 5, 7] [4, 9, 2] sum is 15.
 * The two diagonals [8, 5, 2] [4, 5, 6] sum is 15.
 */
public class FillMatrix {
    // sum = 9 * 8 / 2 = 9* 4 = 45
    // rowSum = sum / 3 = 15
    public int[][] fillMatrix(int n) {
        // if there is no way we can get a row with rowSum, then return null
        int target = n * (n * n + 1) / 2;

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], -1);
        }

        boolean[] visited = new boolean[n * n + 1];

        if (fill(mat, 0, 0, target, visited)) return mat;
        return null;
    }

    private boolean fill(int[][] matrix, int r, int c, int target, boolean[] visited) {


        int n = matrix.length;
        if (c == n) {
            c = 0;
            r++;
        }

        if (r == n) {
            return valid(matrix, target);
        }

        for (int i = 1; i <= n * n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                matrix[r][c] = i;

                if (fill(matrix, r, c + 1, target, visited)) {
                    return true;
                }

                matrix[r][c] = -1;
                visited[i] = false;
            }
        }

        return false;
    }

    private boolean valid(int[][] matrix, int target) {
        // row sums
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }

            if (sum != target) return false;
        }

        // col sum
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][j];
            }

            if (sum != target) return false;
        }

        // main diagonal
        int sum = 0;
        for (int i = 0, j = 0; i < n && j < n; j++, i++) {
            sum += matrix[i][j];
        }

        if (sum != target) return false;

        sum = 0;

        // anti diagonal
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            sum += matrix[i][j];
        }

        if (sum != target) return false;

        return true;
    }

    @Test
    public void test() {
        int[][] expected = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
        assertThat(fillMatrix(3), is(expected));

        assertNull(fillMatrix(2));
    }
}
