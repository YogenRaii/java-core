package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * https://leetcode.com/problems/critical-connections-in-a-network/
 *
 * Tarjen's algorithm
 *
 * https://www.youtube.com/watch?v=CsGP_s_3GWg&list=PLdo5W4Nhv31bK5n8-RIGhvYs8bJbgJFDR&index=13&t=543s
 */
public class CriticalConnection {
    private int d = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> edge: connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] visitTime = new int[n];

        boolean[] visited = new boolean[n];

        dfs(0, graph, visited, visitTime, res);

        return res;
    }

    private void dfs(int u, List<Integer>[] graph, boolean[] visited, int[] visitTime, List<List<Integer>> res) {
        if (visited[u]) return;

        visited[u] = true;

        visitTime[u] = d;
        d++;

        for (int v: graph[u]) {
            if (!visited[v]) {

                dfs(v, graph, visited, visitTime, res);

                visitTime[v] = lowestVisitedTime(graph, u, v, visitTime);

                if (visitTime[v] > visitTime[u]) {
                    res.add(asList(u, v));
                }
            }
        }
    }

    private int lowestVisitedTime(List<Integer>[] graph, int u, int v, int[] visitTime) {
        int min = visitTime[v];

        for (int n: graph[v]) {
            if (n != u) {
                min = Math.min(visitTime[n], min);
            }
        }

        return min;
    }

    @Test
    public void test() {
        assertThat(criticalConnections(4, asList(asList(0,1), asList(1,2), asList(2,0), asList(1,3))), is(asList(asList(1,3))));
    }
}
