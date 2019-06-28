package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary search tree T, where each node contains a positive integer, and an integer K, you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
 *
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 *
 * Notes
 *
 * Your solution should run in linear time and not take memory more than O(height of T).
 * Assume all values in BST are distinct.
 */
public class TwoSumBinaryTree {
    public int t2Sum(TreeNode root, int target) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int y = target - node.val;

            if (exists(root, y, node)) {
                return 1;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return 0;
    }

    private boolean exists(TreeNode node, int target, TreeNode current) {
        if (node == null) return false;
        if (node.val == target && node != current) return true;

        if (node.val > target) return exists(node.left, target, current);
        else return exists(node.right, target, current);
    }

    @Test
    public void testT2Sum() {
        TreeNode root = new TreeNode(588);
        root.left = new TreeNode(134);
        root.right = new TreeNode(765);

        root.left.left = new TreeNode(35);
        root.left.right = new TreeNode(198);

        root.left.left.right = new TreeNode(55);

        int exists = t2Sum(root, 253);
        System.out.println(exists);
    }
}
