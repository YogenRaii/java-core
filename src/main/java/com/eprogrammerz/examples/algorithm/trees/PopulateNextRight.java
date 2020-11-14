package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following definition:
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulateNextRight {
    public Node connect(Node root) {
        Node curr = root;

        while (curr != null && curr.left != null) {
            Node runner = curr.left;
            Node temp = runner;
            Node prev = null;

            while (curr != null) {
                runner = curr.left;
                if (prev != null) {
                    prev.next = runner;
                }

                runner.next = curr.right;
                runner = runner.next;
                prev = runner;
                curr = curr.next;
            }

            curr = temp;
        }

        return root;
    }

    @Test
    public void test() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node populated = connect(root);

        assertEquals(3, populated.left.next.val);
        assertEquals(6, populated.left.right.next.val);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
