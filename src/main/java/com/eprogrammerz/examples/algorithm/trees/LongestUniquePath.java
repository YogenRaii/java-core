package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Find longest path with unique node ids in given tree
 */
public class LongestUniquePath {
    /**
     *         6
     *       /   \
     *      3     7
     *     / \     \
     *    2   5     6
     *         \     \
     *          1     10
     *                 \
     *                  7
     *   Unique path: [6,3,5,1]
     */

    public int longestUniquePath(TreeNode root) {
        Set<Integer> path = new HashSet<>();
        traversal(root, path, new ArrayList<>());
        return path.size();
    }

    private void traversal(TreeNode node, Set<Integer> path, ArrayList<Integer> temp) {
        if (node == null) return;
        // visit
        temp.add(node.val);

        if (node.left == null && node.right == null) {
            Set<Integer> result = new HashSet<>(temp);
            if (result.size() > path.size()) {
                path.clear();
                path.addAll(result);
                temp.remove(temp.size() - 1);
            }
            return;
        }

        traversal(node.left, path, temp);
        traversal(node.right, path, temp);
        temp.remove(temp.size() - 1);
    }

    @Test
    public void testPathSum() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(1);

        assertEquals(4, longestUniquePath(root));

        // add right node to rightest node on last level
        root.right.right.right = new TreeNode(10);
        root.right.right.right.right = new TreeNode(7);

        assertEquals(4, longestUniquePath(root));

    }
}
