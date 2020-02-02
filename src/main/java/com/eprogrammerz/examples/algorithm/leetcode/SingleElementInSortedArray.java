package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // 1,2,2
            int left = mid - lo + 1; // 2

            if (mid > 0 && nums[mid - 1] == nums[mid]) {
                left = mid - lo + 1;
            } else if (mid < n - 1 && nums[mid + 1] == nums[mid]) {
                left = mid - lo;
            } else {
                return nums[mid];
            }

            if (left % 2 == 0) {
                // look into right
                if (mid > 0 && nums[mid - 1] == nums[mid]) {
                    lo = mid + 1;
                } else {
                    lo = mid;
                }

            } else {
                // look into left
                if (mid > 0 && nums[mid - 1] == nums[mid]) {
                    hi = mid + 1;
                } else if (mid + 1 < n && nums[mid + 1] == nums[mid]) {
                    hi = mid - 1;
                } else {
                    hi = mid;
                }
            }

            // now we need to go the section where length is odd
        }

        return -1;
    }

    @Test
    public void test() {
        assertEquals(1, singleNonDuplicate(new int[] {1,2,2}));
        assertEquals(2, singleNonDuplicate(new int[] {1,1,2}));
        assertEquals(2, singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
        assertEquals(1, singleNonDuplicate(new int[] {1,2,2,3,3,4,4,8,8}));
        assertEquals(3, singleNonDuplicate(new int[] {1,1,2,2,3,4,4,8,8}));
        assertEquals(4, singleNonDuplicate(new int[] {1,1,2,2,3,3,4,8,8}));
        assertEquals(8, singleNonDuplicate(new int[] {1,1,2,2,3,3,4,4,8}));
    }
}
