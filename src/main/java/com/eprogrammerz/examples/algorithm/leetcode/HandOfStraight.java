package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


/**
 * https://leetcode.com/problems/hand-of-straights/
 */
public class HandOfStraight {
    public boolean isNStraightHand(int[] hand, int W) {

        int n = hand.length;

        if (n % W != 0) return false;

        int k = n / W;

        int[] arr = new int[k];
        Arrays.fill(arr, W);

        Arrays.sort(hand);

        Map<Integer, LinkedList<Integer>> vmap = new HashMap<>();

        int curr = -1;

        for (int i = 0; i < n; i++) {
            int num = hand[i];
            if (vmap.containsKey(num) && vmap.get(num).size() > 0) {
                LinkedList<Integer> indices = vmap.get(num);
                int idx = indices.removeFirst();

                arr[idx]--;

                if (arr[idx] > 0)
                    vmap.computeIfAbsent(num + 1, s -> new LinkedList<>()).add(idx);
            } else {
                curr++;
                if (curr >= k) return false;

                arr[curr]--;
                if (arr[curr] > 0)
                    vmap.computeIfAbsent(num + 1, s -> new LinkedList<>()).add(curr);
            }
        }

        for (int count : arr) {
            if (count > 0) return false;
        }
        return true;
    }

    @Test
    public void test() {
        assertTrue(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
        assertFalse(isNStraightHand(new int[]{1, 2, 3, 4, 5}, 3));
        assertTrue(isNStraightHand(new int[]{2, 1}, 2));
    }
}
