package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {
    private Random rnd = new Random();

    public int findKthLargest(int[] nums, int k) {
        // we do with ranking
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int pivotIdx = left + rnd.nextInt(right - left + 1);

            int pIdx = partition(nums, left, right, pivotIdx);

            if (pIdx == n - k) return nums[pIdx];

            if (pIdx < n - k) {
                left = pIdx + 1;
            } else {
                right = pIdx - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int l, int r, int p) {

        int i = l;


        int pivot = nums[p];
        // put pivot to the end
        swap(nums, p, r);

        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, r, i);

        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
//        assertEquals(4, findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
        assertEquals(5, findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 2));
    }
}
