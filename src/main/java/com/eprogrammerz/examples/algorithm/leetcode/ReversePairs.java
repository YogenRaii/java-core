package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * pair of indices (i, j) are important pairs such that i < j & nums[i] > 2 * num[j]
 *
 * Return count of all those pairs
 *
 * https://leetcode.com/problems/reverse-pairs/
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0, n - 1);
    }

    private int mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;
        int count = mergeSort(nums, lo, mid) + mergeSort(nums, mid + 1, hi);

        int p = lo;
        int q = mid + 1;

        while (p <= mid && q <= hi) {
            if (nums[p] > 2L * nums[q]) {
                count += (mid - p + 1);
                q++;
            } else {
                p++;
            }
        }

        merge(nums, lo, mid, hi);

        return count;
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int len = hi - lo + 1;
        int[] copy = new int[len];

        int p = lo;
        int q = mid + 1;

        int i = 0;

        while (p <= mid && q <= hi) {
            if (nums[p] < nums[q]) {
                copy[i++] = nums[p++];
            } else {
                copy[i++] = nums[q++];
            }
        }

        while (p <= mid) {
            copy[i++] = nums[p++];
        }

        while (q <= hi) {
            copy[i++] = nums[q++];
        }

        System.arraycopy(copy, 0, nums, lo, len);
    }


    @Test
    public void test() {
        assertEquals(4, reversePairs(new int[] {5,4,3,2,1}));
        assertEquals(2, reversePairs(new int[] {1,3,2,3,1}));
        assertEquals(3, reversePairs(new int[] {2,4,3,5,1}));
    }
}
