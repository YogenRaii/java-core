package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).
 *
 * Example :
 * Given binary tree
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode tree) {
        List<List<Integer>> traversal = new ArrayList<>();

        if (tree == null) return traversal;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        traversal.add(Collections.singletonList(tree.val));

        List<Integer> currentLevel = new ArrayList<>();

        // for delimiter
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode elem = queue.poll();

            if (elem != null) {
                if (elem.left != null) {
                    queue.add(elem.left);
                    currentLevel.add(elem.left.val);
                }

                if (elem.right != null) {
                    queue.add(elem.right);
                    currentLevel.add(elem.right.val);
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    traversal.add(currentLevel);
                    currentLevel = new ArrayList<>();
                }
            }

        }

        return traversal;
    }

    @Test
    public void testLevelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> traversal = levelOrder(root);
        System.out.println(traversal); //[[3], [9, 20], [15, 7]]
    }

    /**
     *
     * Add nodes into queue and iterate upto the number of times equal to
     * size of the queue on each level
     *
     *
     * @param tree
     * @return
     */
    public List<List<Integer>> levelOrderBetter(TreeNode tree) {
        List<List<Integer>> traversals = new ArrayList<>();

        if (tree == null) return traversals;

        // track the nodes while traversing
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            traversals.add(currentLevel);
        }

        return traversals;
    }

    @Test
    public void testLevelOrderBetter() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> traversal = levelOrderBetter(root);
        System.out.println(traversal); //[[3], [9, 20], [15, 7]]
    }
}

