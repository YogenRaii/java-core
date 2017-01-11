package com.eprogrammerz.examples.java8.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by 542596 on 12/8/2016.
 */
public class RegexExample {
    public static void main(String[] args) {
        Optional<List<String>> listOptional = Optional.ofNullable(new ArrayList<>());

        listOptional.ifPresent(System.out::print);

        List<String> stringList = Arrays.asList("Yogne","Rai");
        //stringList.add("delta"); //this line causes error with 'java.lang.UnsupportedOperationException'

        String str = "C:/Yogen/api/content-api/content-delivery/src/main/resources/data-v1.json";
        String[] dirs = str.split("/");
        String fileName = dirs[dirs.length - 1];
        System.out.println(fileName);

        String[] typeSubtypeId = "amenity.wifi.wifi".split("\\.");

        System.out.println(typeSubtypeId[0] + typeSubtypeId[1]);

        String[] splitted = "all-meal".split("\\.");
        System.out.println(splitted[1]);
    }
}
