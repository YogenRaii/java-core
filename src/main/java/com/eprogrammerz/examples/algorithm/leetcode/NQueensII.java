package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class NQueensII {
    private int[][] mem;
    private int count;
    public int totalNQueens(int n) {
        mem = new int[n][n];

        totalNQueens(n, 0);
        return count;
    }

    private void totalNQueens(int n, int r) {
        for (int c = 0; c < n; c++) {
            if (mem[r][c] == 0 && goodSpot(r, c)) {
                mem[r][c] = 2;
                if (r == n - 1) {
                    count++;
                } else {
                    totalNQueens(n, r + 1);
                }
                mem[r][c] = 0;
            }
        }
    }

    private boolean goodSpot(int r, int c) {
        for (int col = 0; col < mem[0].length; col++) {
            if (mem[r][col] != 0) return false;
        }

        for (int row = 0; row < mem.length; row++) {
            if (mem[row][c] != 0) return false;
        }

        // main diagoal
        for (int row = r - 1, col = c - 1; row >= 0 && col >= 0; row--, col--) {
            if (mem[row][col] != 0) return false;
        }
        for (int row = r + 1, col = c + 1; row < mem.length && col < mem.length; row++, col++) {
            if (mem[row][col] != 0) return false;
        }
        // opposite diagonal
        for (int row = r - 1, col = c + 1; row >= 0 && col < mem.length; row--, col++) {
            if (mem[row][col] != 0) return false;
        }
        for (int row = r + 1, col = c - 1; row < mem.length && col >= 0; row++, col--) {
            if (mem[row][col] != 0) return false;
        }
        return true;
    }

    @Test
    public void test1() {
        assertEquals(2, totalNQueens(4));
    }
}
