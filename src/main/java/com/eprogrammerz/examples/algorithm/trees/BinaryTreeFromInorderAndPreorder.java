package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given inorder and preorder traversal of a tree, construct the binary tree.
 *
 *  Note: You may assume that duplicates do not exist in the tree.
 *
 *  Input :
 *         Inorder : [2, 1, 3]
 *         preorder : [1, 2, 3]
 *
 * Return :
 *             1
 *            / \
 *           2   3
 */
public class BinaryTreeFromInorderAndPreorder {
    public TreeNode buildTree(List<Integer> inOrder, List<Integer> pre) {
        if (inOrder == null || pre == null || inOrder.size() != pre.size() || inOrder.isEmpty()) return null;

        int rootVal = pre.get(0);
        TreeNode root = new TreeNode(rootVal);

        int idx = inOrder.indexOf(rootVal);
        root.left = buildTree(inOrder.subList(0, idx), pre.subList(1, idx + 1));
        root.right = buildTree(inOrder.subList(idx + 1, inOrder.size()), pre.subList(idx + 1, pre.size()));
        return root;
    }

    @Test
    public void testBuildTree() {
        List<Integer> inOrder = Arrays.asList(2,1,3,4,5);
        List<Integer> pre = Arrays.asList(4,1,2,3,5);

        TreeNode tree = buildTree(inOrder, pre);
        assertEquals(4, tree.val);
        assertEquals(1, tree.left.val);
        assertEquals(2, tree.left.left.val);
        assertEquals(3, tree.left.right.val);
        assertEquals(5, tree.right.val);
    }
}
