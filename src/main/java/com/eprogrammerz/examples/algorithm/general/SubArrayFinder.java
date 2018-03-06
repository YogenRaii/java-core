package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubArrayFinder {
    public int findSubArrayLength(int[] arr, int val) {
        if (arr == null) {
            throw new IllegalArgumentException("Array should be initialized.");
        }
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum > val) {
                    if (res > (j - i)) {
                        res = j - i;
                    }
                    break;
                }
            }
        }
        return res;
    }

    @Test
    public void testFindSubArrayLength() {
        assertEquals(3, findSubArrayLength(new int[]{1, 4, 45, 6, 0, 19}, 51));
        assertEquals(1, findSubArrayLength(new int[]{1, 10, 5, 2, 7}, 9));
        assertEquals(4, findSubArrayLength(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280));
        assertEquals(Integer.MAX_VALUE, findSubArrayLength(new int[]{1, 2, 4}, 280));
    }
}
