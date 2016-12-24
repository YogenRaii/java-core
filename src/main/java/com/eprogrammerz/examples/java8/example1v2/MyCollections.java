package com.eprogrammerz.examples.java8.example1v2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 542596 on 11/11/2016.
 */
public class MyCollections {
    public static <T> List<T> filterApples(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (p.test(item)){
                result.add(item);
            }
        }
        return result;
    }
}
