package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class FlattenBinaryTree {
    /**
     * Do dfs
     * once updated stack with child nodes, update traverse node with current node as right node
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node != root) {
                root.right = node;
                root.left = null;
                root = root.right;
            }
        }
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
    public void testPathSum() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(1);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.right.right = new TreeNode(10);

        flatten(root);

        assertEquals(6, root.val);

        assertNull(root.left);
        assertEquals(3, root.right.val);


        assertNull(root.right.left);
        assertEquals(2, root.right.right.val);

        assertNull(root.right.right.left);
        assertEquals(5, root.right.right.right.val);

        assertNull(root.right.right.right.right.left);
        assertEquals(7, root.right.right.right.right.val);
    }
}
