package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class BalancedBinarySearchTree {
    public boolean isBalancedBST(Node tree) {
        if (tree == null) return true;
        int heightDiff = Math.abs(height(tree.left) - height(tree.right));
        if (heightDiff > 1) {
            return false;
        }
        return isBalancedBST(tree.left) && isBalancedBST(tree.right);
    }

    private int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    @Test
    public void testBalancedBinarySearchTree() {

        /**
         *          10
         *       /     \
         *     7         12
         *   /   \        \
         *  4     8        15
         *
         */

        Node root = new Node(10);
        root.left = new Node(7);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(8);
        root.right.right = new Node(15);

        assertTrue(isBalancedBST(root));


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
        root.right.right.right = new Node(17);
        assertFalse(isBalancedBST(root));
    }
}
