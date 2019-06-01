package com.eprogrammerz.examples.algorithm.trees;

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

    @Override
    public String toString() {
        return "(" + data + ")";
    }
}