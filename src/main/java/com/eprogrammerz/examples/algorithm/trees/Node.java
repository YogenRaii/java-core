package com.eprogrammerz.examples.algorithm.trees;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    /**
     * Insert data to BST
     * @param data
     */
    public void insert(int data) {
        if (this.data > data && this.left != null) {
            this.left.insert(data);
        } else if (this.data > data) {
            this.left = new Node(data);
        } else if (this.right != null) {
            this.right.insert(data);
        } else {
            this.right = new Node(data);
        }
    }

    /**
     * Check if given data contains in tree
     * @param data
     * @return true if contains, else false
     */
    public boolean contains(int data) {
        if (this.data == data) {
            return true;
        } else if (this.data > data && this.left != null) {
            return this.left.contains(data);
        } else if (this.right != null) {
            return this.right.contains(data);
        }

        return false;
    }

    /**
     * Validate if given binary tree is BST
     * @return
     */
    public boolean validate() {
        if (this.left != null) {
            if (this.left.data > this.data) return false;
            this.left.validate();
        }

        if (this.right != null) {
            if (this.right.data < this.data) return false;
            this.right.validate();
        }
        return true;
    }

    /**
     * Checks if tree is subtree of current tree
     *
     * @return true if tree is subtree, else false
     */
    public boolean isSubtree(Node that) {
        // do bfs on this
        // if node found same as of that.root
        // then traverse tree and see if left and right on both trees match

        if (that == null) return true;

        Queue<Node> thisQueue = new LinkedList<>();
        thisQueue.add(this);

        while (!thisQueue.isEmpty()) {
            Node thisNode = thisQueue.poll();

            if (thisNode.data == that.data) {
                return isSubtree(thisNode, that);
            }

            if (thisNode.left != null) {
                thisQueue.add(thisNode.left);
            }

            if (thisNode.right != null) {
                thisQueue.add(thisNode.right);
            }
        }

        return false;
    }

    private boolean isSubtree(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;

        if (t1 == null || t2 == null || t1.data != t2.data) return false;

        return isSubtree(t1.left, t2.left) && isSubtree(t1.right, t2.right);
    }

    @Override
    public String toString() {
        return "(" + data + ")";
    }
}