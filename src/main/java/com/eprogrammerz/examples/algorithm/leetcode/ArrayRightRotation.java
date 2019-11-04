package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
public class ArrayRightRotation {
    public void rotate(int[] nums, int k) {
        // [5,6,7,1,2,3,4]
        if (nums.length <= 1) return;
        k = k % nums.length;

        int count = 0;
        int i = 0;
        while (count < nums.length) {
            int start = i;
            int temp = nums[i];

            int end = (k + i) % nums.length;
            while (start != end) {
                int val = nums[end];
                nums[end] = temp;
                temp = val;
                end = (end + k) % nums.length;
                count++;
            }
            nums[start] = temp;
            count++;
            i++;
        }

    }

    @Test
    public void test1() {
        int[] expected = new int[] {5,6,7,1,2,3,4};
        int[] input = new int[] {1,2,3,4,5,6,7};
        rotate(input, 3);
        assertArrayEquals(expected, input);
    }


    @Test
    public void test2() {
        int[] expected = new int[] {5,6,1,2,3,4};
        int[] input = new int[] {1,2,3,4,5,6};
        rotate(input, 2);
        assertArrayEquals(expected, input);
    }
}
