package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/wiggle-sort-ii/
 *
 * nums[0] < nums[1] > nums[2] < nums[3] ...
 */
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        int n = nums.length;

        sort(nums, 0, n - 1);

        int l = 0;
        int r = n - 1;

        int mid = l + (r - l) / 2;

        int[] temp = new int[n];

        int p1 = mid, p2 = n - 1;

        int i = 0;

        while (p1 >= 0 || p2 > mid) {
            if (i % 2 == 0) {
                temp[i++] = nums[p1--];
            } else {
                temp[i++] = nums[p2--];
            }
        }

        for (i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    private void sort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            int p = partition(nums, l, r, mid);
            sort(nums, l, p - 1);
            sort(nums, p + 1, r);
        }
    }

    private int partition(int[] nums, int l, int r, int p) {
        int pivot = nums[p];
        int i = l;

        swap(nums, p, r);

        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    @Test
    public void test1() {
        int[] expected = {2, 3, 1, 3, 1, 2};
        int[] actual = {1, 3, 2, 2, 3, 1};
        wiggleSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] expected = {1, 6, 1, 5, 1, 4}; // 1 1 1 6 5 4
        int[] actual = {1, 1, 1, 5, 6, 4};
        wiggleSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] actual = {5,3,1,2,6,7,8,5,5};
        wiggleSort(actual);
        System.out.println(actual);
    }
}
