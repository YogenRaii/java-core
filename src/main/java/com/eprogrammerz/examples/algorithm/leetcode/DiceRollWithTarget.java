package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class DiceRollWithTarget {
    public int numRollsToTarget(int d, int f, int target) {
        int mod = 1000000007;
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for (int i = 1; i <= d; i++) {
            int[] newWays = new int[target + 1];

            for (int j = 0; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        newWays[j] += ways[j - k];
                        newWays[j] %= mod;
                    }

                }
            }
            ways = newWays;
        }

        return ways[target];
    }

    @Test
    public void test() {
        assertEquals(1, numRollsToTarget(1, 6, 3));
    }
}
