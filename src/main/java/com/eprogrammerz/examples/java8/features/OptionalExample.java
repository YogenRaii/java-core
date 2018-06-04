package com.eprogrammerz.examples.java8.features;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


/**
 * Created by Yogen on 11/10/2016.
 *
 * Optional is a container object which is used to contain not-null objects.
 *
 * Optional object is used to represent null with absent value.
 *
 * Has various utility to handle values as 'available' or 'not available' instead checking null values.
 */
public class OptionalExample {
    public Integer sum(Optional<Integer> num1,Optional<Integer> num2){
        Integer val1 = num1.orElse(new Integer(0));
        Integer val2 = num2.orElse(new Integer(0)); // num2.get();
        return val1 + val2;
    }

    @Test
    public void testSumWithOptionals() {
        //Optional.ofNullable - allows null to be a parameter
        Optional<Integer> num1 = Optional.ofNullable(null);

        Optional<Integer> num2 = Optional.of(new Integer(10));

        assertEquals(new Integer(10), sum(num1, num2));
    }
}
