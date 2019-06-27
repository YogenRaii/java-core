package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * Find if tree is symmetric
 */
public class SymmetricBinaryTree {
    /**
     * This is naive solution using level order traversal
     *
     * if no node is present, add new node with Integer.MAX_VALUE and see if that particular level is symmetric
     *
     * @param A
     * @return
     */
    public int isSymmetric(TreeNode A) {
        if (A == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.val != Integer.MAX_VALUE) {
                    if (node.left != null) {
                        queue.add(node.left);
                    } else {
                        queue.add(new TreeNode(Integer.MAX_VALUE));
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    } else {
                        queue.add(new TreeNode(Integer.MAX_VALUE));
                    }
                }
            }

            if (!isBalanced(level)) {
                return 0;
            }

        }
        return 1;
    }

    private boolean isBalanced(List<Integer> list) {
        if (list.size() == 1) return true;

        if (list.size() % 2 != 0) return false;

        for (int s = 0, e = list.size() - 1; s < e; s++, e--) {
            if (!list.get(s).equals(list.get(e))) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testSymmetricTree() {
        /**
         *                  1
         *                /   \
         *               2     2
         *              /     /
         *             3     3
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        assertEquals(0, isSymmetric(root));

        /**
         *                              9
         *                             /   \
         *                           10     10
         *                          /  \   /  \
         *                         7    5 5   7
         *                             / \    \
         *                            8   1    6
         *                                     /
         *                                    2
         *
         *                        Min Depth = 3
         */
        TreeNode root1 = new TreeNode(9);
        root1.right = new TreeNode(10);
        root1.left = new TreeNode(10);

        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);

        assertEquals(1, isSymmetric(root1));
        root1.left.right.right = new TreeNode(1);

        root1.right.right.right = new TreeNode(6);
        root1.right.right.right.left = new TreeNode(2);

        assertEquals(0, isSymmetric(root1));
    }

    /**
     * Better solution with recursion
     *
     * @param root
     * @return
     */
    int isSymmetricBetter(TreeNode root) {
        return isSymmetric(root, root) ? 1 : 0;
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return true;

        if ((node1 == null) || (node2 == null) || node1.val != node2.val) return false;

        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }


    @Test
    public void testSymmetricBetterTree() {
        /**
         *                  1
         *                /   \
         *               2     2
         *              /     /
         *             3     3
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        assertEquals(0, isSymmetricBetter(root));

        /**
         *                              9
         *                             /   \
         *                           10     10
         *                          /  \   /  \
         *                         7    5 5   7
         *                             / \    \
         *                            8   1    6
         *                                     /
         *                                    2
         *
         *                        Min Depth = 3
         */
        TreeNode root1 = new TreeNode(9);
        root1.right = new TreeNode(10);
        root1.left = new TreeNode(10);

        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);

        assertEquals(1, isSymmetricBetter(root1));
        root1.left.right.right = new TreeNode(1);

        root1.right.right.right = new TreeNode(6);
        root1.right.right.right.left = new TreeNode(2);

        assertEquals(0, isSymmetricBetter(root1));
    }
}
