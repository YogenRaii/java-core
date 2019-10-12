package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * <p>
 * Return the intersection of these two interval lists.
 * <p>
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 */
public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;

        List<int[]> l = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int[] a = A[i];
            int[] b = B[j];

            // if either of start or end falls within the range of either interval,
            // then add intersection
            if (((b[0] <= a[0] && a[0] <= b[1]) || (b[0] <= a[1] && a[1] <= b[1])) ||
                    (a[0] <= b[0] && b[0] <= a[1]) || (a[0] <= b[1] && b[1] <= a[1])) {
                l.add(new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])});
            }

            if (a[1] < b[1]) {
                i++;
            } else {
                j++;
            }
        }
        int[][] res = new int[l.size()][2];
        int idx = 0;
        for (int[] m : l) {
            res[idx++] = m;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] a = new int[][]{
                {3, 5},
                {9, 20}
        };
        int[][] b = new int[][]{
                {4, 5},
                {7, 10},
                {11, 12},
                {14, 15},
                {16, 20}
        };
        int[][] merged = intervalIntersection(a, b);

        assertArrayEquals(new int[]{4, 5}, merged[0]);
        assertArrayEquals(new int[]{9, 10}, merged[1]);
        assertArrayEquals(new int[]{11, 12}, merged[2]);
        assertArrayEquals(new int[]{14, 15}, merged[3]);
        assertArrayEquals(new int[]{16, 20}, merged[4]);
    }
}
