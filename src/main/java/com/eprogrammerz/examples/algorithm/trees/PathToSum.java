package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathToSum {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSum(root, target, paths, new ArrayList<>());
        return paths;
    }

    private void pathSum(TreeNode root, int target, List<List<Integer>> paths, List<Integer> path) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.val == target) {
                path.add(root.val);

                paths.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        path.add(root.val);

        pathSum(root.left, target - root.val, paths, path);
        pathSum(root.right, target - root.val, paths, path);
        path.remove(path.size() - 1);
    }

    /**
     *         6
     *       /   \
     *      3     7
     *     / \     \
     *    2   5     1
     *               \
     *               10
     */

    @Test
    public void testPathSum() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(1);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        List<List<Integer>> actual1 = pathSum(root, 14);

        List<List<Integer>> expected = Arrays.asList(Arrays.asList(6, 3, 5), Arrays.asList(6, 7, 1));
        assertEquals(expected, actual1);
        // add right node to rightest node on last level
        root.right.right.right = new TreeNode(10);
        List<List<Integer>> actual2 = pathSum(root, 24);
        assertThat(actual2, contains(Arrays.asList(6, 7, 1, 10)));

    }
}
