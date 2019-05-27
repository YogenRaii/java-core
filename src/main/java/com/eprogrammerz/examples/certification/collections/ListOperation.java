package com.eprogrammerz.examples.certification.collections;

import java.util.Arrays;
import java.util.List;

public class ListOperation {
    public static void main(String[] args) {
        String[] names = {"yogen", "pratima"};
        List<String> list = Arrays.asList(names);
        // size can't be changed of the list created with Arrays as it is backed with original array size
//        list.add("yogesh"); // java.lang.UnsupportedOperationException
//        list.remove(1); // java.lang.UnsupportedOperationException

        System.out.println(list); // [yogen, pratima]

        list.set(1, "yogesh");
        System.out.println(list); // [yogen, yogesh]
    }
}
