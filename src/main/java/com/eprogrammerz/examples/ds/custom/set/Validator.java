package com.eprogrammerz.examples.ds.custom.set;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Yogen Rai
 */
public class Validator {
    @Test
    public void testMyHashSet() {
        MyHashSet<String> set = new MyHashSet<>(3);

        set.add("USA");
        set.add("Nepal");
        set.add("England");
        set.add("Netherland");
        set.add("Canada");
        set.add("Bhutan");

        assertEquals(6, set.size());

        // test removal of element
        assertEquals("Bhutan", set.remove("Bhutan"));
        assertEquals(5, set.size());
    }
}
