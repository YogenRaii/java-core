package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DaysOfWeek {
    private List<String> daysInWeek = Arrays.asList("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
    public String findNextDay(String day, int k) {
        if (day == null) return null;

        int idx = daysInWeek.indexOf(day);

        return daysInWeek.get((idx + k) % 7);
    }

    @Test
    public void test() {
        assertEquals("Fri", findNextDay("Wed", 2));
        assertEquals("Sat", findNextDay("Wed", 3));
        assertEquals("Sun", findNextDay("Wed", 4));
        assertEquals("Mon", findNextDay("Wed", 5));
    }
}
