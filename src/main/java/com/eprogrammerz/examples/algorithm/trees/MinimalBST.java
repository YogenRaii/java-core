package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MinimalBST {
    public Node constructMinBST(List<Integer> vals) {
        if (vals == null || vals.isEmpty()) return null;

        return constructMinBST(vals, 0, vals.size() - 1);
    }

    public Node constructMinBST(List<Integer> vals, int start, int end) {
        if (start > end) return null;

        int mid = (end - start) / 2 + start;

        Node node = new Node(vals.get(mid));

        node.left = constructMinBST(vals, start, mid - 1);
        node.right = constructMinBST(vals, mid + 1, end);

        return node;
    }

    @Test
    public void testConstructMinimalTree() {
        List<Integer> vals = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        /**
         *              4
         *             /  \
         *           2      6
         *         /   \   /  \
         *        1    3   5   7
         */
        Node tree = constructMinBST(vals);
        assertEquals(3, maxDepth(tree));
    }

    public int maxDepth(Node tree) {
        if (tree == null) return 0;
        return Math.max(maxDepth(tree.left), maxDepth(tree.right)) + 1;
    }
}
