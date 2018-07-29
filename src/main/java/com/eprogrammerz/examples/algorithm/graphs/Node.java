package com.eprogrammerz.examples.algorithm.graphs;

import java.util.List;

/**
 * @author Yogen Rai
 */
class Node {
    int id;
    List<Node> connections;
    boolean visited;

    public Node(int id) {
        this.id = id;
    }
}
