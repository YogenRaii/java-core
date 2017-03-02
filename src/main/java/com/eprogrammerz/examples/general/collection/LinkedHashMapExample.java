package com.eprogrammerz.examples.general.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 542596 on 3/1/2017.
 */
public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, String> nameMap = new LinkedHashMap<>();
        nameMap.put("first", "yogen");
        nameMap.put("second", "rita");
        nameMap.put("third", "nita");
        nameMap.put("fourth", "gita");

        System.out.println(nameMap);

        nameMap = new HashMap<>();
        nameMap.put("first", "yogen");
        nameMap.put("second", "rita");
        nameMap.put("third", "nita");
        nameMap.put("fourth", "gita");
        System.out.println(nameMap);
    }
}
