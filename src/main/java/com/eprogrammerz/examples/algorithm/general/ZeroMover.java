package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * move all the zeros to the end of the array
 * [1,0,2,0,9] -> [1,2,9,0,0]
 */
public class ZeroMover {
    public void moveZerosToEnd(int[] input) {
        int zeroIdx = 0;
        int nonZeroIdx = 0;

        while (zeroIdx < input.length && nonZeroIdx < input.length) {
            if (input[zeroIdx] == 0) {
                if (zeroIdx < nonZeroIdx && input[nonZeroIdx] != 0) {
                    swap(input, zeroIdx, nonZeroIdx);
                } else {
                    nonZeroIdx++;
                }
            } else {
                zeroIdx++;
                nonZeroIdx++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        int[] input = new int[] {1,0,2,0,9};
        moveZerosToEnd(input);
        assertArrayEquals(new int[] {1,2,9,0,0}, input);
    }
}
