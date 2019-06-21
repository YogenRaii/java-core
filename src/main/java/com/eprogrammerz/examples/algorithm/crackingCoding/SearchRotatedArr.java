package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in the array. You may assume that the array was originally sorted in increasing order.
 *
 * EXAMPLE
 * lnput:findSin{lS, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14} Output: 8 (the index of 5 in the array)
 */
public class SearchRotatedArr {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int midIdx = start + (end - start) / 2;
            int mid = arr[midIdx];

            if (mid == target) {
                return midIdx;
            }

            if (arr[end] >= arr[start]) { // increasing sequence
                if (mid < target) {
                    start = midIdx + 1;
                } else {
                    end = midIdx - 1;
                }
            } else {  // non-increasing sequence
                if (arr[start] > mid && target >= arr[start]) {
                    end = midIdx - 1;
                } else {
                    start = midIdx + 1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testSearchRotatedArr() {
        int[] arr = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        assertEquals(8, search(arr, 5));
        assertEquals(2, search(arr, 19));
        assertEquals(0, search(arr, 15));
        assertEquals(1, search(arr, 16));
        assertEquals(11, search(arr, 14));
        assertEquals(4, search(arr, 25));
        assertEquals(-1, search(arr, 21));
    }
}
