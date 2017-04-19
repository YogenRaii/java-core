package com.eprogrammerz.examples.general.regexexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
        System.out.println(splitted[0]);

        String newAwesomeString = "a, b,c, d";
        List<String> splittedString = Arrays.asList(newAwesomeString.split(","));
        System.out.println(splittedString);
        List<String> trimmed = splittedString.stream().map(s -> s.trim()).collect(Collectors.toList());
        System.out.println(trimmed);
        
        System.out.println("1234".matches("[1-9]\\d{4}"));
        System.out.println("12354".matches("[1-9]\\d{4}"));
        System.out.println("01234".matches("[1-9]\\d{4}"));
    }
}
