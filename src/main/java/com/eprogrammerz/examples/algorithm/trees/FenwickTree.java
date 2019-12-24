package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Representation to calculate prefix sum in O(logn) time
 */
public class FenwickTree {
    /**
     * Create binary indexed tree is basically updating it
     *
     * @param arr
     * @return
     */
    public int[] createBit(int[] arr) {
        int n = arr.length;
        int[] bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            updateBit(bit, i + 1, arr[i]);
        }

        return bit;
    }

    public void updateBit(int[] bit, int idx, int val) {
        while (idx < bit.length) {
            bit[idx] += val;
            idx = nextIndex(idx);
        }
    }

    private int nextIndex(int idx) {
        return idx + (idx & (-idx));
    }

    /**
     * idx is index in input array
     * We need to look until we reach end of parents of nodes
     *
     * @param idx
     * @return
     */
    public int prefixSum(int[] bit, int idx) {
        // bit index is arr_index + 1
        idx = idx + 1;
        int sum = 0;
        while (idx > 0) {
            sum += bit[idx];
            idx = parentIdx(idx);
        }
        return sum;
    }

    private int parentIdx(int idx) {
        return idx - (idx & (-idx));
    }

    @Test
    public void test() {
        int[] arr = new int[]{3, 2, -1, 6, 5, 4, -3};
        int[] bit = createBit(arr);

        assertEquals(3, prefixSum(bit, 0));
        assertEquals(5, prefixSum(bit, 1));
        assertEquals(4, prefixSum(bit, 2));
        assertEquals(10, prefixSum(bit, 3));
        assertEquals(15, prefixSum(bit, 4));
        assertEquals(19, prefixSum(bit, 5));
        assertEquals(16, prefixSum(bit, 6));
    }
}
