package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/word-search-ii/
 */
public class TwoDSearchBoard {
    public List<String> findWords(char[][] board, String[] words) {
        List<String>[] map = new ArrayList[26];

        for (String word : words) {
            int key = word.charAt(0) - 'a';

            if (map[key] == null) {
                map[key] = new ArrayList<>();
            }
            map[key].add(word);
        }

        int m = board.length;
        int n = board[0].length;

        Set<String> found = new HashSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char curr = board[r][c];
                if (map[curr - 'a'] != null) {
                    List<String> candidates = map[curr - 'a'];

                    for (String candidate : candidates) {
                        if (found.contains(candidate)) continue;

                        if (dfs(board, candidate, 0, r, c)) {
                            found.add(candidate);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(found);

    }

    private boolean dfs(char[][] board, String word, int idx, int r, int c) {

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(idx)) return false;

        if (idx == word.length() - 1) return true;

        board[r][c] = '0';

        boolean val = dfs(board, word, idx + 1, r - 1, c) ||
                dfs(board, word, idx + 1, r + 1, c) ||
                dfs(board, word, idx + 1, r, c + 1) ||
                dfs(board, word, idx + 1, r, c - 1);

        board[r][c] = word.charAt(idx);

        return val;
    }

    @Test
    public void test() {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        List<String> actual = findWords(board, new String[]{"oath", "pea", "eat", "rain"});
        assertThat(actual, hasItems("oath", "eat"));
    }
}
