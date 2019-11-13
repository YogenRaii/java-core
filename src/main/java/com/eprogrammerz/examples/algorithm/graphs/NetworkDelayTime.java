package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] time: times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph[u].add(new int[] {v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        pq.offer(new int[] {K, 0});

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;
        dist[0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            dist[curr[0]] = Math.min(curr[1], dist[curr[0]]);

            for (int[] neighbor: graph[curr[0]]) {
                if (dist[neighbor[0]] == Integer.MAX_VALUE) {
                    pq.add(new int[] {neighbor[0], neighbor[1] + curr[1]});
                } else if (neighbor[1] + curr[1] < dist[neighbor[0]]) {
                    pq.add(new int[] {neighbor[0], neighbor[1] + curr[1]});
                }

            }
        }

        int max = Integer.MIN_VALUE;

        for (int d: dist) {
            if (d > max) {
                max = d;
            }

            if (d == Integer.MAX_VALUE) return -1; // this node never reached
        }

        return max;
    }

    @Test
    public void test() {
        assertEquals(2, networkDelayTime(new int[][] {{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    }
}
