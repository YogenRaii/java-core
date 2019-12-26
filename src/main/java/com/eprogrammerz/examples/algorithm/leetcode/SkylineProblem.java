package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/the-skyline-problem/
 */
public class SkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> l = new ArrayList<>();

        int n = buildings.length;

        if (n == 0) return l;

        // we'll create points with x-value and height and mark if it is start
        // or end for that particular building
        int[][] points = new int[2 * n][3];

        for (int i = 0, j = 0; i < n; i++, j += 2) {
            int start = buildings[i][0];
            int end = buildings[i][1];
            int height = buildings[i][2];

            points[j] = new int[]{start, height, 0}; // points[2] == 0 -> start
            points[j + 1] = new int[]{end, height, 1}; // points[2] == 1 -> end
        }

        // now sort points with start
        // if start are equals, then sort them with height or start/end to cover corner cases
        Arrays.sort(points, (p1, p2) -> {
            int diff = p1[0] - p2[0];

            if (diff == 0) {
                // if both are start point, then we process taller building
                if (p1[2] == 0 && p2[2] == 0) {
                    return p2[1] - p1[1];
                } else if (p1[2] == 1 && p2[2] == 1) { // if both are end point, then we process shorter building first
                    return p1[1] - p2[1];
                } else {
                    return p1[2] - p2[0]; // if start of one is end of other, then start has to be processed first
                }
            }
            return diff;
        });

        /**
         * 1. have priority queue starting with element 0
         *    and max = 0
         * 2. for each point, if it is
         *    a) start, then put height h into pq, if it changes max, then add (start, h) into result list
         *    b) end, then remove height h from pq, if it changes max, then add (end, max) int result list
         *
         *
         * Since PriorityQueue has remove with time O(n), overall Time O(n^2)
         * But, TreeMap has O(logn) for remove as well. So, we'll use TreeMap
         */

        TreeMap<Integer, Integer> pq = new TreeMap<>((i1, i2) -> i2 - i1);
        pq.put(0, 1);
        int max = 0;

        for (int[] point : points) {
            if (point[2] == 0) { // start
                int height = point[1];
                pq.put(height, pq.getOrDefault(height, 0) + 1);

                if (max == pq.firstKey()) continue;

                max = pq.firstKey();
                l.add(newArrayList(point[0], height));
            } else { // end
                int rem = pq.get(point[1]) - 1;
                if (rem == 0) {
                    pq.remove(point[1]);
                } else {
                    pq.put(point[1], rem);
                }

                if (max == pq.firstKey()) continue;

                max = pq.firstKey();

                l.add(newArrayList(point[0], max));
            }
        }

        return l;
    }

    @Test
    public void test() {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> points = getSkyline(buildings);

        List<List<Integer>> expected = newArrayList(newArrayList(2, 10), newArrayList(3, 15),
                newArrayList(7, 12), newArrayList(12, 0), newArrayList(15, 10),
                newArrayList(20, 8), newArrayList(24, 0));

        assertThat(points, is(expected));
    }
}
