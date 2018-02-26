package com.eprogrammerz.examples.algorithm.general;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * {4, 3, 7, 8, 6, 2, 1} -> {3,7,4,8,2,6,1}
 *
 * {3,4,7,8,6,2,1}, {3,7,4,8,6,2,1}
 * {3,4,7,8,2,6,1}
 */
public class ArrayZigZagger<T extends Number>{
    public int[] arrangeArrayZigZag(int[] nums) {

        if (nums == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }
        if (nums.length <= 1) {
            return nums;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (i % 2 != 0) {
                if (nums[i - 1] > nums[i]) {
                    swap(nums, i - 1, i);
                }

                if (nums[i] < nums[i+1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if (nums[i - 1] < nums[i]) {
                    swap(nums, i - 1, i);
                }
                if (nums[i] > nums[i+1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    @Test
    public void testArrangeArrayZigZag() {
        assertArrayEquals(new int[]{3,7,4,8,2,6,1},arrangeArrayZigZag(new int[]{4, 3, 7, 8, 6, 2, 1}));
        assertArrayEquals(new int[]{1, 4, 2, 3},arrangeArrayZigZag(new int[]{1, 4, 3, 2}));
    }
}