package com.eprogrammerz.examples.bootcamp.algorithms;

import org.junit.Test;

/**
 * Print matrix in spiral form
 *  3X3
 *   1  2  3
 *   8  9  4
 *   7  6  5
 *
 *
 *   4X4
 *   1  2  3  4
 *  12 13 14  5
 *  11 16 15  6
 *  10  9  8  7
 */
public class SpiralMatrix {
    int[][] findSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];

        int counter = 1;

        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol){

            for (int col = startCol; col <= endCol; col++) {
                matrix[startRow][col] = counter++;
            }
            startRow++;

            for (int row = startRow; row <= endRow; row++) {
                matrix[row][endCol] = counter++;
            }
            endCol--;

            for (int col = endCol; col >= startCol; col--) {
                matrix[endRow][col] = counter++;
            }
            endRow--;

            for (int row = endRow; row >= startRow; row--) {
                matrix[row][startCol] = counter++;
            }

            startCol++;
        }
        return matrix;
    }

    @Test
    public void testSpiralMatrix() {
        int[][] result3x3 = findSpiralMatrix(3);

        printMatrix(result3x3);

        int[][] result4x4 = findSpiralMatrix(4);

        printMatrix(result4x4);
    }

    private void printMatrix(int[][] result) {
        for (int r = 0; r < result.length; r++) {
            for (int c = 0; c < result[0].length; c++) {
                System.out.printf("%3d",result[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
