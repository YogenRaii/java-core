package com.eprogrammerz.examples.certification.stream;

import java.util.stream.IntStream;

public class StreamReduce {
    public static void main(String[] args) {
        int res = 1;
        IntStream stream = IntStream.rangeClosed(1,5);
//        System.out.println(stream.reduce(1, (m, i) -> m * i));
        System.out.println(stream.reduce(res, (m, i) -> m * i)); // this produces same result as of line above 120
//        System.out.println(stream.reduce(res, Integer::multiply); // it cases compilation error
    }
}
