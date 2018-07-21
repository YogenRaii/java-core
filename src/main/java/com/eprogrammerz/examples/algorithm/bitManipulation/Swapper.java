package com.eprogrammerz.examples.algorithm.bitManipulation;

/**
 * @author Yogen Rai
 */
public class Swapper {
    public static void swap(int n, int m) {
        System.out.println(n + " " + m);
        n ^= m;
        m ^= n;
        n ^= m;
        System.out.println(n + " " + m);

        /**
         * swap with sum:
         * n = 23 + 32
         * m = n - m
         * n = n - m
         */
        n = n + m;
        m = n - m;
        n = n - m;
        System.out.println(n + " " + m);
    }

    public static void main(String[] args) {
        swap(23, 32);
    }
}
