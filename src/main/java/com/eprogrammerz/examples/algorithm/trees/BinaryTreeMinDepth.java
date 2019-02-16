package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 *  NOTE : The path has to end on a leaf node.
 * Example :
 *
 *          1
 *         /
 *        2
 * min depth = 2.
 */
public class BinaryTreeMinDepth {

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    @Test
    public void testMinDepth() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        assertEquals(2, minDepth(root));

        root.left.right = new TreeNode(4);
        assertEquals(3, minDepth(root));

        root.left.right.left = new TreeNode(5);
        assertEquals(4, minDepth(root));

        root.right = new TreeNode(3);
        assertEquals(2, minDepth(root));

        /**
         *                              9
         *                             / \
         *                           11   10
         *                          /  \    \
         *                         7    5   12
         *                             / \    \
         *                            8   1    6
         *                                     /
         *                                    2
         *
         *                        Min Depth = 3
         */
        TreeNode root1 = new TreeNode(9);
        root1.right = new TreeNode(10);
        root1.left = new TreeNode(11);

        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(12);

        root1.left.right.left = new TreeNode(8);
        root1.left.right.right = new TreeNode(1);

        root1.right.right.right = new TreeNode(6);
        root1.right.right.right.left = new TreeNode(2);

        assertEquals(3, minDepth(root1));
    }
}
