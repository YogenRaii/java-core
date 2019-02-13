package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example:
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinSizeSubArraySum {
    /**
     * Time: O(n^2)
     * Space: O(1)
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {

        int minLen = Integer.MAX_VALUE;
        for (int start = 0; start < nums.length - 1; start++) {
            int tempLen = 1;

            int sum = nums[start];

            for (int end = start + 1; end < nums.length; end++) {
                if (sum >= s) {
                    break;
                }
                tempLen++;
                sum += nums[end];
            }

            if (sum >= s && tempLen < minLen) {
                minLen = tempLen;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    @Test
    public void testMinSubArrayLen() {
        assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        assertEquals(3, minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLenBetter(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        int left = 0;

        int sum = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            sum += nums[idx];

            // if we got to the sum, subtract left element & move left pointer forward until sum >= s
            while (sum >= s) {
                minLen = Math.min(minLen, idx + 1 - left);
                sum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    @Test
    public void testMinSubArrayLenBetter() {
        assertEquals(2, minSubArrayLenBetter(7, new int[]{2, 3, 1, 2, 4, 3}));
        assertEquals(3, minSubArrayLenBetter(11, new int[]{1, 2, 3, 4, 5}));
    }
}
