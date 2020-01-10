package com.eprogrammerz.examples.algorithm.trees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 */
public class ConstructBinaryTreeFromString {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;

        int i = 0;
        int val = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') break;
            val = val * 10 + (s.charAt(i) - '0');
            i++;
        }

        TreeNode root = new TreeNode(val);

        if (i == s.length()) return root;

        int open = 1;

        int start = ++i;

        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') open++;
            else if (ch == ')') {
                open--;
                if (open == 0) {
                    break;
                }
            }
            i++;
        }

        root.left = str2tree(s.substring(start, i));
        if (i + 1 < s.length()) {
            root.right = str2tree(s.substring(i + 2, s.length() - 1));
        }

        return root;
    }

    @Test
    public void test() {
        TreeNode root = str2tree("4(2(3)(1))(6(5))");
        assertEquals(4, root.val);
        assertEquals(2, root.left.val);
        assertEquals(6, root.right.val);
    }
}
