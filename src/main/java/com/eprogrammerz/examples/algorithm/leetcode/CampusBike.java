package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/campus-bikes/
 */
public class CampusBike {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length;

        int n = bikes.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((p, q) -> {
            int d = p[2] - q[2];
            if (d == 0) {
                int w = p[0] - q[0];
                if (w == 0) return p[1] - q[1];
                return w;
            }
            return d;
        });

        for (int w = 0; w < m; w++) {
            for (int b = 0; b < n; b++) {
                int d = Math.abs(workers[w][0] - bikes[b][0]) +
                        Math.abs(workers[w][1] - bikes[b][1]);
                pq.offer(new int[]{w, b, d});
            }
        }

        int[] res = new int[m];

        boolean[] used = new boolean[n];

        Arrays.fill(res, -1);

        int count = 0;
        while (!pq.isEmpty() && count < m) {
            int[] curr = pq.poll();
            int w = curr[0];
            int b = curr[1];

            if (res[w] == -1 && !used[b]) {
                res[w] = b;
                used[b] = true;
                count++;
            }
        }

        return res;
    }

    @Test
    public void test() {
        int[] expected = {0, 8, 2, 7, 1, 5, 3, 4};
        int[][] workers = {{664, 994}, {3, 425}, {599, 913}, {220, 352}, {145, 348}, {604, 428}, {519, 183}, {732, 148}};
        int[][] bikes = {{611, 698}, {113, 338}, {579, 770}, {276, 588}, {948, 679}, {731, 525}, {925, 877}, {182, 281}, {39, 299}};
        assertArrayEquals(expected, assignBikes(workers, bikes));
    }
}
