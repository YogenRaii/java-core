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

    public List<Integer> findPath(Node start, int targetId) {
        List<List<Integer>> paths = new ArrayList<>();
        findPath(start, targetId, paths, new ArrayList<>());

        List<Integer> shortest = paths.stream().min(Comparator.comparingInt(List::size)).orElse(null);
        return shortest;
    }

    private void findPath(Node node, int end, List<List<Integer>> paths, List<Integer> temp) {
        if (node == null) return;

        temp.add(node.id);
        node.visited = true;

        if (node.id == end) {
            paths.add(new ArrayList<>(temp));
            return;
        }

        List<Node> neighbors = node.connections;

        if (neighbors != null) {
            for (Node neighbor: neighbors) {
                if (!neighbor.visited) {
                    findPath(neighbor, end, paths, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }

    }
}
