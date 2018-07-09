package com.eprogrammerz.examples.general.inheritance.drawbacks;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class InheritanceRipple {

    @Test
    public void testMyHashSet() {
        MyHashSet<String> mhs = new MyHashSet<>();
        mhs.add("A");
        mhs.add("B");
        mhs.add("C");

        assertEquals("Number of attempted adds so far", 3, mhs.getAddCount());

        mhs.remove("B");

        assertEquals("Number of attempted adds so far even after removal", 3, mhs.getAddCount());

        mhs.addAll(Arrays.asList("D", "E", "F"));

        assertEquals("Size of Elements in current set", 5, mhs.size());
//        assertEquals("New number of attempted adds so far", 6,  mhs.getAddCount()); // fails
    }
}

class MyHashSet<T> extends HashSet<T> {
    //The number of attempted element insertions since its creation --
    //this value will not be modified when elements are removed
    private int addCount = 0;

    public MyHashSet() {}

    @Override
    public boolean add(T a) {
        addCount++;
        return super.add(a);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
