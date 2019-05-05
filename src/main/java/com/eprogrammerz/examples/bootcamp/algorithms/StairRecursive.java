package com.eprogrammerz.examples.bootcamp.algorithms;

/**
 * for n = 3
 * #
 * ##
 * ###
 */
public class StairRecursive {
    public static void printStairs(int steps) {
        printStairs(steps, 1, "#");
    }

    private static void printStairs(int steps, int row, String stair) {

        if (stair.length() == row) {
            System.out.println(stair);
        }
        if (steps == row) return;

        printStairs(steps, row + 1, stair + "#");
    }

    public static void main(String[] args) {
        printStairs(3);
    }
}
