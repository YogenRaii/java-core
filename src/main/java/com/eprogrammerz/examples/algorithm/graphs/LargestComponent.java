package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/largest-component-size-by-common-factor/
 */
public class LargestComponent {
    public int largestComponentSize(int[] A) {
        int[] parents = new int[100001];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }


        for (int a: A) {
            for (int j = (int) Math.sqrt(a); j >= 2; j--) {
                union(parents, a, j);
                union(parents, a, a / j);
            }
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        int max = 0;

        for (int a: A) {
            int k = root(parents, a);
            int curr = countMap.getOrDefault(k, 0) + 1;
            if (curr > max) max = curr;
            countMap.put(k, curr);
        }

        return max;
    }

    private int root(int[] parents, int u) {
        while (u != parents[u]) {
            u = parents[u];
        }
        return u;
    }

    private void union(int[] parents, int u, int v) {

        parents[root(parents, v)] = parents[root(parents, u)];
    }

    @Test
    public void test() {
        assertEquals(8, largestComponentSize(new int[] {2,3,6,7,4,12,21,39}));
    }
}
