package com.eprogrammerz.examples.certification.collections;

import java.util.HashMap;
import java.util.Map;

/**
 * merge(key, newValue, mapper)
 *
 * if value is null, it replaces that with newValue
 */
public class MergeExample {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 10);
        map.put(2, 20);
        map.put(3, null);
        System.out.println(map); // {1=10, 2=20, 3=null}

        map.merge(1, 3, (x,y) -> x + y);
        map.merge(3, 3, (x,y) -> x + y);

        System.out.println(map); // {1=13, 2=20, 3=3}
    }
}
