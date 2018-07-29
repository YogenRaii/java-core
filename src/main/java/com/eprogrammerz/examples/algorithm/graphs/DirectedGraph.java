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

    public List<Node> findRoute(Node start, Node end) {
        List<Node> tempRoute = new ArrayList<>();
        List<Node> route = new ArrayList<>();
        dfs(start,end, tempRoute, route);
        return route;
    }

    public void dfs(Node start, Node end, List<Node> tempRoute, List<Node> route) {
        start.visited = true;
        tempRoute.add(start);

        if (start.id == end.id) {
            route.addAll(tempRoute);
        }

        List<Node> connections = start.connections;

        if (connections != null) {
            for (Node connection: connections) {
                if (!connection.visited) {
                    dfs(connection, end, tempRoute, route);
                    tempRoute.remove(tempRoute.size()-1);
                }
            }
        }
    }
}
