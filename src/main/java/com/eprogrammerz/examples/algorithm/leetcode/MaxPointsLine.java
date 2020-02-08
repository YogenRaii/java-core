package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class MaxPointsLine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int count = 0;

        for (int i = 0; i < points.length; i++) {

            Map<String, Integer> map = new HashMap<>();

            int samep = 1;

            for (int j = 0; j < points.length; j++) {

                if (i == j) continue;

                int[] p1 = points[i];
                int[] p2 = points[j];

                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    samep++;
                    continue;
                }

                int dy = p2[1] - p1[1];
                int dx = p2[0] - p1[0];

                int gcd = gcd(dy, dx);

                String key = dx / gcd + "#" + dy / gcd;

                if (map.containsKey(key)) map.put(key, map.get(key) + 1);
                else map.put(key, 2);

                count = Math.max(count, samep + map.get(key) - 1);
            }

            count = Math.max(count, samep);
        }

        return count;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    @Test
    public void test() {
        assertEquals(2, maxPoints(new int[][] { {0,0},{1,65536},{65536,0}}));
        assertEquals(3, maxPoints(new int[][] { {4,0},{4,-1},{4,5}}));
    }
}

