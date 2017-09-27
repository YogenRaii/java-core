package com.eprogrammerz.examples.java8.features;

/**
 * Created by Yogen on 9/26/2017.
 */
public class LambdaExample2 {
    public static void main(String[] args) {
        Calculator adder = (a,b) -> a + b;
        System.out.println(adder.calculate(2,3));

        //you can pass lambda expression as an argument
        printSum(adder);

        //you can return lambda expression as return
        Calculator multiplier = getCalculatorFunc();
        System.out.println(multiplier.calculate(6,9));
    }

    static void printSum(Calculator cal) {
        System.out.println(cal.calculate(4,5));
    }

    static Calculator getCalculatorFunc() {
        return (a,b) -> a * b;
    }
}

@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}