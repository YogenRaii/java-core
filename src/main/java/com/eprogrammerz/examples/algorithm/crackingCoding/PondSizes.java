package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class PondSizes {
    public List<Integer> findPondSizes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> pondSizes = new ArrayList<>();

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (matrix[r][c] == 0) {
                    int[] cell = new int[] {r,c};
                    // do dfs
                    int size = getPondSize(matrix, row, col, cell);
                    pondSizes.add(size);
                }
            }
        }

        return pondSizes;
    }

    private int getPondSize(int[][] matrix, int row, int col, int[] currentCell) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(currentCell);

        int size = 0;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            size++;

            // if any of neighor is valid cell, add to queue
            int cellRow = cell[0];
            int cellCol = cell[1];
            matrix[cellRow][cellCol] = -1; // marking as visited

            // down
            if (cellRow + 1 < row && matrix[cellRow + 1][cellCol] == 0) {
                queue.add(new int[] {cellRow + 1, cellCol});
            }

            // up
            if (cellRow - 1 >= 0 && matrix[cellRow - 1][cellCol] == 0) {
                queue.add(new int[] {cellRow - 1, cellCol});
            }

            // right
            if (cellCol + 1 < col && matrix[cellRow][cellCol + 1] == 0) {
                queue.add(new int[] { cellRow, cellCol + 1});
            }

            if (cellCol - 1 >= 0 && matrix[cellRow][cellCol - 1] == 0) {
                queue.add(new int[] { cellRow, cellCol - 1});
            }
        }
        return size;
    }

    @Test
    public void testFindPondSizes() {
        int[][] matrix = new int[][] {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        List<Integer> expected = Arrays.asList(1,1,2,3);
        List<Integer> actual = findPondSizes(matrix);
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }
}
