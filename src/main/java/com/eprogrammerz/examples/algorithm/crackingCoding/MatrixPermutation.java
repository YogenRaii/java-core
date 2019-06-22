package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MatrixPermutation {
    public List<int[][]> findMatrixPermutation(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> nums = getList(matrix, row, col);

        ListPermutations listPermutations = new ListPermutations();
        List<List<Integer>> permutations = listPermutations.findPermutations(nums);

        List<int[][]> matrixPermutations = new ArrayList<>(permutations.size());
        for (List<Integer> permutation: permutations) {
            int[][] permMatrix = getMatrix(permutation, row, col);
            matrixPermutations.add(permMatrix);
        }
        return matrixPermutations;
    }

    @Test
    public void testFindMatrixPermutation() {
        int[][] matrix = new int[][] {
                {1,2},
                {3,4}
        };
        List<int[][]> permutations = findMatrixPermutation(matrix);

        System.out.println("Permutation size: " + permutations.size());
        for (int[][] perm: permutations) {
            printMatrix(perm);
        }
    }

    private void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private List<Integer> getList(int[][] matrix, int row, int col) {
        List<Integer> list = new ArrayList<>(row * col);
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                list.add(matrix[r][c]);
            }
        }
        return list;
    }

    private int[][] getMatrix(List<Integer> list, int row, int col) {
        int[][] matrix = new int[row][col];
        int idx = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                matrix[r][c] = list.get(idx++);
            }
        }
        return matrix;
    }
}
