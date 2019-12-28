package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuySellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) minPrice = prices[i];

            if (prices[i] - minPrice > profit) profit = prices[i] - minPrice;
        }
        return profit;
    }

    @Test
    public void test() {
        assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(1, maxProfit(new int[]{1, 2}));
    }
}
