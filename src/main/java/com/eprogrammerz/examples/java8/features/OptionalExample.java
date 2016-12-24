package com.eprogrammerz.examples.java8.features;

import java.util.Optional;

/**
 * Created by 542596 on 11/10/2016.
 *
 * Optional is a container object which is used to contain not-null objects.
 *
 * Optional object is used to represent null with absent value.
 *
 * Has various utility to handle values as 'available' or 'not available' instead checking null values.
 */
public class OptionalExample {
    public static void main(String[] args) {
        //Optional.ofNullable - allows null to be a parameter
        Optional<Integer> num1 = Optional.ofNullable(null);

        Optional<Integer> num2 = Optional.of(new Integer(10));

        System.out.println(OptionalExample.sum(num1,num2));
    }

    public static Integer sum(Optional<Integer> num1,Optional<Integer> num2){
        //check if numbers have value or not
        System.out.println("num1: "+num1.isPresent());
        System.out.println("num2: "+num2.isPresent());

        Integer val1 = num1.orElse(new Integer(0));
        Integer val2 = num2.orElse(new Integer(0)); // num2.get();
        return val1 + val2;
    }
}
