package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 *
 * This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than or equal to the last integer of the previous row.
 *
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return 1 ( 1 corresponds to true )
 *
 * Solution: O(m) + O(n)
 */

public class MatrixSearcher {
    public int searchMatrix(List<List<Integer>> matrix, int target) {
        int columnSize = matrix.get(0).size();

        // find potential row
        // search on row

        int low = 0;
        int high = matrix.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            List<Integer> row = matrix.get(mid);

            if (row.get(0) <= target && target <= row.get(columnSize - 1)) {
                return doBinarySearch(row, target);
            }

            if (row.get(0) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }

    private int doBinarySearch(List<Integer> row, int target) {
        int low = 0;
        int high = row.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row.get(mid) == target) return 1;

            if (row.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }

    @Test
    public void testSearchMatrix() {
        List<Integer> row1 = Arrays.asList(1,   3,  5,  7);
        List<Integer> row2 = Arrays.asList(10, 11, 16, 20);
        List<Integer> row3 = Arrays.asList(23, 30, 34, 50);

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        assertEquals(1, searchMatrix(matrix, 3));
        assertEquals(1, searchMatrix(matrix, 50));
        assertEquals(0, searchMatrix(matrix, 51));
    }
}
