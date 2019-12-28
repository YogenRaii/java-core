package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/count-of-range-sum/
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {

        long[] sum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        return mergeSort(sum, 0, sum.length - 1, lower, upper);
    }

    private int mergeSort(long[] arr, int lo, int hi, int lower, int upper) {
        if (lo >= hi) return 0;
        int mid = lo + (hi - lo) / 2;

        int count = mergeSort(arr, lo, mid, lower, upper) + mergeSort(arr, mid + 1, hi, lower, upper);

        for (int i = lo, j = mid + 1, k = mid + 1; i <= mid; i++) {
            while (j <= hi && arr[j] - arr[i] < lower) j++;
            while (k <= hi && arr[k] - arr[i] <= upper) k++;

            count += (k - j);
        }

        merge(arr, lo, mid, hi);

        return count;
    }

    private void merge(long[] arr, int lo, int mid, int hi) {
        long[] copy = new long[hi - lo + 1];

        int p = lo;
        int q = mid + 1;
        int i = 0;
        while (p <= mid && q <= hi) {
            if (arr[p] < arr[q]) {
                copy[i++] = arr[p++];
            } else {
                copy[i++] = arr[q++];
            }
        }

        while (p <= mid) {
            copy[i++] = arr[p++];
        }

        while (q <= hi) {
            copy[i++] = arr[q++];
        }

        System.arraycopy(copy, 0, arr, lo, hi - lo + 1);
    }

    @Test
    public void test() {
        assertEquals(3, countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
