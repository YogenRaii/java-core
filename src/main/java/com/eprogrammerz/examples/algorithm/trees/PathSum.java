package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * with given tree and target, find if there is path to sum value equals to target
 */
public class PathSum {
    public int exists(TreeNode root, int target) {

        return findPathSum(root, target) ? 1 : 0;
    }

    private boolean findPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == target) return true;

        return findPathSum(root.left, target - root.val) || findPathSum(root.right, target - root.val);
    }

    /**
     *         6
     *       /   \
     *      3     7
     *     / \     \
     *    2   5     9
     */

    @Test
    public void testExists() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(9);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        assertEquals(1, exists(root, 14));

        // add right node to rightest node on last level
        root.right.right.right = new TreeNode(10);
        assertEquals(1, exists(root, 32));
    }
}
