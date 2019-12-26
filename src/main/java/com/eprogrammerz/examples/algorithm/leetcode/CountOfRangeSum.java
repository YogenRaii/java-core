package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/count-of-range-sum/
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {

        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);

        long sum = 0;

        int count = 0;

        for (int n : nums) {
            sum += n;

            for (int cnt : map.subMap(sum - upper, true, sum - lower, true).values()) {
                count += cnt;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    @Test
    public void test() {
        assertEquals(3, countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
