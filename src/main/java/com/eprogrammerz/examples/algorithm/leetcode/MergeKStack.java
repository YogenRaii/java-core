package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Merge three stacks into one.
 *
 * s1 = -5,1,2,3,5
 * s2 = -3,4,6,7
 * s3 = 1,5
 *
 * output (return one stack)
 * -5,-3,1,1,2,3,4,5,5,6,7
 */
public class MergeKStack {
    // n = number of elements in stacks
    // Time O(n*logk)
    // Space O(n)
    public Stack<Integer> mergeKStack(Stack<Integer>[] stacks) {
        int n = stacks.length;

        Stack<Integer>[] reversed = new Stack[n];

        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = reverse(stacks[i]);
        }

        Stack<Integer> merged = new Stack<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> reversed[i].peek())); // min heap; return index of stack with min val

        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }

        while (!pq.isEmpty()) {

            int curr = pq.poll();
            merged.push(reversed[curr].pop());

            if (!reversed[curr].isEmpty()) pq.add(curr);

        }
        return merged;
    }

    private Stack<Integer> reverse(Stack<Integer> stack) {
        Stack<Integer> reversed = new Stack<>();
        while (!stack.isEmpty()) {
            reversed.push(stack.pop());
        }
        return reversed;
    }

    @Test
    public void test() {
        Stack<Integer> s1 = new Stack<>();
        s1.push(-5);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(5);

        Stack<Integer> s2 = new Stack<>();
        s2.push(-3);
        s2.push(4);
        s2.push(6);
        s2.push(7);

        Stack<Integer> s3 = new Stack<>();
        s3.push(1);
        s3.push(5);

        Stack<Integer>[] stacks = new Stack[]{s1, s2, s3};

        Stack<Integer> actual = mergeKStack(stacks);

        Stack<Integer> expected = new Stack<>();
        expected.push(-5);
        expected.push(-3);
        expected.push(1);
        expected.push(1);
        expected.push(2);
        expected.push(3);
        expected.push(4);
        expected.push(5);
        expected.push(5);
        expected.push(6);
        expected.push(7);

        assertThat(actual, is(expected));
    }
}
