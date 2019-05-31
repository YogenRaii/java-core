package com.eprogrammerz.examples.ds.custom.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueWStackValidator {
    @Test
    public void testQueueWStack() {
        QueueWStack<String> queue = new QueueWStack<>();
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("9");
        queue.enqueue("5");

        assertEquals("2", queue.peek());
        assertEquals("2", queue.dequeue());
        assertEquals("3", queue.peek());
        assertEquals("3", queue.dequeue());

        queue.enqueue("4");
        assertEquals("9", queue.peek());
        assertEquals("9", queue.dequeue());

        assertEquals("5", queue.dequeue());
        assertEquals("4", queue.dequeue());
    }
}
