package com.eprogrammerz.examples.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by 542596 on 11/9/2016.
 */
public class FuncInterfaceEx {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 5, 6, 9, 3, 2, 10);

        System.out.println("Even Numbers: ");
        eval(integers, n -> n % 2 == 0);
    }

    private static void eval(List<Integer> integers, Predicate<Integer> predicate) {
//        integers.forEach(n -> n +=2);
        for (Integer n : integers) {
            if (predicate.test(n)) {
                System.out.print(n + " ");
            }
        }
    }

}
