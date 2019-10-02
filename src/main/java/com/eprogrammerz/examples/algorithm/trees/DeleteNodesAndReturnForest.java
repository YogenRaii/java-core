package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> l = new ArrayList<>();
        if (root == null) return l;
        delNodes(root, to_delete, l);
        return l;
    }

    private void delNodes(TreeNode root, int[] toDelete, List<TreeNode> l) {
        if (root == null) return;
        if (!isToDelete(toDelete, root.val)) {
            l.add(root);
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (isToDelete(toDelete, root.val)) {
                delNodes(node.left, toDelete, l);
                delNodes(node.right, toDelete, l);
            }
            else {
                if (node.left != null) {
                    if (isToDelete(toDelete, node.left.val)) {
                        TreeNode temp = node.left;
                        node.left = null;
                        delNodes(temp.left, toDelete, l);
                        delNodes(temp.right, toDelete, l);
                    } else {
                        q.add(node.left);
                    }

                }

                if (node.right != null) {
                    if (isToDelete(toDelete, node.right.val)) {
                        TreeNode temp = node.right;
                        node.right = null;
                        delNodes(temp.left, toDelete, l);
                        delNodes(temp.right, toDelete, l);
                    } else {
                        q.add(node.right);
                    }

                }
            }

        }
    }

    private boolean isToDelete(int[] toDelete, int val) {
        for (int n : toDelete) {
            if (n == val) return true;
        }
        return false;
    }

    @Test
    public void test1() {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(3);
        n1.right.right = new TreeNode(4);

        List<TreeNode> forest = delNodes(n1, new int[] {2,1});
        System.out.println(forest);
    }
}
