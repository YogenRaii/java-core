package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).s
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * <p>
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchRotatedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;

            // if left part is sorted
            if (nums[start] <= nums[mid]) {
                // make sure target falls in sorted part
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {

                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void test1() {
        assertEquals(0, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        assertEquals(1, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        assertEquals(2, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        assertEquals(3, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        assertEquals(4, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(5, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        assertEquals(6, search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
    }

    @Test
    public void test2() {
        assertEquals(4, search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }

    @Test
    public void test3() {
        assertEquals(1, search(new int[]{3, 1}, 1));
    }
}
