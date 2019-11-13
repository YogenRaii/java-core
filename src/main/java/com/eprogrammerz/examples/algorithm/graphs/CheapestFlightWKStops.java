package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightWKStops {
    // Dijkstra's algorithm
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // create adj list to represent graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] flight: flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            graph[u].add(new int[] {v, cost});
        }

        // to track which cities has been visited
        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        q.add(new int[] {src, 0, K});

        while (!q.isEmpty()) {
            int[] city = q.poll();

            if (city[0] == dst) {
                return city[1];
            }

            if (city[2] >= 0) {
                for (int[] neigbhor: graph[city[0]]) {
                    q.add(new int[] {neigbhor[0], city[1] + neigbhor[1], city[2] - 1});
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(200, findCheapestPrice(3, new int[][] {{0,1,100}, {1,2,100}, {0,2,500}}, 0, 2, 1));
        assertEquals(500, findCheapestPrice(3, new int[][] {{0,1,100}, {1,2,100}, {0,2,500}}, 0, 2, 0));
        assertEquals(6, findCheapestPrice(4, new int[][] {{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
    }
}
