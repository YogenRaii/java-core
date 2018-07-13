package com.eprogrammerz.examples.algorithm.trees;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Yogen on 3/1/2017.
 */
public class LevelOrderTraversal {
    @Test
    public void testLevelOrderTraversal() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        BinaryTree binaryTree = new BinaryTree(root);
        List<Node> levelOrderTraversal = binaryTree.getLevelOrderTraversal();
        List<Node> expected = Arrays.asList(new Node(1),
                new Node(2),new Node(3),new Node(4),new Node(5), new Node(6));
        assertEquals(expected.toString(), levelOrderTraversal.toString());
    }
}

class BinaryTree {
    private Node root;
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
            if(tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if(tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        return traversal;
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
        return "("+data+")";
    }
}