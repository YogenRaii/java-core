package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Yogen on 3/1/2017.
 */
public class TreeTraversal {
    private BinaryTree tree;

    /**
     *          1
     *       /     \
     *     2         3
     *   /   \        \
     *  4     5        6
     */

    @Before
    public void setup() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        this.tree = new BinaryTree(root);
    }

    @Test
    public void testLevelOrderTraversal() {
        List<Node> levelOrderTraversal = tree.getLevelOrderTraversal();
        List<Node> expected = Arrays.asList(new Node(1),
                new Node(2), new Node(3), new Node(4), new Node(5), new Node(6));
        assertEquals(expected.toString(), levelOrderTraversal.toString());
    }

    @Test
    public void testInOrderTraversal() {
        List<Node> traversal = new ArrayList<>();
        tree.inOrderTraversal(tree.root, traversal);

        List<Node> expected = Arrays.asList(
                new Node(4), new Node(2), new Node(5), new Node(1), new Node(3), new Node(6));

        assertEquals(expected.toString(), traversal.toString());
    }

    @Test
    public void testPreOrderTraversal() {
        List<Node> traversal = new ArrayList<>();
        tree.preOrderTraversal(tree.root, traversal);

        List<Node> expected = Arrays.asList(new Node(1),
                new Node(2), new Node(4),new Node(5),new Node(3),   new Node(6));

        assertEquals(expected.toString(), traversal.toString());
    }

    @Test
    public void testPostOrderTraversal() {
        List<Node> traversal = new ArrayList<>();
        tree.postOrderTraversal(tree.root, traversal);

        List<Node> expected = Arrays.asList(
                new Node(4),new Node(5),new Node(2), new Node(6), new Node(3), new Node(1)  );

        assertEquals(expected.toString(), traversal.toString());
    }
}

class BinaryTree {
    Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    List<Node> getLevelOrderTraversal() {
        List<Node> traversal = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {    //O(N)
            Node tempNode = queue.poll();
            traversal.add(tempNode);
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return traversal;
    }


    /**
     * 1. go to left
     * 2. visit node
     * 3. go to right
     *
     * @param node
     * @param traversal
     */
    void inOrderTraversal(Node node, List<Node> traversal) {
        if (node == null) return;

        if (node.left != null) inOrderTraversal(node.left, traversal);

        traversal.add(node);

        if (node.right != null) inOrderTraversal(node.right, traversal);
    }

    /**
     * 1. Visit node
     * 2. go to left
     * 3. go to right
     *
     * @param node
     * @param traversal
     */
    void preOrderTraversal(Node node, List<Node> traversal) {
        if (node == null) return;
        traversal.add(node);

        if (node.left != null) preOrderTraversal(node.left, traversal);
        if (node.right != null) preOrderTraversal(node.right, traversal);
    }

    /**
     * 1. go to left
     * 2. go to right
     * 3. visit node
     *
     * @param node
     * @param traversal
     */
    void postOrderTraversal(Node node, List<Node> traversal) {
        if (node == null) return;

        if (node.left != null) postOrderTraversal(node.left, traversal);
        if (node.right != null) postOrderTraversal(node.right, traversal);
        traversal.add(node);
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "(" + data + ")";
    }
}