package com.eprogrammerz.examples.ds.custom.linkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class MyLinkedListValidator {
    @Test
    public void testMyLinkedList() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        assertEquals(0, linkedList.size());

        linkedList.addFirst("first"); // ["first"]
        linkedList.addFirst("second"); // ["second", "first"]

        assertEquals(2, linkedList.size());
        assertEquals("second", linkedList.getFirst());
        assertEquals("first", linkedList.getLast());

        linkedList.addLast("last"); // ["second", "first", "last"]
        assertEquals(3, linkedList.size());
        assertEquals("last", linkedList.getLast());

        assertEquals("second", linkedList.getAt(0));
        assertEquals("first", linkedList.getAt(1));
        assertEquals("last", linkedList.getAt(2));
        assertNull(linkedList.getAt(3));

        linkedList.removeAt(1); // ["second", "last"]
        assertEquals(2, linkedList.size());
        assertEquals("last", linkedList.getAt(1));

        assertTrue(linkedList.insertAt(1, "new")); // ["second", "new", "last"]
        assertEquals(3, linkedList.size());
        assertEquals("new", linkedList.getAt(1));

        assertEquals("new", linkedList.midElement());

        linkedList.addLast("yogen");  // ["second", "first", "last", "yogen"]
        assertEquals(4, linkedList.size());
        assertEquals("new", linkedList.getAt(1));
        assertEquals("new", linkedList.midElement());

        linkedList.addLast("rai"); // ["second", "first", "last", "yogen", "rai"];
        assertEquals("last", linkedList.midElement());

        linkedList.addLast("ilam"); // ["second", "first", "last", "yogen", "rai", "ilam"]
        assertEquals("last", linkedList.midElement());
    }
}
