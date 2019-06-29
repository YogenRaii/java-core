package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The cell itself does not count as an adjacent cell.
 * The same letter cell may be used more than once.
 * <p>
 * Example :
 * <p>
 * Given board =
 * <p>
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns 1,
 * word = "SEE", -> returns 1,
 * word = "ABCB", -> returns 1,
 * word = "ABFSAB" -> returns 1
 * word = "ABCD" -> returns 0
 */
public class WordSearchBoard {
    public int exist(List<String> board, String word) {
        if (board == null || board.isEmpty() || word == null) return 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        /**
         * Go to each of the cell and see if the letter is same as of starting letter in search word
         */
        for (int r = 0; r < board.size(); r++) {
            for (int c = 0; c < board.get(0).length(); c++) {

                /**
                 * if letter is same, then do dfs starting that point
                 */
                if (board.get(r).charAt(c) == word.charAt(0)) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{r, c});

                    int chatIdx = 0;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int row = cell[0];
                        int col = cell[1];

                        if (board.get(row).charAt(col) == word.charAt(chatIdx)) {
                            chatIdx++;
                        }

                        if (chatIdx == word.length()) return 1;

                        /**
                         * Visit all possible cells and see if it is next char
                         */
                        for (int i = 0; i < 4; i++) {
                            int newRow = row + dx[i];
                            int newCol = col + dy[i];
                            if(isValid(newRow, newCol, board.size(), board.get(0).length()) && word.charAt(chatIdx) == board.get(newRow).charAt(newCol)) {
                                queue.add(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }


        return 0;
    }

    private boolean isValid(int r, int c, int row, int col) {
        if (r < 0 || r >= row || c < 0 || c >= col) return false;
        return true;
    }

    @Test
    public void testExists() {
        List<String> words = Arrays.asList("ABCE", "SFCS", "ADEE");
        assertEquals(1, exist(words, "ABCCED"));
        assertEquals(1, exist(words, "SEE"));
        assertEquals(1, exist(words, "SEED"));
        assertEquals(1, exist(words, "SEC"));
        assertEquals(1, exist(words, "ABFSAB"));
        assertEquals(0, exist(words, "ABCD"));
    }

    public int existDfs(List<String> board, String word) {
        if (board == null || word == null) return 0;

        int rows = board.size();
        int cols = board.get(0).length();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean dfs(List<String> board, String word, int r, int c, int i) {
        if (r < 0 || r >= board.size() || c < 0 || c >= board.get(0).length()) return false;
        if (board.get(r).charAt(c) != word.charAt(i)) return false;
        if (i == word.length() - 1) return true;
        else return dfs(board, word, r + 1, c, i + 1) ||
                dfs(board,word, r, c + 1, i+1) ||
                dfs(board,word, r, c - 1, i+1) ||
                dfs(board,word, r - 1, c, i+1);
    }

    @Test
    public void testExistsDfs() {
        List<String> words = Arrays.asList("ABCE", "SFCS", "ADEE");
        assertEquals(1, existDfs(words, "ABCCED"));
        assertEquals(1, existDfs(words, "SEE"));
        assertEquals(1, existDfs(words, "SEED"));
        assertEquals(1, existDfs(words, "SEC"));
        assertEquals(1, existDfs(words, "ABFSAB"));
        assertEquals(0, existDfs(words, "ABCD"));
    }
}
