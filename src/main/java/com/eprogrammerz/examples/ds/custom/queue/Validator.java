package com.eprogrammerz.examples.ds.custom.queue;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class Validator {
    @Test
    public void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(4);
        queue.add(9);
        queue.add(13);
        queue.add(18);

        assertFalse(queue.isEmpty());

        // peek
        assertEquals(Integer.valueOf(4), queue.peek());
        assertEquals(Integer.valueOf(4), queue.peek());

        // remove
        assertEquals(Integer.valueOf(4), queue.remove());
        assertEquals(Integer.valueOf(9), queue.peek());
        assertFalse(queue.isEmpty());
    }
}
