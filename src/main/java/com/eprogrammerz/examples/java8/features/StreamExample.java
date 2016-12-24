package com.eprogrammerz.examples.java8.features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 542596 on 11/9/2016.
 *
 * Stream lets developer to process data declaratively and leverage multicore architecture without the need to write
 * any specific code for it.
 */
public class StreamExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc"," ","bc","delta"," ","yogen");
        List<String> filtered = strings.stream().filter(string -> !string.trim().isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::println);

        int emptyStringCount = (int)strings.stream().filter(string -> string.trim().isEmpty()).count();
        System.out.println("Empty Strings: "+emptyStringCount);

    }
}
