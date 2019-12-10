package com.eprogrammerz.examples.ds.custom.stack;

import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.PriorityQueue;

public class StackWHeap {
    private PriorityQueue<int[]> pq;
    public StackWHeap() {
        this.pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
    }

    public void push(int n) {
        // update all entry in pq with their count
        PriorityQueue<int[]> temp = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            e[1]++;
            temp.add(e);
        }
        pq.addAll(temp);
        pq.add(new int[] {n, 1});
    }

    public int pop() {
        if (pq.isEmpty()) {
            throw new EmptyStackException();
        }
        int[] e = pq.poll();
        return e[0];
    }
}
