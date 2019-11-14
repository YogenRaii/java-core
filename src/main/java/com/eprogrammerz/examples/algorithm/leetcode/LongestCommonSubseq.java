package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given two sequences of integers, A[i]  and B[j], find the longest common subsequence and print it as a line of space-separated integers.
 * If there are multiple common subsequences with the same maximum length, print any one of them.
 * <p>
 * Sample Input
 * <p>
 * 5 6
 * 1 2 3 4 1
 * 3 4 1 2 1 3
 * Sample Output
 * <p>
 * 1 2 3
 * <p>
 * <p>
 * https://www.hackerrank.com/challenges/dynamic-programming-classics-the-longest-common-subsequence/problem
 */
public class LongestCommonSubseq {
    public int[] longestCommonSubsequence(int[] a, int[] b) {
        int[][] mem = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    mem[i][j] = 1 + mem[i - 1][j - 1];
                } else {
                    mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
                }
            }
        }

        int len = mem[a.length][b.length];
        int[] res = new int[len];
        int i = len - 1;
        for (int r = mem.length - 1; r > 0; r--) {
            for (int c = mem[0].length - 1; c > 0; c--) {
                // if it is coming from diagonal, then add res[i--] = a[c]
                while (c > 0 && mem[r][c] == mem[r][c - 1]) {
                    c--;
                }
                if (mem[r][c] == mem[r - 1][c - 1] + 1) {
                    res[i--] = a[c - 1];
                    if (i < 0) return res;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[]{3, 4, 1}, longestCommonSubsequence(new int[]{3, 4, 1, 2, 1, 3}, new int[]{1, 2, 3, 4, 1}));
    }
}
