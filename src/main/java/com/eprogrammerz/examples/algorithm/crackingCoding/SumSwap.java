package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the two arrays the same sum.
 */
public class SumSwap {
    /**
     * EXAMPLE
     * Input: {4, 1, 2, 1, 1, 2} and {3, 6, 3, 3}
     * Output: {1, 3}
     *
     * @param arr1
     * @param arr2
     * @return
     */
    private int[] findSumSwapPair(int[] arr1, int[] arr2) {

        /**
         * sumA - a + b = sumB - b + a
         * 2(a-b) = sumA-sumB
         * (a-b) = (sumA-sumB)/2
         */
        Integer diff = getTarget(arr1, arr2);
        if (diff == null) return null;

        Set<Integer> set2 = getHashSet(arr2);

        for (int i = 0; i < arr1.length; i++) {
            int a = arr1[i];
            int b = diff + a;
            if (set2.contains(b)) {
                return new int[]{arr1[i], b};
            }
        }

        return null;
    }

    private Integer getTarget(int[] arr1, int[] arr2) {
        int sum1 = findSum(arr1);
        int sum2 = findSum(arr2);

        int diff = Math.abs(sum1 - sum2);
        if (diff % 2 != 0) return null;
        return diff / 2;
    }

    private Set<Integer> getHashSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            set.add(n);
        }
        return set;
    }

    private int findSum(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return sum;
    }

    @Test
    public void testFindSumSwap() {
        int[] arr1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] arr2 = new int[]{3, 6, 3, 3};
        int[] res = findSumSwapPair(arr1, arr2);
        assertArrayEquals(new int[]{4, 6}, res);
    }
}
