package com.eprogrammerz.examples.algorithm.trees;

import java.util.*;

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

    /**
     * Count path that sums to the target value
     *
     * @return
     */
    public int findPaths(int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(this);

        int count = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            count += findPaths(node, target, 0);

            if (node.left != null) queue.add(node.left);

            if (node.right != null) queue.add(node.right);
        }
        return count;
    }

    private int findPaths(Node node, int target, int sum) {
        if (node == null) return 0;
        sum += node.data;

        int totalPaths = 0;
        if (target == sum) {
            totalPaths++;
        }
        totalPaths += findPaths(node.left, target, sum);
        totalPaths += findPaths(node.right, target, sum);

        return totalPaths;
    }

    /**
     *          10
     *       /     \
     *     7         2
     *   /   \        \
     *  3     4        8
     *         \        \
     *          5        12
     *
     *  pathToTarget(12) = [10,2,8,12]
     *
     */
    public List<Integer> pathToTarget(int target) {
        List<Integer> path = new ArrayList<>();
        pathToTarget(this, target, path, new ArrayList<>());
        return path;
    }

    private void pathToTarget(Node node, int target, List<Integer> path, List<Integer> tempPath) {
        if (node == null) return;

        tempPath.add(node.data);
        if (node.data == target) {
            path.addAll(tempPath);
        }
        pathToTarget(node.left, target, path, tempPath);
        pathToTarget(node.right, target, path, tempPath);
        tempPath.remove(tempPath.size() - 1);
    }

    @Override
    public String toString() {
        return "(" + data + ")";
    }
}