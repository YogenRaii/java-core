package com.eprogrammerz.examples.ds.custom.stack;

import java.util.*;

/**
 * https://leetcode.com/problems/dinner-plate-stacks/
 */
public class DinnerPlates {

    private List<Stack<Integer>> l;
    private PriorityQueue<Integer> pq;
    private int capacity;
    private Set<Integer> candidates;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.l = new ArrayList<>();
        this.l.add(new Stack<>()); // add stack at 0
        this.pq = new PriorityQueue<>();
        this.pq.offer(0); // let pq know that stack at 0 is candidate stack
        this.candidates = new HashSet<>();
        this.candidates.add(0);
    }

    public void push(int val) {
        int idx = pq.peek();
        Stack<Integer> stack = l.get(idx);
        stack.push(val);

        if (stack.size() == capacity) {
            candidates.remove(idx);
            pq.poll();

            if (l.size() == idx + 1) {
                l.add(new Stack<>());
                candidates.add(idx + 1);
                pq.offer(idx + 1);
            }

        }
    }

    public int pop() {
        int idx = l.size() - 1;
        Stack<Integer> stack = l.get(idx);
        if (stack == null) return -1;

        if (stack.isEmpty()) {
            if (idx == 0) return -1;

            l.remove(idx);
            return pop();
        }

        int val = stack.pop();

        if (candidates.add(idx)) {
            pq.offer(idx);
        }
        return val;
    }

    public int popAtStack(int index) {
        if (index >= l.size()) return -1; // no stack at this index
        Stack<Integer> stack = l.get(index);

        if (stack == null || stack.isEmpty()) return -1;

        int val = stack.pop();

        if (candidates.add(index)) {
            pq.add(index);
        }

        return val;
    }
}
