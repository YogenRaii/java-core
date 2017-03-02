package com.eprogrammerz.examples.algorithm.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by 542596 on 3/1/2017.
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        BinaryTree binaryTree = new BinaryTree(root);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        List<Node> levelOrderTraversal = binaryTree.getLevelOrderTraversal();
        System.out.println(levelOrderTraversal);
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