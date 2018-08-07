package com.eprogrammerz.examples.ds.custom.set;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @author Yogen Rai
 */
public class Validator {
    @Test
    public void testMyHashSet() {
        MyHashSet<Integer> set = new MyHashSet<>();

        set.add(3);
        set.add(4);
        set.add(8);
        set.add(4);
        set.add(8);
        set.add(1000);

        assertEquals(4, set.size());

        assertEquals(Integer.valueOf(8), set.remove(8));
        assertEquals(3, set.size());
    }
}
