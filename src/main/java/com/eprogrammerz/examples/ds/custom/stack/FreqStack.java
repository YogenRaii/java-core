package com.eprogrammerz.examples.ds.custom.stack;

import java.util.HashMap;
import java.util.Map;

public class FreqStack {
    private Node head;
    private Map<Integer, Integer> map;

    public FreqStack() {
        this.map = new HashMap<>();
    }

    public void push(int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }

        map.put(x, map.getOrDefault(x, 0) + 1);

    }

    public int pop() {
        int freq = findFreq();
        if (map.get(head.val) == freq) {
            int x = head.val;
            head = head.next;
            map.put(x, freq - 1);
            return x;
        } else {
            Node prev = head;
            Node node = head.next;
            // search for requent element and update
            while (node != null) {
                if (map.get(node.val) == freq) {
                    prev.next = node.next;
                    map.put(node.val, freq - 1);
                    return node.val;
                }
                prev = node;
                node = node.next;
            }
        }
        return Integer.MIN_VALUE;
    }

    private int findFreq() {
        int top = Integer.MIN_VALUE;
        for (int k: map.keySet()) {
            int v = map.get(k);
            if (v > top) {
                top = v;
            }
        }
        return top;
    }

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
