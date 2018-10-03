package com.eprogrammerz.examples.ds.custom.stack;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yogen Rai
 */
public class Validator {
    @Test
    public void testMyStack() throws ExecutionException, InterruptedException {
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
