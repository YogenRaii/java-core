package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * Searching for sorted array
 *
 * O(log n)
 */
public class BinarySearch {
    public static int findIndex(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == n) return mid;

            else if (arr[mid] < n) left = mid + 1;

            else right = mid - 1;
        }
        return -1;
    }

    @Test
    public void testFindIndex() {
        assertEquals(5, findIndex(new int[] {2,3,4,6,8,9,10}, 9));
        assertEquals(6, findIndex(new int[] {2,3,4,6,8,9,10}, 10));
        assertEquals(-1, findIndex(new int[] {2,3,4,6,8,9,10}, 11));
    }
}
