package com.eprogrammerz.examples.ds.custom.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class FreqStack {
    private Map<Integer, Integer> map;
    private Map<Integer, Stack<Integer>> timestamp;
    private PriorityQueue<Integer> pq;
    private int count;

    public FreqStack() {
        this.map = new HashMap<>();
        this.timestamp = new HashMap<>();
        this.pq = new PriorityQueue<>((e1, e2) -> map.get(e1).equals(map.get(e2)) ?
                timestamp.get(e2).peek() - timestamp.get(e1).peek() :
                map.get(e2) - map.get(e1));
    }

    public void push(int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
        timestamp.computeIfAbsent(x, s -> new Stack<>()).push(count++);

        if (map.get(x) == 1) {
            pq.offer(x);
        } else {
            PriorityQueue<Integer> temp = new PriorityQueue<>();
            while (!pq.isEmpty()) temp.add(pq.poll());

            pq.addAll(temp);
        }
    }

    public int pop() {
        int curr = pq.poll();

        int count = map.get(curr) - 1;

        if (count == 0) {
            map.remove(curr);
            timestamp.remove(curr);
        } else {
            map.put(curr, count);
            timestamp.get(curr).pop();
            pq.offer(curr);
        }
        return curr;
    }
    /*
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

     */
}
