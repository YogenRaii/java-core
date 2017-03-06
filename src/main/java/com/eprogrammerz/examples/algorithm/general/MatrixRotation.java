package com.eprogrammerz.examples.algorithm.general;

/**
 * Created by 542596 on 3/5/2017.
 */
public class MatrixRotation {
    public static void main(String[] args) {
        int[][] twoD = new int[][]{
                /*{1,2},
                {3,4}*/
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        flipMatrix(twoD);
        for(int i = 0; i< twoD.length; i++) {
            for(int j = 0; j <twoD[0].length; j++) {
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
}
