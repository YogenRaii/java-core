package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class BinarySearchTree {

    @Test
    public void testBstInsertion() {
        Node root = new Node(10);
        root.insert(0);
        root.insert(12);
        root.insert(-1);
        root.insert(5);
        root.insert(11);
        root.insert(20);
        root.insert(17);
        root.insert(99);

        assertTrue(root.contains(11)); // (11)

        assertTrue(root.contains(10)); // (10)

        assertFalse(root.contains(100)); // null

        assertTrue(root.validate());
    }

    @Test
    public void testValidateBst() {
        Node root = new Node(10);
        root.left = new Node(0);
        root.right = new Node(12);

        root.left.left = new Node(-1);
        root.left.right = new Node(5);

        root.right.left = new Node(11);
        root.right.right = new Node(20);

        root.right.right = new Node(-2);

        assertTrue(root.validate());
    }
}