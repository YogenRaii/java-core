package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 */
public class BinaryTreeTilt {
    private Map<TreeNode, Integer> nodeSum = new HashMap<>();
    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);

        int rootTilt = Math.abs(leftSum - rightSum);
        return rootTilt + findTilt(root.left) + findTilt(root.right);
    }

    private int findSum(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (nodeSum.containsKey(root)) {
            sum = nodeSum.get(root);
        } else {
            sum = root.val + findSum(root.left) + findSum(root.right);
            nodeSum.put(root, sum);
        }

        return sum;
    }

    /**
     *          6
     *        /   \
     *       3     7
     *      / \     \
     *     2   5     1
     *                \
     *                10
     * <p>
     * 6 -> 3 -> 2 -> 5 -> 7 -> 1 -> 10
     */
    @Test
    public void test1() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(1);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right.right = new TreeNode(10);

        assertEquals(32, findTilt(root));
    }
}
