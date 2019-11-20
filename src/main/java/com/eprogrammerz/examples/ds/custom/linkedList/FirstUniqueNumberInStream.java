package com.eprogrammerz.examples.ds.custom.linkedList;

import lombok.val;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Design a data structure that support the following methods:
 *
 * public class Stream {
 *
 *     public Stream() {
 *         // do intialization if necessary
 *     }
 *
 *
 * 	// Adds integer num to a stream of integers.
 *
 *     public void add(int num) {
 *         // write your code here
 *     }
 *
 * 	*  Returns the first unique integer in the stream if found else return null.
 *
 public Integer getFirstUnique() {
 // write your code here
 }

head  tail
 |    |
 v    V
 3 -> 4
        * Exaple:
 Stream s = new Stream();
 s.add(2);
 s.getFirstUnique(); // 2
 s.add(2);
 s.getFirstUnique(); // null
 s.add(3);
 s.getFirstUnique(); // 3
 s.add(4);
 s.getFirstUnique(); // 3
 s.add(3);
 s.getFirstUnique(); // 4
 */
public class FirstUniqueNumberInStream {
    @Test
    public void test1() {
        Stream s = new Stream();
        s.add(2);
        assertThat(s.getFirstUnique(), equalTo(2)); // 2
        s.add(2);
        assertNull(s.getFirstUnique()); // null
        s.add(3);
        assertThat(s.getFirstUnique(), equalTo(3)); // 3
        s.add(4);
        assertThat(s.getFirstUnique(), equalTo(3)); // 3
        s.add(3);
        assertThat(s.getFirstUnique(), equalTo(4)); // 4
    }
}

class Stream {
    private Map<Integer, Node> map;
    private Node uniqueHead;
    private Node uniqueTail;

    public Stream() {
        // do intialization if necessary
        this.map = new HashMap<>();
        this.uniqueHead = null;
    }

    /**
     * Adds integer num to a stream of integers.
     */
    public void add(int num) {
        Node existing = this.map.get(num);

        // there has not been added any entry with num
        if (existing == null) {
            Node node = new Node(num);
            if (uniqueHead == null) {
                this.uniqueHead = node;
                this.uniqueTail = node;
            } else {
                node.prev = uniqueTail;
                this.uniqueTail.next = node;
                this.uniqueTail = node;
            }
            map.put(num, node);
        } else if (existing.unique) {
            //remove from list
            if (uniqueHead == existing) {
                if (uniqueHead == uniqueTail) {
                    uniqueHead = null;
                    uniqueTail = null;
                } else {
                    Node nextHead = uniqueHead.next;
                    uniqueHead.next = null;
                    uniqueHead = nextHead;
                    uniqueHead.prev = null;
                }
            } else if (uniqueTail == existing) {
                Node nextTail = uniqueTail.prev;
                uniqueTail.prev = null;
                uniqueTail = nextTail;
                uniqueTail.next = null;
            } else {
                existing.prev.next = existing.next;
                existing.next.prev = existing.prev;
                existing.prev = null;
                existing.next = null;
            }
            // update on map
            existing.unique = false;
        } else {
            // do nothing as entry will be there in map, but not in list
        }

    }

    /**
     *  Returns the first unique integer in the stream if found else return null.
     */
    public Integer getFirstUnique() {
        if (this.uniqueHead == null) return null;
        return uniqueHead.val;
    }

    class Node {
        int val;
        Node next;
        Node prev;
        boolean unique;

        Node(int val) {
            this.val = val;
            this.unique = true;
        }
    }
}
