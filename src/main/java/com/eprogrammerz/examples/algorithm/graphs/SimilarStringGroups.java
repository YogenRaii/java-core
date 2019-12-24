package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/similar-string-groups/
 */
public class SimilarStringGroups {
    public int numSimilarGroups(String[] A) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String v: A) {
            graph.put(v, new ArrayList<>());
        }

        for (int i = 0; i < A.length; i++) {
            String u = A[i];

            List<String> uNeighbors = graph.get(u);

            for (int j = i + 1; j < A.length; j++) {
                String v = A[j];
                List<String> vNeighbors = graph.get(v);

                if (edge(u, v)) {
                    uNeighbors.add(v);
                    vNeighbors.add(u);
                }
            }
        }

        Set<String> visited = new HashSet<>();

        int count = 0;

        for (String v: A) {
            if (!visited.contains(v)) {
                count++;
                dfs(visited, graph, v);
            }
        }

        return count;
    }

    private boolean edge(String u, String v) {
        int diff = 0;

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) != v.charAt(i)) diff++;
        }
        return diff == 2;
    }

    private void dfs(Set<String> visited, Map<String, List<String>> graph, String v) {
        if (visited.contains(v)) return;
        visited.add(v);

        List<String> neighbors = graph.get(v);

        for (String n: neighbors) {
            dfs(visited, graph, n);
        }
    }

    @Test
    public void test() {
        assertEquals(2, numSimilarGroups(new String[] {"tars", "star", "arts", "rats"}));
    }
}
