package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree, return a 2-D array with vertical order traversal of it.
 * Go through the example and image for more details.
 *
 * Example :
 * Given binary tree:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 */
public class BinaryTreeMaximumDepth {
    public int maxDepth(TreeNode root) {
        int depth = 0;

        if (root == null) return depth;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            depth++;

            // iterative over particular level
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }

    @Test
    public void testMaxDepth() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(9);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        assertEquals(3, maxDepth(root));

        // add right node to rightest node on last level
        root.right.right.right = new TreeNode(10);
        assertEquals(4, maxDepth(root));
    }

    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;

        return Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right)) + 1;
    }

    @Test
    public void testMaxDepthRecursive() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(9);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        assertEquals(3, maxDepthRecursive(root));

        // add right node to rightest node on last level
        root.right.right.right = new TreeNode(10);
        assertEquals(4, maxDepthRecursive(root));
    }
}