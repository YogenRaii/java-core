package com.eprogrammerz.examples.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 542596 on 11/9/2016.
 *
 * Method reference helps to point methods by their names.
 */
public class MethodReferenceExample {
    public static void main(String[] args) {
//        String[] names = new String[]{"Yogen","Tim","Delta"};
//        List<String> peoples = new ArrayList<>(Arrays.asList(names));
        List<String> peoples = new ArrayList<>(Arrays.asList("Yogen","Tim","delta"));

        peoples.forEach(System.out::println);
//        peoples.forEach(name -> System.out.println(name));
    }
}
