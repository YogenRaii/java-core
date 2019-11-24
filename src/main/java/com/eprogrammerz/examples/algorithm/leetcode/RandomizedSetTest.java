package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSetTest {
    @Test
    public void test1() {
        RandomizedSet set = new RandomizedSet();
        assertTrue(set.insert(0));
        assertTrue(set.insert(1));
        assertTrue(set.remove(0));
        assertTrue(set.insert(2));
        assertTrue(set.remove(1));
    }

    @Test
    public void test2() {
        RandomizedSet set = new RandomizedSet();
        assertTrue(set.insert(0));
        assertTrue(set.remove(0));
        assertTrue(set.insert(-1));
        assertFalse(set.remove(0));

        assertEquals(-1, set.getRandom());
    }

    @Test
    public void test3() {
        RandomizedSet set = new RandomizedSet();
        assertTrue(set.insert(3));
        assertFalse(set.insert(3));
        assertTrue(set.insert(1));
        assertTrue(set.remove(3));
        assertTrue(set.insert(0));
        assertTrue(set.remove(0));
    }
}

class RandomizedSet {

    private Map<Integer, Integer> map;
    private LinkedList<Integer> list;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.list = new LinkedList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        int size = list.size();
        map.put(val, size);
        list.addLast(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            int last = list.removeLast();
            if (last != val) {
                list.set(idx, last);
                map.put(last, idx);
            }
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx= rand.nextInt(list.size());
        return list.get(idx);
    }
}
