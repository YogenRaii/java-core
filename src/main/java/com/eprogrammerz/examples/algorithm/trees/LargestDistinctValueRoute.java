package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Given a Binary Tree, find count of distinct nodes in a root to leaf path with maximum distinct nodes.
 * Examples:
 *
 * Input :   1
 *         /    \
 *        2      3
 *       / \    / \
 *      4   5  6   3
 *              \   \
 *               8   9
 * Output : 4
 * The root to leaf path with maximum distinct
 * nodes is 1-3-6-8.
 */

public class LargestDistinctValueRoute {
    public int findMaxDistinctNode(Tree tree) {
        if (tree == null) return 0;

        Map<Integer, Integer> xCount = new HashMap<>();
        return findMaxDistinctNode(tree, xCount);
    }

    private int findMaxDistinctNode(Tree tree, Map<Integer, Integer> xCount) {
        if (tree == null) return xCount.size();

        if (xCount.containsKey(tree.x)) {
            xCount.put(tree.x, xCount.get(tree.x) + 1);
        } else {
            xCount.put(tree.x, 1);
        }

        int max = Math.max(findMaxDistinctNode(tree.l, xCount), findMaxDistinctNode(tree.r, xCount));

        xCount.put(tree.x, xCount.get(tree.x) - 1);

        if (xCount.get(tree.x) == 0) xCount.remove(tree.x);
        return max;
    }

    @Test
    public void testFindMaxDistinctNode() {
        Tree root = new Tree(1);
        root.l = new Tree(2);
        root.r = new Tree(3);

        root.l.l = new Tree(4);
        root.l.r = new Tree(5);

        root.r.l = new Tree(6);
        root.r.r = new Tree(3);

        root.r.l.r = new Tree(8);
        root.r.r.r = new Tree(9);

        assertEquals(4, findMaxDistinctNode(root));
    }
}

class Tree {
    int x;
    Tree l;
    Tree r;

    Tree(int x) {
        this.x = x;
    }
}