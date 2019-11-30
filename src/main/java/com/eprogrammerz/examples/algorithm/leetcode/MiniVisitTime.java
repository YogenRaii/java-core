package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 */
public class MiniVisitTime {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        int[] start = points[0]; // 1,1
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i]; // 3,4

            time += Math.max(Math.abs(start[0] - curr[0]), Math.abs(start[1] - curr[1]));
            start = curr;
        }
        return time;
    }

    @Test
    public void test() {
        assertEquals(7, minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
    }
}
