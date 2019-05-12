package com.eprogrammerz.examples.certification.stream;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    private static void magic(Stream<Integer> s) {
        Optional o = s.filter(x -> x < 5).limit(3).max((x,y) -> y - x);
        System.out.println(o.get());
    }

    public static void main(String[] args) {
//        magic(Stream.empty()); // throws an java.util.NoSuchElementException
//        magic(Stream.iterate(1, x -> x++)); // prints 1
        magic(Stream.of(5,10));
    }
}
