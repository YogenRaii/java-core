package com.eprogrammerz.examples.ds.custom.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 *
 * MyStack stack = new MyStack();
 *
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 */
public class StackWQueue {
    private Queue<Integer> q1;
    /** Initialize your data structure here. */
    public StackWQueue() {
        this.q1 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    // O(1)
    public void push(int x) {
        this.q1.add(x);
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            q1.add(q1.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return this.q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return this.q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
