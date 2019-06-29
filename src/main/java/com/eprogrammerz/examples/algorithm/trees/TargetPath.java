package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TargetPath {
    @Test
    public void testFindPath() {
        /**
         *          10
         *       /     \
         *     7         2
         *   /   \        \
         *  3     4        8
         *         \        \
         *          5        12
         *
         *  pathToTarget(12) = [10,2,8,12]
         *
         */
        Node root = new Node(10);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.right = new Node(12);

        assertEquals(Arrays.asList(10, 2, 8, 12), root.pathToTarget(12));

        assertEquals(Arrays.asList(10, 7, 4), root.pathToTarget(4));
        assertEquals(Arrays.asList(10, 7, 4, 5), root.pathToTarget(5));
    }
}
