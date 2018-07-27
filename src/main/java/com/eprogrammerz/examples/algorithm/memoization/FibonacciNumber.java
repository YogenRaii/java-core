package com.eprogrammerz.examples.algorithm.memoization;

import java.util.Arrays;

/**
 * @author Yogen Rai
 *
 * 0 1 1 2 3 5 8 13 21 34 55 89 144 233
 *
 * Return element in nth index
 */
public class FibonacciNumber {
    // without memoization
    static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;

        return fibonacci(n - 1) + fibonacci( n - 2);
    }

    // memoized version
    static int[] fibs;

    static int fibonacciMemo(int n) {
        fibs = new int[n + 1];

        Arrays.fill(fibs, -1);

        return fib(n);
    }

    static int fib(int n) {
        if (n == 0 || n == 1) return n;

        if (fibs[n] == -1) {
            fibs[n] = fib(n - 1) + fib(n - 2);
        }

        return fibs[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacci(13));
        System.out.println(fibonacci(20));

        long startTime = System.currentTimeMillis();
        System.out.println(fibonacci(45));
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
