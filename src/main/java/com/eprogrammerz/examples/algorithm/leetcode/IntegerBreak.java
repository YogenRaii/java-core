package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 */
public class IntegerBreak {

    @Test
    public void test1() {
        assertEquals(6, integerBreak(5));
        assertEquals(36, integerBreak(10));
        assertEquals(2, integerBreak(3));
        assertEquals(4, integerBreak(4));
        assertEquals(59049, integerBreak(30));
        assertEquals(1549681956, integerBreak(58));
    }

    // memoized version for breaking an integer
    public int integerBreak(int n) {
        if (n == 3) return 2;
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        return intBreak(n, mem);
    }

    private int intBreak(int n, int[] mem) {
        if (n <= 2) return 1;

        if (mem[n] != -1) return mem[n];

        int mul = 1;
        for (int i = 1; i <= n; i++) {
            mul = Math.max(mul, i * intBreak(n - i, mem));
        }
        mem[n] = mul;
        return mul;
    }
}
