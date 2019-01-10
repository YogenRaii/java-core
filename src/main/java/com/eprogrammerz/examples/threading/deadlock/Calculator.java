package com.eprogrammerz.examples.threading.deadlock;

/**
 * @author Yogen Rai
 *
 */
public class Calculator {
    public synchronized int add(int a, int b) {
        return a + b;
    }
}
