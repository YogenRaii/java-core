package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers % 1003.
 *
 * Example :
 *
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25
 *
 */
public class SumRoot2Leaf {
    public int sumNumbers(TreeNode root) {
        List<Integer> sumToLeafs = new ArrayList<>();
        findSumToLeaf(root, sumToLeafs, 0);
        return sumToLeafs.stream().mapToInt(i -> i).sum() % 1003;
    }

    private void findSumToLeaf(TreeNode node, List<Integer> sumToLeafs, int sum) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            sumToLeafs.add(sum * 10 + node.val);
            return;
        }
        findSumToLeaf(node.left, sumToLeafs, sum * 10 + node.val);
        findSumToLeaf(node.right, sumToLeafs, sum * 10 + node.val);
    }

    @Test
    public void testSumNumbers() {
        System.out.println(1938 % 1003);
        /**
         *         6
         *       /   \
         *      3     7
         *     / \     \
         *    2   5     1
         *               \
         *               1
         */
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(1);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        // ((632) + (635) + (671)) % 1003
        // 1938 % 1003
        // 935
        assertEquals(935, sumNumbers(root));

        // add right node to rightest node on last level
        root.right.right.right = new TreeNode(1);
        assertEquals(957, sumNumbers(root));

    }

    @Test
    public void testSumNumbers1() {
        System.out.println(512 % 1003);
        /**
         *         5
         *       /
         *      1
         *     /
         *    2
         *
         *
         */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);

        root.left.left = new TreeNode(2);
        // (512) % 1003
        // 512
        assertEquals(512, sumNumbers(root));
    }
}
