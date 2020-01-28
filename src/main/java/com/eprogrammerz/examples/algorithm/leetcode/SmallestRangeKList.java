package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 */
public class SmallestRangeKList {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();

        if (n == 0) return new int[0];

        int x = 0, y = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[2] - i2[2]);

        for (int i = 0; i < n; i++) {
            List<Integer> l = nums.get(i);
            max = Math.max(l.get(0), max);
            pq.offer(new int[] {i, 0, l.get(0)});
        }

        while (pq.size() == n) {
            int[] curr = pq.poll();

            int r = curr[0];
            int c = curr[1];

            if (y - x > max - curr[2]) {
                x = nums.get(r).get(c);
                y = max;
            }

            if (c + 1 < nums.get(r).size()) {
                pq.offer(new int[] {r, c + 1, nums.get(r).get(c + 1)});
                max = Math.max(max, nums.get(r).get(c + 1));
            }
        }

        return new int[] {x, y};
    }

    @Test
    public void test() {
        assertThat(smallestRange(asList(asList(4,10,15,24,26), asList(0,9,12,20), asList(5,18,22,30))), is(new int[] {20,24}));
    }
}
