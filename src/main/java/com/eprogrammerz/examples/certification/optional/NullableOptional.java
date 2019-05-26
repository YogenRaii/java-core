package com.eprogrammerz.examples.certification.optional;

import java.util.Optional;

public class NullableOptional {
    public static void main(String[] args) {
        Optional<Integer> optional = Optional.ofNullable(null);
        System.out.println(optional);
    }
}
