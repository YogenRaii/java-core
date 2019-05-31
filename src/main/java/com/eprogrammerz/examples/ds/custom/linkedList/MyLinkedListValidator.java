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

        linkedList.addFirst("first");
        linkedList.addFirst("second");

        assertEquals(2, linkedList.size());
        assertEquals("second", linkedList.getFirst());
        assertEquals("first", linkedList.getLast());

        linkedList.addLast("last");
        assertEquals(3, linkedList.size());
        assertEquals("last", linkedList.getLast());

        assertEquals("second", linkedList.getAt(0));
        assertEquals("first", linkedList.getAt(1));
        assertEquals("last", linkedList.getAt(2));
        assertNull(linkedList.getAt(3));

        linkedList.removeAt(1);
        assertEquals(2, linkedList.size());
        assertEquals("last", linkedList.getAt(1));

        assertTrue(linkedList.insertAt(1, "new"));
        assertEquals(3, linkedList.size());
        assertEquals("new", linkedList.getAt(1));

    }
}
