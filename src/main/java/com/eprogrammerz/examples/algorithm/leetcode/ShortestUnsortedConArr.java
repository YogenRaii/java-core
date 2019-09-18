package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */
public class ShortestUnsortedConArr {
    /**
     * O(nlogn) - Time
     * O(n) - space
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        int start = -1;
        int end = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp[i]) {
                if (start == -1) {
                    start = i;
                }
                end = i;
            }
        }
        if (start == -1) return 0;

        return (end - start) + 1;
    }

    @Test
    public void testFindUnsortedSubArray() {
        assertEquals(5, findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}));
        assertEquals(0, findUnsortedSubarray(new int[] {1, 2, 4, 8, 10, 15}));
        assertEquals(0, findUnsortedSubarray(new int[] {1, 2, 2, 8, 10, 15}));
        assertEquals(4, findUnsortedSubarray(new int[] {1, 3, 2, 3, 2, 15}));
        assertEquals(2, findUnsortedSubarray(new int[] {1, 3, 2, 3, 3, 15}));
        assertEquals(4, findUnsortedSubarray(new int[] {1, 3, 2, 2, 2}));
        assertEquals(3, findUnsortedSubarray(new int[] {2, 3, 3, 2, 4}));
        assertEquals(3, findUnsortedSubarray(new int[] {1, 2, 4, 5, 3}));
    }

    /**
     * O(n) - Time
     * O(1) - space
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarrayBetter(int[] nums) {
        int len = nums.length - 1;
        int start = -1;
        int end = -2;

        int max = nums[0];
        int min = nums[len];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else if (nums[i] > max) {
                max = nums[i];
            }

            if (nums[len - i] > min) {
                start = len - i;
            } else if (nums[len - i] < min) {
                min = nums[len - i];
            }
        }

        return (end - start) + 1;
    }

    @Test
    public void testFindUnsortedSubArrayBetter() {
        assertEquals(5, findUnsortedSubarrayBetter(new int[] {2, 6, 4, 8, 10, 9, 15}));
        assertEquals(0, findUnsortedSubarrayBetter(new int[] {1, 2, 4, 8, 10, 15}));
        assertEquals(0, findUnsortedSubarrayBetter(new int[] {1, 2, 2, 8, 10, 15}));
        assertEquals(4, findUnsortedSubarrayBetter(new int[] {1, 3, 2, 3, 2, 15}));
        assertEquals(2, findUnsortedSubarrayBetter(new int[] {1, 3, 2, 3, 3, 15}));
        assertEquals(4, findUnsortedSubarrayBetter(new int[] {1, 3, 2, 2, 2}));
        assertEquals(3, findUnsortedSubarrayBetter(new int[] {2, 3, 3, 2, 4}));
        assertEquals(3, findUnsortedSubarrayBetter(new int[] {1, 2, 4, 5, 3}));
    }
}
