package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return a 2-D array with vertical order traversal of it.
 * Go through the example and image for more details.
 *
 * Example :
 * Given binary tree:
 *
 *       6
 *     /   \
 *    3     7
 *   / \     \
 *  2   5     9
 */
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        // find left extreme and right extreme in horizontal distances
        MinMax minMax = new MinMax();

        findMinMax(root, minMax, 0);

        List<List<Integer>> traversal = new ArrayList<>();

        for (int vLine = minMax.min; vLine <= minMax.max; vLine++) {

            // vertical nodes
            List<Integer> vNodes = new ArrayList<>();
            verticalOrderTraversal(root, vLine, 0, vNodes);

            traversal.add(vNodes);
        }

        return traversal;
    }

    private void verticalOrderTraversal(TreeNode root, int vLine, int hd, List<Integer> nodes) {
        if (root == null) return;

        if (vLine == hd) {
            nodes.add(root.val);
        }

        verticalOrderTraversal(root.left, vLine, hd - 1, nodes);
        verticalOrderTraversal(root.right, vLine, hd + 1, nodes);
    }

    private void findMinMax(TreeNode root, MinMax minMax, int hd) {
        if (root == null) return;

        if (hd < minMax.min) {
            minMax.min = hd;
        }

        if (hd > minMax.max) {
            minMax.max = hd;
        }

        findMinMax(root.left, minMax, hd - 1);
        findMinMax(root.right, minMax, hd + 1);
    }

    @Test
    public void testVerticalOrderTraversal() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.right.right = new TreeNode(9);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);

        List<List<Integer>> traversal = verticalOrderTraversal(root);
        System.out.println(traversal);
    }
}

class MinMax {
    int min, max;
}