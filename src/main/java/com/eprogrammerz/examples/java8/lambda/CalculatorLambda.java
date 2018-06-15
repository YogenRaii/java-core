package com.eprogrammerz.examples.java8.lambda;

/**
 * Created by Yogen on 9/26/2017.
 */
public class CalculatorLambda {
    public static void main(String[] args) {
        Calculator<Integer, Integer> adder = (a,b) -> a + b;

        // lambda can be used to evaluate the expression
        Integer sum = adder.calculate(2,3);
        System.out.println(sum);

        //you can pass lambda expression as an argument
        printSum(adder);

        //you can return lambda expression as return
        Calculator<Integer, Integer> multiplier = getCalculatorFunc();
        System.out.println(multiplier.calculate(6,9));
    }

    static void printSum(Calculator cal) {
        System.out.println(cal.calculate(4,5));
    }

    static Calculator getCalculatorFunc() {
        Calculator<Integer, Integer> multiplier = (a, b) -> a * b;
        return multiplier;
    }
}
