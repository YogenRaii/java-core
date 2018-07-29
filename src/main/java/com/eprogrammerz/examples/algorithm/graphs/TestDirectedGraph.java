package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Yogen Rai
 */
public class TestDirectedGraph {
    @Test
    public void testRouteBetweenNodes() {
        /**
         *          1       2       3
         *            \    /       /
         *              4    <-   5
         *                \    /
         *                  6
         */
        DirectedGraph graph = new DirectedGraph();
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        d.connections = Arrays.asList(a, b);
        Node e = new Node(5);
        e.connections = Arrays.asList(c, d);
        Node f = new Node(6);
        f.connections = Arrays.asList(d,e);

//        assertTrue(graph.isRouteBetween(f, a)); // OK
//        assertFalse(graph.isRouteBetween(a, c)); // OK
//        assertFalse(graph.isRouteBetween(a,f));
        assertTrue(graph.isRouteBetween(e,a));
    }
}
