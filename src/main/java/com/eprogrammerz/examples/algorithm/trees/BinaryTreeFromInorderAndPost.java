package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 *  Note: You may assume that duplicates do not exist in the tree.
 *
 *  Input :
 *         Inorder : [2, 1, 3]
 *         Postorder : [2, 3, 1]
 *
 * Return :
 *             1
 *            / \
 *           2   3
 */
public class BinaryTreeFromInorderAndPost {
    /**
     * The idea is that the last element in post order traversal will be the root!
     * So, find index in inorder traversal, which left is left of root
     * and right is right of the root
     *
     * @param inOrder
     * @param post
     * @return
     */
    public TreeNode buildTree(List<Integer> inOrder, List<Integer> post) {
        if (inOrder == null || post == null || inOrder.size() != post.size() || inOrder.isEmpty()) return null;

        int rootVal = post.get(post.size() - 1);
        TreeNode root = new TreeNode(rootVal);

        int idx = getRootIdx(inOrder,rootVal);

        root.left = buildTree(inOrder.subList(0, idx), post.subList(0, idx));
        root.right = buildTree(inOrder.subList(idx + 1, inOrder.size()), post.subList(idx, post.size() - 1));

        return root;
    }

    private int getRootIdx(List<Integer> inOrder, int rootVal) {
        return inOrder.indexOf(rootVal);
    }

    @Test
    public void testBuildTree() {
        List<Integer> inOrder = Arrays.asList(2,1,3,4,5);
        List<Integer> post = Arrays.asList(2,3,1,5,4);

        TreeNode tree = buildTree(inOrder, post);
        assertEquals(4, tree.val);
        assertEquals(1, tree.left.val);
        assertEquals(2, tree.left.left.val);
        assertEquals(3, tree.left.right.val);
        assertEquals(5, tree.right.val);
    }
}
