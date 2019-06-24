package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest sum. Return the sum.
 *
 * EXAMPLE
 * lnput:2, -8, 3, -2, 4, -10 Output:5 (i.e•, {3, -2, 4})
 */
public class ContinuousSequence {
    /**
     * [2, -8, 3, -2, 4, -10]
     * sum arr: [2, -6, -3, -5, -1, -11]
     * 2
     * 3
     * 4
     */
    /**
     * O(n^2)
     *
     * @param arr
     * @return
     */
    public int[] largestSumSeq(int[] arr) {
        int sum = Integer.MIN_VALUE;

        List<Integer> sequence = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int tempSum = 0;
            List<Integer> tempSeq = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                tempSum += arr[j];
                tempSeq.add(arr[j]);
                if (tempSum > sum) {
                    sum = tempSum;
                    sequence.clear();
                    sequence.addAll(tempSeq);
                }
            }
        }

        int[] result = new int[sequence.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = sequence.get(i);
        }
        return result;
    }

    @Test
    public void testLargestSumSeq() {
        int[] arr = new int[]{2, -8, 3, -2, 4, -10};
        int[] actual = largestSumSeq(arr);
        int[] expected = new int[]{3, -2, 4};
        assertArrayEquals(expected, actual);
    }
}
