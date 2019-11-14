package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/redundant-connection/
 */
public class RedundantConnection {
    /**
     * Kruskal's algorithm implementation
     *
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        // spanning tree
        int[] A = new int[edges.length + 1];
        // initialize
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        int[] res = new int[2];
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if (root(A, start) != root(A, end)) { // if two vertices have different root, then connect them with edge
                union(A, start, end);
            } else { // else, it is redundant
                res[0] = start;
                res[1] = end;
            }
        }
        return res;
    }

    private int root(int[] A, int v) {
        while (v != A[v]) {
            v = A[v];
        }
        return v;
    }

    private void union(int[] A, int u, int v) {
        A[root(A, v)] = A[root(A, u)];
    }

    @Test
    public void test() {
        /**
         * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
         * Output: [1,4]
         * Explanation: The given undirected graph will be like this:
         * 5 - 1 - 2
         *     |   |
         *     4 - 3
         */
        assertArrayEquals(new int[]{1, 4}, findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
    }
}
