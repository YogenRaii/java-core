package com.eprogrammerz.examples.general.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValueExample {
    public static Map<String, Integer> sortByValue(final Map<String, Integer> wordCounts) {

        return wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        final Map<String, Integer> wordCounts = new HashMap<>();
        wordCounts.put("USA", 100);
        wordCounts.put("jobs", 200);
        wordCounts.put("software", 50);
        wordCounts.put("technology", 70);
        wordCounts.put("opportunity", 200);

        final Map<String, Integer> sortedByCount = sortByValue(wordCounts);

        System.out.println(sortedByCount);
    }
}
