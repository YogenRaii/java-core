package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) return null;

        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);

        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node, new UndirectedGraphNode(node.label));

        while (!stack.isEmpty()) {
            UndirectedGraphNode sourceU = stack.pop();

            List<UndirectedGraphNode> neighbors = sourceU.neighbors;

            UndirectedGraphNode clonedU = visited.get(sourceU);

            for (UndirectedGraphNode neighbor: neighbors) {
                UndirectedGraphNode clonedV = visited.get(neighbor);

                if (clonedV == null) {
                    stack.push(neighbor);

                    clonedV = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor, clonedV);
                }
                clonedU.neighbors.add(clonedV);
            }
        }

        return visited.get(node);
    }

    @Test
    public void testCloneGraph() {

        /**
         *                  6
         *                /   \
         *               4  <- 5
         *             /  \     \
         *            1    2    3
         *
         */
        UndirectedGraphNode a = new UndirectedGraphNode(1);
        UndirectedGraphNode b = new UndirectedGraphNode(2);
        UndirectedGraphNode c = new UndirectedGraphNode(3);
        UndirectedGraphNode d = new UndirectedGraphNode(4);
        d.neighbors = Arrays.asList(a, b);
        UndirectedGraphNode e = new UndirectedGraphNode(5);
        e.neighbors = Arrays.asList(c, d);
        UndirectedGraphNode f = new UndirectedGraphNode(6);
        f.neighbors = Arrays.asList(d, e);
        System.out.println(f);

        UndirectedGraphNode newGraph = cloneGraph(f);
        System.out.println(newGraph);
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "(" + label + ")";
    }
}
