package com.eprogrammerz.examples.algorithm.memoization;

import java.util.Arrays;

/**
 * @author Yogen Rai
 * <p>
 * 0 1 1 2 3 5 8 13 21 34 55 89 144 233
 * <p>
 * Return element in nth index
 */
public class FibonacciNumber {
    // without memoization
    static int fib(int n) {
        if (n == 0 || n == 1) return n;

        return fib(n - 1) + fib(n - 2);
    }

    // memoized version
    static int fibonacciMemo(int n) {
        // entry table to cache the computed values
        int[] fibs = new int[n + 1];
        // initialize entry table with -1 to say value has to calculated
        Arrays.fill(fibs, -1);

        return fib(n, fibs);
    }

    static int fib(int n, int[] fibs) {
        if (n == 0 || n == 1) return n;

        if (fibs[n] == -1) {
            fibs[n] = fib(n - 1, fibs) + fib(n - 2, fibs);
        }

        return fibs[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(13));
        System.out.println(fib(20));

        long startTime = System.currentTimeMillis();
        System.out.println(fib(45));
        System.out.println("Time taken (w/o memo): " + (System.currentTimeMillis() - startTime) + " ms");

        // memoization
        System.out.println(fibonacciMemo(5));
        System.out.println(fibonacciMemo(13));
        System.out.println(fibonacciMemo(20));

        startTime = System.currentTimeMillis();
        System.out.println(fibonacciMemo(45));
        System.out.println("Time taken (w memo): " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
