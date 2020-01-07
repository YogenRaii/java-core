package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/alphabet-board-path/
 */
public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        String[] board = {"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};

        StringBuilder sb = new StringBuilder();

        int x = 0, y = 0;

        for (char ch: target.toCharArray()) {
            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(x, y, ""));

            Set<String> visited = new HashSet<>();
            visited.add(x + "#" + y);

            while (!q.isEmpty()) {
                Pair curr = q.poll();

                x = curr.x;
                y = curr.y;

                if (board[x].charAt(y) == ch) {
                    sb.append(curr.path).append('!');
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = x + dr[i];
                    int nc = y + dc[i];

                    String key = nr + "#" + nc;
                    if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[nr].length() &&
                            !visited.contains(key)) {
                        q.offer(new Pair(nr, nc, curr.path + dir[i]));
                        visited.add(key);
                    }
                }
            }
        }

        return sb.toString();
    }

    private int[] dr = {-1,1,0,0};
    private int[] dc = {0,0,-1,1};

    private char[] dir = {'U', 'D', 'L', 'R'};

    class Pair {
        int x;
        int y;
        String path;

        Pair(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    @Test
    public void test() {
        assertEquals("DDR!UURRR!!DDD!", alphabetBoardPath("leet"));
        assertEquals("RR!DDRR!UUL!R!", alphabetBoardPath("code"));
    }
}
