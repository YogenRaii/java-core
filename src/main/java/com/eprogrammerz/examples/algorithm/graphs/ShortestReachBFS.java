package com.eprogrammerz.examples.algorithm.graphs;

import java.util.*;

/**
 * @author Yogen Rai
 *
 * Consider an undirected graph consisting of n nodes where each node is labeled from 1  to n  and the edge between
 * any two nodes is always of length . We define node  to be the starting position for a BFS.
 * Given a graph, determine the distances from the start node to each of its descendants and
 * return the list in node number order, ascending. If a node is disconnected, it's distance should be .
 */
public class ShortestReachBFS {
    public static class Graph {
        private Integer EDGE_DISTANCE = 6;

        private Node[] nodes;

        public Graph(int size) {
            this.nodes = new Node[size];

            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        public void addEdge(int start, int end) {
            nodes[start].connections.add(end);
            nodes[end].connections.add(start);
        }

        public int[] shortestReach(int start) {
            int[] distances = new int[nodes.length];
            Arrays.fill(distances, -1);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            distances[start] = 0;

            while (!queue.isEmpty()) {
                Integer node = queue.poll();

                for(Integer neighbor: nodes[node].connections) {
                    if (distances[neighbor] == -1) {
                        distances[neighbor] = distances[node] + EDGE_DISTANCE;
                        queue.add(neighbor);
                    }
                }
            }
            return distances;
        }

        private class Node {
            int id;
            List<Integer> connections = new ArrayList<>();

            Node(int id) {
                this.id = id;
            }

            @Override
            public String toString() {
                return "(" + id + ")";
            }
        }
    }

    public static void main(String[] args) {
        int nodes = 4;

        Graph graph = new Graph(nodes);

        // add edges -> node 1 and node 2
        //           -> node 1 and node 3
        graph.addEdge(0,1);
        graph.addEdge(0,2);

        // starting node 1
        int start = 0;
        int[] reaches = graph.shortestReach(start);

        for(int i = 0; i < reaches.length; i++) {
            if (start != i) System.out.print(reaches[i] + " ");
        }
    }

}
