package com.eprogrammerz.examples.ds.custom.set;

import java.util.NoSuchElementException;

/**
 * @author Yogen Rai
 *
 * In this simple implementation, we use an array of linked lists and a hash co.de function. To insert a key
 * (which might be a string or essentially any other data type) and value, we do the following:
 *
 * 1. First, compute the element's hash code, which will usually be an in t or long.
 * Note that two different objects could have the same hash code,
 * as there may be an infinite number of elements and a finite number of ints.
 *
 * 2. Then, map the hash code to an index in the array.
 * This could be done with something like hash (element) % array_length.
 * Two different hash codes could, of course, map to the same index.
 *
 * 3. At this index, there is a linked list of elements. Store the element in this index.
 * We must use a linked list because of collisions: you could have two different keys with the same hash code,
 * or two different hash codes that map to the same index.
 *
 * To retrieve the value pair by its value, you repeat this process.
 * Compute the hash code from the element, and then compute the index from the hash code.
 * Then, search through the linked list for the value with this value.
 * If the number of collisions is very high, the worst case runtime is O( N),
 * where N is the number of keys.
 * However, we generally assume a good implementation that keeps collisions to a minimum, in which case the lookup time is a(1).
 *
 */
public class MyHashSet<T> {

    private int capacity = 0;

    private Node<T>[] buckets;

    private int size;

    public MyHashSet(final int capacity) {
        this.buckets = new Node[capacity];
        this.size = 0;
    }

    public MyHashSet() {
        this(16);
    }

    public void add(T t) {
        if (size == 0.75 * capacity) {
            // rehash
            capacity *= 2;
            size = 0;

            for (Node<T> bucket: buckets) {
                while (bucket != null) {
                    add(bucket.data);
                    bucket = bucket.next;
                }
            }
        }
        int index = hashCode(t) % buckets.length;

        Node bucket = buckets[index];

        Node<T> newNode = new Node<>(t);

        if (bucket == null) {
            buckets[index] = newNode;
            size++;
            return;
        }

        while (bucket.next != null) {
            if (bucket.data.equals(t)) {
                return;
            }
            bucket = bucket.next;
        }

        // add only if last element doesn't have the value being added
        if (!bucket.data.equals(t)) {
            bucket.next = newNode;
            size++;
        }
    }

    public T remove(T t) {
        int index = hashCode(t) % buckets.length;

        Node bucket = buckets[index];

        if (bucket == null) {
            throw new NoSuchElementException("No Element Found");
        }

        if (bucket.data.equals(t)) {
            buckets[index] = bucket.next;
            size--;
            return t;
        }

        Node prev = bucket;

        while (bucket != null) {
            if (bucket.data.equals(t)) {
                prev.next = bucket.next;
                size--;
                return t;
            }
            prev = bucket;
            bucket = bucket.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");
        for (Node node: buckets) {
            while (node != null) {
                sb.append(node);
                node = node.next;
            }
        }
        sb.append("]");
        return sb.toString();
    }



    private int hashCode(T t) {
        return t == null ? 0 : t.hashCode();
    }

    private static class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "(" + this.data + ")";
        }
    }
}
