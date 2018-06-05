package com.eprogrammerz.examples.java8.optional;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class OptionalOf {

    public Integer sumOldWay(Integer num1, Integer num2) {
        //Optional.ofNullable - allows null to be a parameter
        Integer val1 = num1 != null ? num1 : 0;
        Integer val2 = num2 != null ? num2 : 0;
        return val1 + val2;
    }

    public Integer sumNewWay(Integer num1, Integer num2) {
        //Optional.ofNullable - allows null to be a parameter
        Integer val1 = Optional.ofNullable(num1).orElse(0);
        Integer val2 = Optional.ofNullable(num2).orElse(0);
        return val1 + val2;
    }

    @Test
    public void testSumWithOptionals() {
        assertEquals(new Integer(20), sumNewWay(10, 10));
        assertEquals(new Integer(10), sumNewWay(null, 10));
    }

    @Test
    public void testSumOldWay() {
        assertEquals(new Integer(20), sumOldWay(10, 10));
        assertEquals(new Integer(10), sumOldWay(null, 10));
    }
}
