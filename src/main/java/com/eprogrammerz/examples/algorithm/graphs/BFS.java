package com.eprogrammerz.examples.algorithm.graphs;

import java.util.*;

class Node {
    int id;
    List<Node> connections;

    @Override
    public int hashCode() {
        int hash = 31;
        hash = hash * 17 + id;
        hash = hash * 17 + (connections == null ? 0 : connections.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o instanceof Node) {
            Node node = (Node) o;
            if (node.id != id) return false;

            List<Node> neighbors = node.connections;
            if (neighbors.size() == connections.size()) {
                for (int i = 0; i < neighbors.size(); i++) {
                    if (neighbors.get(i).id != connections.get(i).id) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }
}

public class BFS {

    public Node getNode(Node start, int targetId) {
        if (start == null) {
            throw new IllegalArgumentException("Graph should have at least one Node.");
        }

        if (start.id == targetId) {
            return start;
        }

        Queue<Node> neighbors = new LinkedList<>();
        neighbors.add(start);

        // to track visited nodes
        Set<Node> visitedNodes = new HashSet<>();
        visitedNodes.add(start);

        while (!neighbors.isEmpty()) {
            List<Node> currentNeighbors = neighbors.poll().connections;

            for(Node node: currentNeighbors) {

                if (node.id == targetId) {
                    return node;
                }

                // check if node is already in queue, if yes, don't add on queue
                if (!visitedNodes.contains(node)) {
                    neighbors.add(node);
                }

                visitedNodes.add(node);
            }
        }


        return null;
    }
}
