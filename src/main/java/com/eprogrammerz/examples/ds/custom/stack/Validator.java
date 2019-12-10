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

    @Test
    public void testMinStack() {
        MinStack minStack = new MinStack();
        minStack.push(2); // [2]
        minStack.push(4); // [4,2]
        minStack.push(1); // [1,4,2]
        minStack.push(5); // [5,1,4,2]
        minStack.push(0); // [0,5,1,4,2]

        assertEquals(0, minStack.min());
        assertEquals(0, minStack.pop());
        assertEquals(1, minStack.min());
        assertEquals(5, minStack.pop());
        assertEquals(1, minStack.min());
        assertEquals(1, minStack.pop());
        assertEquals(2, minStack.min());
    }

    @Test
    public void testSortedStack() {
        SortedStack sortedStack = new SortedStack();
        sortedStack.push(2);
        sortedStack.push(4);
        sortedStack.push(1);
        sortedStack.push(5);
        sortedStack.push(0);

        assertEquals(0, sortedStack.pop());
        assertEquals(1, sortedStack.pop());
        assertEquals(2, sortedStack.pop());
        assertEquals(4, sortedStack.pop());
        assertEquals(5, sortedStack.pop());
    }

    @Test
    public void testStackWQueue() {
        StackWQueue stack = new StackWQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testFreqStack1() {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);
        assertEquals(5, stack.pop());
        assertEquals(7, stack.pop());
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
    }

    @Test
    public void testFreqStack2() {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(1);
        stack.push(6);
        stack.push(1);
        stack.push(5);
        assertEquals(5, stack.pop()); // 5 -> 5, 1 -> 3
        assertEquals(5, stack.pop()); // 5 -> 4, 1 -> 3
        assertEquals(1, stack.pop()); // 5 -> 3, 1 -> 3
        assertEquals(5, stack.pop()); // 5 -> 3, 1 -> 2
        assertEquals(1, stack.pop()); // 5 -> 2, 1 -> 2
        assertEquals(5, stack.pop()); // 5 -> 2, 1 -> 1
        assertEquals(6, stack.pop()); // 5 -> 1, 1 -> 1
        assertEquals(2, stack.pop()); // 5 -> 1, 1 -> 1
        assertEquals(1, stack.pop()); // 5 -> 1, 1 -> 1
        assertEquals(5, stack.pop()); // 5 -> 1, 1 -> 1
    }

    @Test
    public void testStackWHeap() {
        StackWHeap stack = new StackWHeap();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);

        assertEquals(1, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }
}
