package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartesianTree {
    private class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }

    Node buildTree(List<Integer> traversal) {
        int rootIdx = findRootIdx(traversal);
        if (rootIdx < 0 || rootIdx >= traversal.size()) {
            return null;
        }

        Node root = new Node(traversal.get(rootIdx));
        root.left = buildTree(traversal.subList(0, rootIdx));
        root.right = buildTree(traversal.subList(rootIdx + 1, traversal.size()));
        return root;
    }

    private int findRootIdx(List<Integer> traversal) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 0; i < traversal.size(); i++) {
            if (traversal.get(i) > max) {
                max = traversal.get(i);
                idx = i;
            }
        }
        return idx;
    }

    @Test
    public void testBuildTree() {
        List<Integer> traversal = new ArrayList<>();
        traversal.add(1);
        traversal.add(3);
        traversal.add(7);
        traversal.add(5);
        Node root = buildTree(traversal);
        System.out.println(root);
    }
}
