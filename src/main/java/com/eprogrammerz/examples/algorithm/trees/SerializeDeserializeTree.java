package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * serialize given tree to string (bits representation so that it can be written in some form of memory or transmitted over the network
 *
 * and deserialize the string to the tree
 */
public class SerializeDeserializeTree {
    // Encodes a tree to a single string.
    // Time - O(n)
    // Space - O(n)
    public String serialize(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return "" + root.val;

        if (root.right == null) return root.val + "(" + serialize(root.left) + ")";

        return root.val + "(" + serialize(root.left) + ")(" + serialize(root.right) + ")";
    }

    // Decodes your encoded data to tree.
    // Time - O(n)
    // Space - O(n)
    public TreeNode deserialize(String data) {
        if ("".equals(data) || "()".equals(data)) return null;
        int idx = data.indexOf("(");

        if (idx < 0) {
            return new TreeNode(Integer.valueOf(data));
        } else {
            String num = data.substring(0, idx);
            if ("".equals(num)) return null;
            TreeNode node = new TreeNode(Integer.valueOf(num));
            String remaining = data.substring(idx);
            int close = closeIdx(remaining);
            node.left = deserialize(remaining.substring(1, close));
            if (close + 2 < remaining.length())
                node.right = deserialize(remaining.substring(close + 2, remaining.length() - 1));
            else
                node.right = null;
            return node;
        }
    }

    private int closeIdx(String str) {
        int open = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                open++;
            } else if (str.charAt(i) == ')') {
                open--;
                if (open == 0) return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        /**
         *           2
         *          / \
         *         1   3
         *        /     \
         *       4       5
         */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialize = serialize(root);
        assertEquals("2(1(4))(3()(5))", serialize);

        TreeNode deserialize = deserialize(serialize);
        assertTrue(sameTree(root, deserialize));
    }

    private boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || (t1.val != t2.val)) return false;

        return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }
}
