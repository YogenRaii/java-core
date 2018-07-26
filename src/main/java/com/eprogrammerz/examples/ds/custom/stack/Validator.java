package com.eprogrammerz.examples.ds.custom.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class Validator {
    @Test
    public void testMyStack() {
        MyStack<Integer> myStack = new MyStack();
        myStack.push(5);
        myStack.push(7);
        myStack.push(1);

        assertEquals(3, myStack.size());

        // peek test
        assertEquals(Integer.valueOf(1), myStack.peek());

        // pop test
        assertEquals(Integer.valueOf(1), myStack.pop());
        assertEquals(2, myStack.size());

        // push test
        myStack.push(100);
        assertEquals(3, myStack.size());
        assertEquals(Integer.valueOf(100), myStack.peek());
    }
}
