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

        int start_row = 0;
        int end_row = n - 1;
        int start_col = 0;
        int end_col = n - 1;

        while (start_row <= end_row && start_col <= end_col){
            int s_r = start_row;
            int e_r = end_row;
            int s_c = start_col;
            int e_c = end_col;

            while (s_c <= e_c) {
                matrix[s_r][s_c] = counter++;
                s_c++;
            }
            s_c--;

            start_row++;
            s_r = start_row;
            while (s_r <= e_r) {
                matrix[s_r][s_c] = counter++;
                s_r++;
            }
            s_r--;

            end_col--;

            s_c = end_col;
            e_c = start_col;
            while (s_c >= e_c) {
                matrix[e_r][s_c] = counter++;
                s_c--;
            }
            s_c++;

            end_row--;

            s_r = end_row;
            e_r = start_row;
            while (s_r >= e_r) {
                matrix[s_r][e_c] = counter++;
                s_r--;
            }
            start_col++;
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
