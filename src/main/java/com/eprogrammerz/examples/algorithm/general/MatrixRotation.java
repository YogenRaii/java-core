package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

/**
 * Created by 542596 on 3/5/2017.
 */
public class MatrixRotation {


    /**
     * You are given an n x n 2D matrix representing an image.
     *
     * Rotate the image by 90 degrees (clockwise).
     *
     * @param matrix
     */
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n / 2; r++) {
            for (int c = r; c < n - 1 - r; c++) {
                int temp = matrix[r][c];
                // left to top
                matrix[r][c] = matrix[n - 1 - c][r];
                // bottom to left
                matrix[n - 1 - c][r] = matrix[n - 1 -r][n - 1 - c];
                // right to bottom
                matrix[n - 1 - r][n - 1 - c] = matrix[c][n - 1 - r];
                // top to right
                matrix[c][n - 1 - r] = temp;
            }
        }
    }

    @Test
    public void testRotateMatrix() {
        int[][] twoD = new int[][]{
                /*{1,2},
                {3,4}*/
                /*{1,2,3},
                {4,5,6},
                {7,8,9}*/
                {1,2,3,4},
                {6,7,8,9},
                {10,11,12,13},
                {14,15,16,17}
        };
        System.out.println("Before rotation:");
        printMatrix(twoD);
        rotateMatrix(twoD);
        System.out.println("After rotation:");
        printMatrix(twoD);
    }

    private void printMatrix(int[][] twoD) {
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[0].length; j++) {
                System.out.print(twoD[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static void flipMatrix(int[][] matrix) {
        for(int row = 0; row < matrix.length/2; row++) {
            int[] singleRow = matrix[matrix.length - row -1];
            singleRow = flipArray(singleRow);
            int[] tempArr = matrix[row];
            tempArr = flipArray(tempArr);
            matrix[row] = singleRow;
            matrix[matrix.length - row - 1] = tempArr;
        }
        if(matrix.length % 2 != 0) {
            int[] midRow = flipArray(matrix[matrix.length / 2]);
            matrix[matrix.length / 2] = midRow;
        }
    }

    private static int[] flipArray(int[] singleRow) {
        int[] reversedData = new int[singleRow.length];
        int i;
        for(i=0; i < singleRow.length; i++)
        {
            reversedData[i] = singleRow[(singleRow.length - i -1)];
        }
        return reversedData;
    }

    @Test
    public void testFlipMatrix() {
        int[][] twoD = new int[][]{
                /*{1,2},
                {3,4}*/
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        flipMatrix(twoD);
        printMatrix(twoD);
    }
}
