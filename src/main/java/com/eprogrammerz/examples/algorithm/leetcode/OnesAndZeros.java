package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/ones-and-zeroes/
 */
public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] mem = new int[m + 1][n + 1];

        for (String str : strs) {
            int ones = 0;
            int zeros = 0;

            for (char ch : str.toCharArray()) {
                if (ch == '0') zeros++;
                else ones++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {

                    mem[i][j] = Math.max(mem[i][j], mem[i - zeros][j - ones] + 1);

                }
            }
        }

        return mem[m][n];
    }
    /*
    private int ans = 0;
    public int findMaxForm(String[] strs, int m, int n) {
        dfs(strs, m, n, 0);
        return ans;
    }

    private void dfs(String[] strs, int m, int n, int count) {
        if (m < 0 || n < 0) return;
        if (count > ans) ans = count;

        for (int i = 0; i < strs.length; i++) {
            String[] rem = new String[strs.length - 1];
            for (int j = 0, k = 0; j < strs.length;j++) {
                if (i == j) continue;
                rem[k++] = strs[j];
            }

            int ones = 0;
            int zeros = 0;

            for (char ch: strs[i].toCharArray()) {
                if (ch == '0') zeros++;
                else ones++;
            }

            dfs(rem, m - zeros, n - ones, count + 1);
        }
    }
    */


    @Test
    public void test1() {
        assertEquals(4, findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    @Test
    public void test2() {
        assertEquals(2, findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
    }

    @Test
    public void test3() {
        assertEquals(4, findMaxForm(new String[]{"0", "0", "1", "1"}, 2, 2));
    }

    @Test
    public void test4() {
        assertEquals(3, findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 3, 4));
    }
}
