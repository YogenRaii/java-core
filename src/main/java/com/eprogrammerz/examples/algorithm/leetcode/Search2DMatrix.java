package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * - Integers in each row are sorted from left to right.
 * - The first integer of each row is greater than the last integer of the previous row.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        // int[] firstRow = matrix[0];
        // int[] lastRow = matrix[matrix.length - 1];

        // if (firstRow)
        // find row in which target falls using bs
        // search target in that row
        int start = 0;
        int end = matrix.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int[] row = matrix[mid];

            if (row[0] <= target && target <= row[row.length - 1]) {
                return bs(row, target);
            } else if (row[0] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

    private boolean bs(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8,9}};
        assertTrue(searchMatrix(matrix, 3));
        assertTrue(searchMatrix(matrix, 6));
        assertFalse(searchMatrix(matrix, 10));
        assertFalse(searchMatrix(matrix, -1));
    }

    @Test
    public void test2() {
        int[][] matrix = new int[][]{
                {}
        };
        assertFalse(searchMatrix(matrix, 10));
    }

    /**
     * Better version
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixBetter(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        // start from bottom left corner
        // if less than current, do row--
        // if greater, then col++

        int row = matrix.length - 1;
        int col = 0;
        while (row >=0 && col < matrix[0].length) {
            if (matrix[row][col] == target) return true;

            if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

    @Test
    public void test3() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8,9}};
        assertTrue(searchMatrixBetter(matrix, 3));
        assertTrue(searchMatrixBetter(matrix, 6));
        assertFalse(searchMatrixBetter(matrix, 10));
        assertFalse(searchMatrixBetter(matrix, -1));
    }

    @Test
    public void test4() {
        int[][] matrix = new int[][]{
                {}
        };
        assertFalse(searchMatrixBetter(matrix, 10));
    }
}
