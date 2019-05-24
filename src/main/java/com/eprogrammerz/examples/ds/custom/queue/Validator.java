package com.eprogrammerz.examples.ds.custom.queue;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Yogen Rai
 */
public class Validator {
    @Test
    public void testMyQueue() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(4);
        queue.enqueue(9);
        queue.enqueue(13);
        queue.enqueue(18);

        assertFalse(queue.isEmpty());

        // peek
        assertEquals(Integer.valueOf(4), queue.peek());
        assertEquals(Integer.valueOf(4), queue.peek());

        // remove
        assertEquals(Integer.valueOf(4), queue.dequeue());
        assertEquals(Integer.valueOf(9), queue.peek());
        assertFalse(queue.isEmpty());

        // more
        assertEquals(Integer.valueOf(9), queue.dequeue());
        assertEquals(Integer.valueOf(13), queue.dequeue());
        assertEquals(Integer.valueOf(18), queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}
