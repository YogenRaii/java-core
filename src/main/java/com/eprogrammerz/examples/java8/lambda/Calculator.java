package com.eprogrammerz.examples.java8.lambda;

/**
 * @author Yogen Rai
 */

@FunctionalInterface
interface Calculator<T, R> {
    R calculate(T a, T b);
}