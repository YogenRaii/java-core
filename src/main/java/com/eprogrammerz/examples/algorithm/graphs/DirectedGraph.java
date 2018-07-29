package com.eprogrammerz.examples.algorithm.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yogen Rai
 *
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class DirectedGraph {
    private List<Node> nodes = new ArrayList<>();

    // using BFS
    public boolean isRouteBetween(Node start, Node end) {
        Queue<Node> neighbors = new LinkedList<>();

        if (start.id == end.id) return true;

        neighbors.add(start);

        while (!neighbors.isEmpty()) {
            Node neighbor = neighbors.poll();
            neighbor.visited = true;

            if (neighbor.id == end.id) return true;

            List<Node> connections = neighbor.connections;
            if (connections != null) {
                for(Node connection: connections) {
                    if (!connection.visited) neighbors.add(connection);
                }
            }
        }
        return false;
    }

    public void isRouteBetween(Node start, Node end, List<Node> route) {
        start.visited = true;

        System.out.println(start.id + " ");
        if (start.id == end.id) {
            route.add(start);
            return;
        }

        List<Node> connections = start.connections;

        if (connections != null) {
            for (Node connection: connections) {
                if (!connection.visited) {
                    isRouteBetween(connection, end);
                }
            }
        }
    }
}
