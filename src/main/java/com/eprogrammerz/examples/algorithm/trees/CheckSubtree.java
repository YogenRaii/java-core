package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class CheckSubtree {

    @Test
    public void testSubtree() {

        /**
         *          10
         *       /     \
         *     7         12
         *   /   \        \
         *  4     8        15
         *                  \
         *                   17
         *
         */

        Node root = new Node(10);
        root.left = new Node(7);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.right.right = new Node(17);

        /**
         *     7
         *   /   \
         *  4     8
         */
        Node that = new Node(7);
        that.left = new Node(4);
        that.right = new Node(8);

        assertTrue(root.isSubtree(that));

        /**
         *     7
         *   /   \
         *  4     8
         *   \
         *    10
         */
        that.left.right = new Node(10);
        assertFalse(root.isSubtree(that));
    }
}
