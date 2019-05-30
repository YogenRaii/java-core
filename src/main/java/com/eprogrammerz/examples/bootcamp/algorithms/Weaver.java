package com.eprogrammerz.examples.bootcamp.algorithms;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class Weaver {
    public Queue<Object> weave(Queue<String> q1, Queue<Integer> q2) {
        Queue<Object> result = new LinkedList<>();

        while (q1.peek() != null || q2.peek() != null) {
            if (q1.peek() != null) {
                result.add(q1.poll());
            }
            if (q2.peek() != null) {
                result.add(q2.poll());
            }
        }

        return result;
    }

    @Test
    public void testWeave() {
        Queue<String> q1 = new LinkedList<>();
        q1.add("You");
        q1.add("To");
        q1.add("Hi");

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(3);
        q2.add(2);
        q2.add(1);

        Queue<Object> res = weave(q1, q2);
        assertEquals("You", res.poll());
        assertEquals(3, res.poll());
        assertEquals("To", res.poll());
        assertEquals(2, res.poll());
        assertEquals("Hi", res.poll());
        assertEquals(1, res.poll());
    }
}
