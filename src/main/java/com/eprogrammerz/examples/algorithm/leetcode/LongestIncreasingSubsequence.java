package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.*;


/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int len = Integer.MIN_VALUE;
        int[] m = new int[nums.length];

        Arrays.fill(m, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    m[i] = Math.max(m[i], m[j] + 1);
                }
            }
             len = Math.max(len, m[i]);
        }

        int count = 0;

        for (int n: m) {
            if (n == len) count++;
        }
        return count;
    }

    @Test
    public void test1() {
        assertEquals(2, findNumberOfLIS(new int[] {1,3,5,4,7}));
    }
}
