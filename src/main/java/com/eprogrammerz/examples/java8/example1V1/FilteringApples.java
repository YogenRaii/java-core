package com.eprogrammerz.examples.java8.example1V1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 542596 on 11/10/2016.
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green",86),
                                                new Apple("red",80),
                                                new Apple("orange",61),
                                                new Apple("purple",60),
                                                new Apple("red",70));
        List<Apple> heavyApples = filterApples(inventory,(Apple a)-> a.getWeight() > 75);
        System.out.println(heavyApples);

        List<Apple> redApples = filterApples(inventory,(Apple a) -> a.getColor().equals("red"));
        System.out.println(redApples);
    }

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
