package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

/**
 * Design an algorithm to find the smallest K numbers in an array.
 */
public class SmallestK {
    public int[] findKSmallest(int[] arr, int k) {
        // use max heap so that max of current will be on root
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int i = 0; i < k; i++) { // O(k logk)
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {   // O(n logk)
            if (!pq.isEmpty() && pq.peek() > arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        int[] result = new int[k];

        int idx = 0;
        for (int n : pq) {
            result[idx++] = n;
        }

        return result;
    }

    @Test
    public void testFindSmallestK() {
        int[] input = new int[]{5, 1, 4, 3, 10, 6, 2};
        int[] expected = new int[]{3, 1, 2};
        int[] actual = findKSmallest(input, 3);
        assertArrayEquals(expected, actual);
    }
}
