package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given BST and k, 1 <= k <= total element in BST
 * Find kth smallest
 */
public class KthSmallestInBST {
    public int kthsmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, k, inorder);
        return inorder.get(inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode root, int k, List<Integer> inorder) {
        if (root == null) return;
        inorderTraversal(root.left, k, inorder);
        if (k == inorder.size()) return;
        inorder.add(root.val);
        inorderTraversal(root.right, k, inorder);
    }

    @Test
    public void testKthSmallest() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);

        root.right.right = new TreeNode(17);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(8);

        assertEquals(8, kthsmallest(root, 3));

        root.left.left.left = new TreeNode(3);

        assertEquals(7, kthsmallest(root,3));
    }
}
