package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 *
 *
 * https://leetcode.com/problems/coin-change-2/
 */
public class CoinChangeII {

    public int change(int amount, int[] coins) {
        // memoization with amount and coin index
        // so that no need to recalculate for that amount and given coins
        int[][] mem = new int[amount + 1][coins.length];
        for (int r = 0; r <= amount; r++) {
            for (int c = 0; c < coins.length; c++) {
                mem[r][c] = -1;
            }
        }
        return change(amount, coins, 0, mem);
    }

    private int change(int amt, int[] coins, int start, int[][] mem) {
        if (amt == 0) {
            return 1;
        }

        if (amt < 0 || start == coins.length) return 0;
        if (mem[amt][start] != -1) return mem[amt][start];
        int cnt = 0;

        for (int i = start; i < coins.length; i++) {
            cnt += change(amt - coins[i], coins, i, mem);
        }
        mem[amt][start] = cnt;
        return mem[amt][start];
    }

    @Test
    public void test1() {
        assertEquals(4, change(5, new int[]{1, 2, 5}));
        assertEquals(0, change(3, new int[]{2}));
        assertEquals(1, change(10, new int[]{10}));
        assertEquals(35502874, change(500, new int[]{3, 5, 7, 8, 9, 10, 11}));
        assertEquals(0, change(500, new int[]{}));
        assertEquals(1, change(0, new int[]{}));
    }
}
