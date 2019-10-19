package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 */
public class ClosestPoint2Origin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((e1, e2) -> {
            return Double.compare(e2.dis, e1.dis);
        });

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            double dis = Math.sqrt(x * x + y * y);
            pq.add(new Pair(dis, point));

            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] res = new int[K][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            res[i++] = p.point;
        }
        return res;
    }

    @Test
    public void test1() {
        int[][] points = new int[][]{
                {1, 3},
                {-2, 2}
        };
        int[][] kClosest = kClosest(points, 1);
        int[][] expected = new int[][] {{-2, 2}};
        assertThat(kClosest, is(expected));
    }
}

class Pair {
    double dis;
    int[] point;

    Pair(double dis, int[] point) {
        this.dis = dis;
        this.point = point;
    }
}