package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;


/**
 * Given an array of integers A with even length, return true if and only if it is possible to reorder
 * it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 *
 * https://leetcode.com/problems/array-of-doubled-pairs/
 */
public class DoublePairArray {
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> m = new HashMap<>();

        for (int n: A) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        for (int n: A) {
            if (!m.containsKey(n)) continue; // n has already been processed
            int pair = 2 * n;  // n = 0, pair = 0, map [(0,1)]
            if (m.containsKey(pair)) {

                int updated = m.get(n) - 1; // 0
                if (updated == 0) m.remove(n);
                else {
                    m.put(n, updated);
                }

                if (pair != n) {
                    int updatedPair = m.get(pair) - 1; // -1
                    if (updatedPair == 0) m.remove(pair);
                    else {
                        m.put(pair, updatedPair);
                    }
                }
            }
        }
        return m.size() == 0;
    }

    @Test
    public void test() {
        assertTrue(canReorderDoubled(new int[] {0, 0}));
        assertTrue(canReorderDoubled(new int[] {1,2,1,-8,8,-4,4,-4,2,-2}));
    }
}
