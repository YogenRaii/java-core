package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * <p>
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class ClosestPoint2Origin {
    private Random rnd = new Random();

    /**
     * With Sort - Time O(nlogn)
     * With heap - Time O(nlogk)
     * With Quick Sort - Time O(n)
     *
     * @param points
     * @param k
     * @return
     */
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;

        if (n == k) return points;

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int pivotIdx = l + rnd.nextInt(r - l + 1);
            int pIdx = partition(points, l, r, pivotIdx);

            if (k == pIdx) return Arrays.copyOfRange(points, 0, k);

            if (pIdx > k) {
                r = pIdx - 1;
            } else {
                l = pIdx + 1;
            }
        }
        return null;
    }

    private int partition(int[][] points, int l, int r, int p) {
        int i = l;

        int pivot = dist(points[p]);

        swap(points, p, r);

        for (int j = l; j < r; j++) {
            if (dist(points[j]) < pivot) {
                swap(points, i, j);
                i++;
            }
        }

        swap(points, i, r);

        return i;
    }

    private int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    @Test
    public void test1() {
        int[][] points = new int[][]{
                {1, 3},
                {-2, 2}
        };
        int[][] kClosest = kClosest(points, 1);
        int[][] expected = new int[][]{{-2, 2}};
        assertThat(kClosest, is(expected));
    }

    @Test
    public void test2() {
        int[][] points = {{0, 1}, {1, 0}};
        int[][] expected = {{0, 1}, {1, 0}};
        assertThat(kClosest(points, 2), is(expected));
    }
}
