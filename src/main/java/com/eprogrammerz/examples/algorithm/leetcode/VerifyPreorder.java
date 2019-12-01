package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * with given pre-order traversal, verify if the tree is valid or not
 */
public class VerifyPreorder {
    public boolean isValidSerialization(String preorder) {
        // stack 9 2 3 1 4
        // replace node having two # with #
        Stack<String> stack = new Stack<>();
        String[] parts = preorder.split(",");
        for (int i = 0; i < parts.length; i++) {
            stack.push(parts[i]);
            if ("#".equals(stack.peek())) {
                int popCount = 0;
                while (stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) break;
                    popCount++;

                    if (popCount == 2) {
                        stack.pop(); // pop parent node
                        stack.push("#");
                        popCount = 0;
                    }


                }
                if (i < parts.length - 1 && stack.isEmpty()) return false;

                stack.push("#");
            }
        }

        return stack.size() == 1 && "#".equals(stack.peek());
    }

    @Test
    public void test() {
        assertTrue(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        assertFalse(isValidSerialization("1,#"));
        assertFalse(isValidSerialization("9,#,#,1"));
    }
}
