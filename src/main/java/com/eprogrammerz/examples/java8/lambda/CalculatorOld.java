package com.eprogrammerz.examples.java8.lambda;

/**
 * @author Yogen Rai
 */
public class CalculatorOld {
    public static void main(String[] args) {
        Calculator<Integer, Integer> adder = new Calculator<Integer, Integer>() {
            @Override
            public Integer calculate(Integer a, Integer b) {
                return a + b;
            }
        };

        Integer sum = adder.calculate(4,3);

        System.out.println(sum);
    }
}

