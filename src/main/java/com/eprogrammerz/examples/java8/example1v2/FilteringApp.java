package com.eprogrammerz.examples.java8.example1v2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 542596 on 11/10/2016.
 */
public class FilteringApp {
    public static void main(String[] args) {
        List<com.eprogrammerz.examples.java8.example1V1.Apple> inventory = Arrays.asList(new com.eprogrammerz.examples.java8.example1V1.Apple("green",86),
                                                new com.eprogrammerz.examples.java8.example1V1.Apple("red",80),
                                                new com.eprogrammerz.examples.java8.example1V1.Apple("orange",61),
                                                new com.eprogrammerz.examples.java8.example1V1.Apple("purple",60),
                                                new com.eprogrammerz.examples.java8.example1V1.Apple("red",70));
        List<com.eprogrammerz.examples.java8.example1V1.Apple> heavyApples = MyCollections.filterApples(inventory,(com.eprogrammerz.examples.java8.example1V1.Apple a)-> a.getWeight() > 75);
        System.out.println(heavyApples);

        List<com.eprogrammerz.examples.java8.example1V1.Apple> redApples = MyCollections.filterApples(inventory,(com.eprogrammerz.examples.java8.example1V1.Apple a) -> a.getColor().equals("red"));
        System.out.println(redApples);

        List<String> names = Arrays.asList("Yogen","Tim","Sai","Vimalan");
        List<String> nameWith3Letters = MyCollections.filterApples(names,(String name) -> name.length() == 3 );
        System.out.println(nameWith3Letters);

        //working with predicate
        List<String> strings = Arrays.asList("abc"," ","bc","delta"," ","yogen");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.trim().isEmpty();
        //getting non-empty strings
        List<String> nonEmptyStrings = MyCollections.filterApples(strings,nonEmptyStringPredicate);
        System.out.println(nonEmptyStrings);
    }
}
