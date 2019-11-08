package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/769/
 *
 * Determine if the filled suduko is valid
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // valid row and col
        // row++, col++
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] != '.' && !valid(board, r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean valid(char[][] board, int r, int c) {
        // valid row
        for (int col = 0; col < 9; col++) {
            if (c != col && board[r][col] == board[r][c]) return false;
        }

        // valid col
        for (int row = 0; row < 9; row++) {
            if (r != row && board[row][c] == board[r][c]) return false;
        }

        int rStart = r / 3 * 3;
        int cStart = c / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i + rStart) != r && (j + cStart) != c
                        && board[i + rStart][j + cStart] == board[r][c]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test1() {
        char[][] board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}

        };
        assertFalse(isValidSudoku(board));
    }

    @Test
    public void test2() {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        assertTrue(isValidSudoku(board));
    }
}
