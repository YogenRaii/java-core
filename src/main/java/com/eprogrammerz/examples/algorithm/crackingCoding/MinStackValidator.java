package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 *
 * Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 * which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
class MinStack<T extends Comparable> extends Stack<T> {
    // stack to hold the min values for pushed values
    private Stack<T> minStack = new Stack<>();

    @Override
    public T push(T val) {
        if (minStack.isEmpty() || val.compareTo(minStack.peek()) < 0) {
            minStack.push(val);
        }
        return super.push(val);
    }


    @Override
    public T pop() {
        if (super.isEmpty()) throw new EmptyStackException();

        T val = super.pop();
        if (val.equals(minStack.peek())) {
            minStack.pop();
        }
        return val;
    }

    public T min() {
        if (minStack.isEmpty()) throw new EmptyStackException();

        return minStack.peek();
    }
}

public class MinStackValidator {
    @Test
    public void testMinStack() {
        MinStack<Integer> minStack = new MinStack<>();

        minStack.push(3);
        minStack.push(5);
        minStack.push(9);
        minStack.push(2);

        assertEquals(Integer.valueOf(2), minStack.min());
        assertEquals(Integer.valueOf(2), minStack.pop());
        assertEquals(Integer.valueOf(3), minStack.min());

        minStack.push(10);
        assertEquals(Integer.valueOf(3), minStack.min());

        minStack.push(1);
        assertEquals(Integer.valueOf(1), minStack.min());

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        assertEquals(Integer.valueOf(3), minStack.min());
    }
}
