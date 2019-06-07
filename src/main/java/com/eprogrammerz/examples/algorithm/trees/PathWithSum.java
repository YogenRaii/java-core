package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PathWithSum {
    @Test
    public void testFindPath() {
        /**
         *          10
         *       /     \
         *     7         2
         *   /   \        \
         *  3     4        8
         *                  \
         *                   12
         *
         */

        Node root = new Node(10);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(8);
        root.right.right.right = new Node(12);

        assertEquals(3, root.findPaths(20));
    }
}
