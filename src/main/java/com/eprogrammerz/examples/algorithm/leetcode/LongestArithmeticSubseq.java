package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/
 */
public class LongestArithmeticSubseq {
    public int longestSubsequence(int[] arr, int difference) {
        //1,5,7,8,5,3,4,2,1, d = -2 [arr[i] - arr[j] = d, arr[i] + d = arr[j]]

        /*
        // Time O(n^2)
        // Space O(n)

        int[] mem = new int[arr.length];
        Arrays.fill(mem, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] - arr[j] == difference) {
                    mem[i] = Math.max(mem[i], mem[j] + 1);
                }
            }
        }
        int len = mem[0];
        for (int i = 1; i < mem.length; i++) {
            if (len < mem[i]) len = mem[i];
        }
        return len;

         */

        // Time O(n)
        // Space O(n)
        // d[i] = d[i-k] + 1
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int count = map.getOrDefault(arr[i] - difference, 0) + 1;
            map.put(arr[i], count);
        }

        int len = Integer.MIN_VALUE;
        for (int l: map.values()) {
            if (l > len) len = l;
        }
        return len;
    }

    @Test
    public void test() {
        assertEquals(4, longestSubsequence(new int[] {1,2,3,4}, 1));
        assertEquals(1, longestSubsequence(new int[] {1,3,5,7}, 1));
        assertEquals(4, longestSubsequence(new int[] {1,5,7,8,5,3,4,2,1}, -2));
    }
}
