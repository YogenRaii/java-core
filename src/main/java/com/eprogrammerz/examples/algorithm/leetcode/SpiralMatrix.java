package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Given a matrix of order m x n, return spiral traversal of the matrix.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> l = new ArrayList<>();


        if (matrix == null) return l;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;


        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd && !visited[rowStart][i]; i++) {
                l.add(matrix[rowStart][i]);
                visited[rowStart][i] = true;
            }

            rowStart++;
            for (int i = rowStart; i <= rowEnd && !visited[i][colEnd]; i++) {
                l.add(matrix[i][colEnd]);
                visited[i][colEnd] = true;
            }
            colEnd--;
            for (int i = colEnd; i >= colStart && !visited[rowEnd][i]; i--) {
                l.add(matrix[rowEnd][i]);
                visited[rowEnd][i] = true;
            }

            rowEnd--;
            for (int i = rowEnd; i >= rowStart && !visited[i][colStart]; i--) {
                l.add(matrix[i][colStart]);
                visited[i][colStart] = true;
            }
            colStart++;
        }

        return l;
    }

    @Test
    public void test1() {
        int[][] arr = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(spiralOrder(arr), is(expected));
    }

    @Test
    public void test2() {
        int[][] arr = new int[][]{
                {1, 2, 3, 10},
                {8, 9, 4, 11},
                {7, 6, 5, 12}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 10, 11, 12, 5, 6, 7, 8, 9, 4);
        assertThat(spiralOrder(arr), is(expected));
    }
}
