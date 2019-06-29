package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * There are n islands and there are many bridges connecting them. Each bridge has some cost attached to it.
 * <p>
 * We need to find bridges with minimal cost such that all islands are connected.
 * <p>
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 * <p>
 * Example :
 * Input
 * <p>
 * Number of islands ( n ) = 4
 * 1 2 1
 * 2 3 4
 * 1 4 3
 * 4 3 2
 * 1 3 10
 */
public class CommutableIslands {

    class Edge implements Comparable<Edge> {
        int weight;
        int start;
        int end;

        Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    class Graph {
        List<Edge> edges;
        int[] arr;
        int n;

        Graph(int n) {
            this.n = n;
            this.arr = new int[n + 1];
            this.edges = new ArrayList<>();
        }

        void initialize() {
            for (int i = 0; i <= n; i++) {
                arr[i] = i;
            }
        }

        void addEdge(int start, int end, int weight) {
            edges.add(new Edge(start, end, weight));
        }

        public int kruskal() {
            initialize();
            int minCost = 0;
            Collections.sort(edges);

            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                int start = edge.start;
                int end = edge.end;

                if (root(start) != root(end)) {
                    minCost += edge.weight;
                    union(start, end);
                }
            }
            return minCost;
        }

        private void union(int start, int end) {
            arr[root(start)] = arr[root(end)];
        }

        private int root(int vertex) {
            while (vertex != arr[vertex])
                vertex = arr[vertex];
            return vertex;
        }
    }

    public int solve(int n, List<List<Integer>> bridges) {
        Graph graph = new Graph(n);
        for (List<Integer> bridge : bridges) {
            graph.addEdge(bridge.get(0), bridge.get(1), bridge.get(2));
        }

        return graph.kruskal();
    }

    @Test
    public void testSolve() {
        List<Integer> b1 = Arrays.asList(1, 2, 1);
        List<Integer> b2 = Arrays.asList(2, 3, 4);
        List<Integer> b3 = Arrays.asList(1, 4, 3);
        List<Integer> b4 = Arrays.asList(4, 3, 2);
        List<Integer> b5 = Arrays.asList(1, 3, 10);

        List<List<Integer>> bridges = Arrays.asList(b1, b2, b3, b4, b5);

        assertEquals(6, solve(6, bridges));
    }
}
