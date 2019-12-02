package com.eprogrammerz.examples.ds.custom.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while (head != null) {
            l.add(head.val);
            head = head.next;
        }

        int[] res = new int[l.size()];

        // to track monotone integer val of nodes
        Stack<Integer> stack = new Stack<>();

        for (int i = l.size() - 1; i >= 0; i--) {
            int curr = l.get(i);

            while (!stack.isEmpty() && curr >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = stack.peek();
            }

            stack.push(curr);
        }

        return res;
    }
}
