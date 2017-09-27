package com.eprogrammerz.examples.cache.example.cloning;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by 542596 on 12/21/2016.
 */
public class HashMapClone {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        HashMap<String, Object> clonedMap = (HashMap<String, Object>) map.clone();

        System.out.println(map);
        System.out.println(clonedMap);

        System.out.println("Changing value...");
        map.remove("key1");

        //removing from map doesn't affect cloneMap
        System.out.println(map);
        System.out.println(clonedMap);

        Date date = new Date(1482421944086L);
        System.out.println(date);
    }
}
