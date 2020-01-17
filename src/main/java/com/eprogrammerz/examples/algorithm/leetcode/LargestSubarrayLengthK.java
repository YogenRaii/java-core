package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 *
 * largest subarray is contiguous subarray whose first different element is larger than other subarray
 *
 * return largest subarray of length k from all contiguous subarray of length k from given array
 */
public class LargestSubarrayLengthK {
    public int[] largestSubarray(int[] arr, int k) { // arr.length >= k
        // find subarray of length k
        // see if it is largest compared to temp_result
        // keep on going until you have subarray

        int n = arr.length;

        int[] subarr = new int[k];

        System.arraycopy(arr, 0, subarr, 0, k);

        for (int i = 1; i <= n - k; i++) {
            boolean larger = false;

            for (int j = i, m = 0; j < i + k; j++, m++) {
                if (arr[j] > subarr[m]) {
                    larger = true;
                    break;
                }
            }

            if (larger) {
                System.arraycopy(arr, i, subarr, 0, k);
            }
        }

        return subarr;
    }

    @Test
    public void test() {
        assertArrayEquals(new int[] {4, 3, 2, 5}, largestSubarray(new int[] {1, 4, 3, 2, 5}, 4));
    }
}
