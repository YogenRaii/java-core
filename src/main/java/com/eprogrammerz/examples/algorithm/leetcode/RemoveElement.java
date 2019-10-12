package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 *
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0; // index to track target
        int j = 0; // index to track non-target
        int count = 0;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == val) {
                if (i < j && nums[j] != val) {
                    swap(nums, i, j);
                    i++;
                } else {
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        for (int n: nums) {
            if (n == val) break;
            count++;
        }
        return count;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        int[] arr = new int[] {0,1,2,2,3,0,4,2};
        assertEquals(5, removeElement(arr, 2));
    }
}
