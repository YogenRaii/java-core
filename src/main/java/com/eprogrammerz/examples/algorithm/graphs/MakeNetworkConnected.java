package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 */
public class MakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        int extra = 0;

        int[] parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;

        for (int[] con: connections) {
            int u = con[0];
            int v = con[1];

            if (root(parents, u) != root(parents, v)) {
                union(parents, u, v);
            } else {
                extra++;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int p: parents) {
            set.add(root(parents, p));
        }

        int comp = set.size();

        if (comp - extra <= 1) return comp - extra == 1 ? extra: comp - 1;

        return -1;
    }

    private void union(int[] parents, int u, int v) {
        parents[root(parents, v)] = parents[root(parents, u)];
    }

    private int root(int[] parents, int u) {
        while (u != parents[u]) {
            u = parents[u];
        }
        return u;
    }

    @Test
    public void test1() {
        int[][] connections = new int[][] {{0,1},{0,2},{0,3},{1,2},{1,3}};
        assertEquals(2, makeConnected(6, connections));
    } 
    
    @Test
    public void test2() {
        int[][] connections = new int[][] {{0,1},{0,2},{3,4},{2,3}};
        assertEquals(0, makeConnected(5, connections));
    }
}
