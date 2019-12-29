package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/target-sum/
 */
public class TargetSum {
    /*public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[S + 1];
        for (int n: nums) {
            if (n < S) {
                dp[n] = 1;
            }
        }
        for (int i = 1; i <= S; i++) {
            for (int n: nums) {
                if (i >= n)
                    dp[i] += dp[i - n];

//                if (i + n <= S)
//                    dp[i] += dp[i + n];
            }
        }

        return dp[S - 1];
    }*/

    public int findTargetSumWays(int[] nums, int S) {
        Map<String, Integer> mem = new HashMap<>();

        return dfs(nums, S, 0, mem);
    }

    private int dfs(int[] nums, int target, int idx, Map<String, Integer> mem) { // 3, 0, 0

        if (idx > nums.length) return 0;

        if (nums.length == idx) {
            if (target == 0)
                return 1; // target = 3, sum = -4, idx = 4
            return 0;
        }

        String key = target + "#" + idx;

        if (mem.containsKey(key)) return mem.get(key);

        int curr  = dfs(nums, target - nums[idx], idx + 1, mem) +
                dfs(nums, target + nums[idx], idx + 1, mem);

        mem.put(key, curr);

        return mem.get(key);
    }


    @Test
    public void test1() { // 9725438598
        assertEquals(5, findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3));
    }
}
