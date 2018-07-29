package com.eprogrammerz.examples.algorithm.graphs;

import java.util.*;

public class UndirectedGraph {

    private List<Node> nodes;

    public UndirectedGraph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public Node findNode(Node start, int targetId) {
        if (start == null) {
            throw new IllegalArgumentException("Graph should have at least one Node.");
        }

        if (start.id == targetId) {
            return start;
        }

        Queue<Node> neighbors = new LinkedList<>();
        neighbors.add(start);

        while (!neighbors.isEmpty()) {
            Node currentNode = neighbors.poll();
            currentNode.visited = true;

            if (currentNode.id == targetId) return currentNode;

            List<Node> cons = currentNode.connections;

            if (cons != null) {
                for(Node con: cons) {
                    if (!con.visited) neighbors.add(con);
                }
            }
        }

        return null;
    }
}
