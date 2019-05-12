package com.eprogrammerz.examples.certification.stream;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class JustIntermediateOperations {
    public static void main(String[] args) {
        Stream<LocalDate> s = Stream.of(LocalDate.now());
        UnaryOperator<LocalDate> u = l -> l;
        s.filter(Objects::nonNull).map(u).peek(System.out::println); // since intermediate operations are lazily evaluated, it doesn't print anything!
    }
}
