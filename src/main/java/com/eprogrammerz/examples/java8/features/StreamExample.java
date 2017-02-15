package com.eprogrammerz.examples.java8.features;

import java.util.*;
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
        /*
        //This causes NullPointerException
        List<Object> nullList = null;
        nullList.stream().findFirst().get();
        */

        Optional<String> stringOptional = strings.stream().filter(s -> s.length() == 9).findFirst();
        System.out.println(stringOptional);

        Map<String, Object> sampleMap = new HashMap<>();
        String value = (String) sampleMap.get("name");
        System.out.println(value);

        List<String> stringList = new ArrayList<>();
        stringList.add("ogen");
        stringList.add(0, "Rai");
        System.out.println(stringList);
        String valueRemvoed = stringList.remove(0);
        System.out.println(valueRemvoed);
        stringList.add(0,"Yogen");
        System.out.println(stringList);
    }
}
