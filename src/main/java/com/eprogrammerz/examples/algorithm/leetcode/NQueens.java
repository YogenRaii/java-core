package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NQueens {
    private int[][] mem;
    private List<List<String>> l ;

    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.l = new ArrayList<>();
        this.mem = new int[n][n];
        this.n = n;

        solve(0, new ArrayList<>());

        return l;
    }

    private void solve(int r, List<String> temp) {

        for (int c = 0; c < n; c++) {

            if (mem[r][c] == 0 && goodSpot(r, c)) {
                mem[r][c] = 2;
                StringBuilder sb = new StringBuilder();

                for (int k = 0; k < c; k++) sb.append(".");

                sb.append("Q");

                for (int k = c + 1; k < n; k++) sb.append(".");

                temp.add(sb.toString());

                if (r == n - 1) {
                    l.add(new ArrayList<>(temp));
                } else {

                    solve(r + 1, temp);
                }
                mem[r][c] = 0;
                temp.remove(temp.size() - 1);

            }

        }
    }

    private boolean goodSpot(int r, int c) {
        for (int col = 0; col < n; col++) {
            if (mem[r][col] != 0) return false;
        }

        for (int row = 0; row < n; row++) {
            if (mem[row][c] != 0) return false;
        }

        // main diagoal
        for (int row = r - 1, col = c - 1; row >= 0 && col >= 0; row--, col--) {
            if (mem[row][col] != 0) return false;
        }
        for (int row = r + 1, col = c + 1; row < n && col < n; row++, col++) {
            if (mem[row][col] != 0) return false;
        }
        // opposite diagonal
        for (int row = r - 1, col = c + 1; row >= 0 && col < n; row--, col++) {
            if (mem[row][col] != 0) return false;
        }
        for (int row = r + 1, col = c - 1; row < n && col >= 0; row++, col--) {
            if (mem[row][col] != 0) return false;
        }
        return true;
    }

    @Test
    public void test1() {
        List<List<String>> expected = asList(asList(".Q..","...Q","Q...","..Q."),asList("..Q.","Q...","...Q",".Q.."));
        assertThat(solveNQueens(4), is(expected));
    }
}
