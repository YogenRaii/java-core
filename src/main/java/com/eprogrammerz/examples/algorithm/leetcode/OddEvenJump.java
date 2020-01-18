package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/odd-even-jump/
 */
public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        int n = A.length;

        if (n == 0) return 0;

        int count = 0; // last element counts 1

        boolean[] odd = new boolean[n]; // if even jump can be made from i
        boolean[] even = new boolean[n]; // if odd jump can be made from i

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);

        odd[n - 1] = true;
        even[n - 1] = true;

        for (int i = n - 2; i >= 0; i--) {
            int curr = A[i];

            Integer lower = map.floorKey(curr);
            Integer higher = map.ceilingKey(curr);

            if (lower != null) { // if lower value exists in forward dir, then should be able to make even jump, and odd jump after that
                even[i] = odd[map.get(lower)];
            }

            if (higher != null) {
                odd[i] = even[map.get(higher)];
            }

            map.put(curr, i);
        }

        for (boolean b: odd) { // since jump start from odd i.e. 1
            if (b) count++;
        }

        return count;
    }

    @Test
    public void test() {
        assertEquals(2, oddEvenJumps(new int[]{10, 13, 12, 14, 15}));
        assertEquals(3, oddEvenJumps(new int[]{2, 3, 1, 1, 4}));
        assertEquals(3, oddEvenJumps(new int[]{5, 1, 3, 4, 2}));
        assertEquals(6, oddEvenJumps(new int[]{1, 2, 3, 2, 1, 4, 4, 5}));
    }
}
