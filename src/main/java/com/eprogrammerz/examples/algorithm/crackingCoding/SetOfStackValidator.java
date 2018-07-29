package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class SetOfStackValidator {
    @Test
    public void testSetOfStack() {
        SetOfStack<Integer> stack = new SetOfStack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(7);
        stack.push(5);
        stack.push(6);

        assertEquals(Integer.valueOf(6), stack.peek());
    }
}

class SetOfStack<T> {
    public static final Integer STACK_SIZE = 5;

    private List<Stack> stacks = new ArrayList<>();

    public SetOfStack() {
        stacks.add(new Stack());
    }

    public void push(T item) {
        Stack<T> currentStack = stacks.get(stacks.size() - 1);

        if (currentStack.size() == STACK_SIZE) {
            // add new stack
            Stack<T> newStack = new Stack();
            newStack.push(item);
            stacks.add(newStack);
        } else {
            // get last stack and add element on that
            currentStack.push(item);
        }
    }

    public T pop() {
        Stack<T> currentStack = stacks.get(stacks.size() - 1);

        T item = currentStack.pop();

        if (currentStack.isEmpty()) {
            stacks.remove(currentStack);
        }
        return item;
    }

    public T peek() {
        Stack<T> currentStack = stacks.get(stacks.size() - 1);

        return currentStack.pop();
    }

    public int size() {
        return stacks.size() * STACK_SIZE;
    }
}
