package com.eprogrammerz.examples.algorithm.crackingCoding;

import java.util.Stack;

/**
 * @author Yogen Rai
 */
public class TowerOfHanoi {
    public static void moveDisks(int disks, Stack<Integer> origin, Stack<Integer> target, Stack<Integer> buffer) {
        if (disks <= 0) return;

        // move n - 1 disk from origin to buffer
        moveDisks(disks - 1, origin, buffer, target);

        // move top to target
        moveTopDisk(origin, target);

        // move n - 1 disk from buffer to target
        moveDisks(disks - 1, buffer, target, origin);
    }

    private static void moveTopDisk(Stack<Integer> origin, Stack<Integer> target) {
        target.push(origin.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> origin = new Stack<>();
        Stack<Integer> target = new Stack<>();
        Stack<Integer> buffer = new Stack<>();

        origin.push(4);
        origin.push(3);
        origin.push(2);
        origin.push(1);

        System.out.println(origin);

        moveDisks(4, origin, target, buffer);

        System.out.println(target);
    }
}
