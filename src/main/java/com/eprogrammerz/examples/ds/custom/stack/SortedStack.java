package com.eprogrammerz.examples.ds.custom.stack;

import java.util.Stack;

public class SortedStack {

    private Stack<Integer> stack;
    private Stack<Integer> temp;

    public SortedStack() {
        this.stack = new Stack<>();
        this.temp = new Stack<>();
    }

    public void push(int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.peek();
        if (data > top) {
            // copy samller to temp
            while (!stack.isEmpty() && stack.peek() < data) {
                temp.push(stack.pop());
            }

            // push
            stack.push(data);

            // copy from temp to stack
            while (!temp.isEmpty() && temp.peek() != null) {
                stack.push(temp.pop());
            }
        } else {
            stack.push(data);
        }
    }

    public int pop() {
        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }
}
