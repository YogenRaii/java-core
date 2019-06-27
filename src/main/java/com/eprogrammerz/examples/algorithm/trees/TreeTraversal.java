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
     *         1
     *      /     \
     *    2         3
     *  /   \        \
     * 4     5        6
     *
     *
     * postorder: 1 2 4 5 3 6
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
    public void testInOrderTraversalRecursive() {
        List<Integer> expected = Arrays.asList(4, 2, 5, 1, 3, 6);
        List<Integer> actual = tree.inOrderTraversalRecursive(tree.root);

        assertEquals(expected, actual);
    }

    @Test
    public void testPreOrderTraversal() {
        List<Node> traversal = new ArrayList<>();
        tree.preOrderTraversal(tree.root, traversal);

        List<Node> expected = Arrays.asList(new Node(1),
                new Node(2), new Node(4), new Node(5), new Node(3), new Node(6));

        assertEquals(expected.toString(), traversal.toString());
    }

    @Test
    public void testPreOrderTraversalRecursive() {
        List<Integer> expected = Arrays.asList(1, 2, 4, 5, 3, 6);
        List<Integer> actual = tree.preOrderRecursive(tree.root);

        assertEquals(expected, actual);
    }

    @Test
    public void testPostOrderTraversal() {
        List<Node> traversal = new ArrayList<>();
        tree.postOrderTraversal(tree.root, traversal);

        List<Node> expected = Arrays.asList(
                new Node(4), new Node(5), new Node(2), new Node(6), new Node(3), new Node(1));

        assertEquals(expected.toString(), traversal.toString());
    }

    @Test
    public void testPostOrderRecursive() {
        List<Integer> traversal = tree.postOrderRecursive(tree.root);

        List<Integer> expected = Arrays.asList(4, 5, 2, 6, 3, 1);

        assertEquals(expected, traversal);
    }

    @Test
    public void testGetLevelWidths() {
        List<Integer> widths = Arrays.asList(1, 2, 3);
        assertEquals(widths, tree.getLevelWidth());
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
     * Recursive version of in order tree traversal
     *
     * @param root
     * @return
     */
    List<Integer> inOrderTraversalRecursive(Node root) {
        List<Integer> traversal = new ArrayList<>();

        Stack<Node> stack = new Stack<>();

        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            traversal.add(curr.data);
            curr = curr.right;
        }
        return traversal;
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

    List<Integer> preOrderRecursive(Node node) {
        List<Integer> traversal = new ArrayList<>();
        if (node == null) return traversal;

        Stack<Node> stack = new Stack<>();

        Node curr = node;

        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                traversal.add(curr.data);
                curr = curr.left;
            } else {
                curr = stack.pop().right;
            }
        }

        return traversal;
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

    List<Integer> postOrderRecursive(Node node) {
        List<Integer> traversal = new ArrayList<>();
        if (node == null) return traversal;

        Stack<Node> stack = new Stack<>();

        Node lastNode = node;

        while (node != null || !stack.isEmpty()) {

            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node peek = stack.peek();

                if (peek.right != null && lastNode != peek.right) {
                    node = peek.right;
                } else {
                    traversal.add(peek.data);
                    lastNode = stack.pop();
                }
            }
        }
        return traversal;
    }

    public List<Integer> getLevelWidth() {
        List<Integer> widths = new ArrayList<>();

        if (root == null) return widths;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int width = 0;
            while (size > 0) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                width++;
                size--;
            }
            widths.add(width);
        }

        return widths;
    }
}
