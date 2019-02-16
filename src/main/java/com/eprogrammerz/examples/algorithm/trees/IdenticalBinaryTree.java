package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 *
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Example :
 *
 * Input :
 *
 *    1       1
 *   / \     / \
 *  2   3   2   3
 *
 * Output :
 *   1 or True
 */
public class IdenticalBinaryTree {
    // do bfs at the same time and if any of node doesn't have
    // same value, return false
    public int isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return 0;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) return 0;

            if (node1.left != null) queue1.add(node1.left);
            if (node2.left != null) queue2.add(node2.left);

            if (node1.right != null) queue1.add(node1.right);
            if (node2.right != null) queue2.add(node2.right);
        }

        return queue1.isEmpty() && queue2.isEmpty() ? 1 : 0;
    }

    @Test
    public void testIsSameTree() {
        TreeNode root1  = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        assertEquals(1, isSameTree(root1, root2));

        // lets add new node to second tree
        root2.left.left = new TreeNode(4);
        assertEquals(0, isSameTree(root1, root2));
    }

    // do dfs of both tree at the same time
    // and if anyone of node are not even, return false
    public int isSameTreeRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return 1;

        if ((root1 != null && root2 == null) || (root1 == null && root2 != null)) return 0;

        if (root1.val != root2.val) return 0;

        return isSameTreeRecursive(root1.left, root2.left) == 1 && isSameTreeRecursive(root1.right, root2.right) == 1 ? 1: 0;
    }

    @Test
    public void testIsSameTreeRecursive() {
        TreeNode root1  = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        assertEquals(1, isSameTreeRecursive(root1, root2));

        // lets add new node to second tree
        root2.left.left = new TreeNode(4);
        assertEquals(0, isSameTreeRecursive(root1, root2));
    }
}
