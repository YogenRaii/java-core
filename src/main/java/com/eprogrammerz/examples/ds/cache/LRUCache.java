package com.eprogrammerz.examples.ds.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Design LRU cache with fix size i.e. if cache reaches max size, then least recently has to be removed!
 *
 * 2 -> (2,yogen,next,prev)
 * 3 -> (3,rai,next,prev)
 * 4 -> (4,nepal,next,prev)
 * 1 -> (1,intro)
 *
 *
 * head will track to MRU and tail will track to LRU
 *
 * 2,yogen -> 3,rai -> 4,nepal
 * cache.get(3)
 * 3,rai -> 2,yogen -> 4,nepal
 * cache.put(1)
 * 1,intro -> 2,yogen -> 4,nepal
 *
 */
public class LRUCache<K, V> {


    private class Node<K, V> {
        K key;
        V value;

        Node<K, V> next;
        Node<K, V> prev;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    private Map<K, Node<K, V>> map;
    private DDList list;
    private int capacity;

    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DDList();
    }

    public V get(K key) {
        Node<K, V> node = map.get(key);

        if (node == null) return null;

        list.removeNode(node);
        list.addToHead(node);

        return node.value;
    }

    public void put(K key, V value) {
        Node<K, V> node = map.get(key);

        if (node != null) {
            node.value = value;

            list.removeNode(node);
            list.addToHead(node);

            return;
        }

        node = new Node<>(key, value);

        if (size == capacity) {
            Node last = list.removeTail();
            map.remove(last.key);

            size--;
        }

        list.addToHead(node);
        size++;
        map.put(key, node);
    }

    class DDList {
        Node<K, V> head;
        Node<K, V> tail;

        DDList() {
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            this.head.next = tail;
            this.tail.prev = head;
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;

        }

        public Node removeTail() {
            if (tail.prev == head) return null;
            Node node = tail.prev;
            removeNode(node);

            return node;
        }
    }
}

/*
    private int size;

    private Map<K,Node<K,V>> map;

    private Node<K, V> head;
    private Node<K, V> tail;

    public LRUCache(int initialCapacity) {
        this.size = initialCapacity;
        this.map = new HashMap<>(initialCapacity);
    }

    public void put(K key, V value) {
        Node<K,V> node = new Node<>(key, value);
        if (size == map.size()) {
            // remove tail
            map.remove(tail.key);
            removeNode(tail);

        }
        insertNodeAtFirst(node);

        map.put(key, node);
    }

    private void insertNodeAtFirst(Node<K, V> node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public V get(K key) {
        Node<K,V> node = map.get(key);

        if (node == null) return null;

        if (node != head) {
            // remove node from its current spot
            removeNode(node);

            // add to the from of the list
            insertNodeAtFirst(node);
        }

        return node.value;
    }

    private void removeNode(Node<K, V> node) {
        if (node == null) return;

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (tail == node) tail = node.prev;
        if (head == node) head = node.next;
    }
    }
*/

