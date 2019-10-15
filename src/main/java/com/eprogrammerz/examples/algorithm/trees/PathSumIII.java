package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 *
 *
 *
 * https://leetcode.com/problems/path-sum-iii/
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        int count = 0;
        if (root == null) return count;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            List<List<Integer>> paths = new ArrayList<>();
            dfs(node, paths, new ArrayList<>(), sum);
            count += paths.size();

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return count;
    }

    private void dfs(TreeNode node, List<List<Integer>> paths, List<Integer> temp, int sum) {
        if (node == null) return;

        temp.add(node.val);
        if (sum - node.val == 0) {
            paths.add(new ArrayList<>(temp));
        }
        dfs(node.left, paths, temp, sum - node.val);
        dfs(node.right, paths, temp, sum - node.val);

        temp.remove(temp.size() - 1);
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

        assertEquals(2, pathSum(root, 11));
    }

    @Test
    public void test2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);

        root.left.left.left = new TreeNode(-1);

        assertEquals(4, pathSum(root, -1));
    }
}
