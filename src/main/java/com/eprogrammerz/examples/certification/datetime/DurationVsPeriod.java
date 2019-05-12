package com.eprogrammerz.examples.certification.datetime;

import java.time.Duration;
import java.time.Period;

public class DurationVsPeriod {
    public static void main(String[] args) {
        String duration = Duration.ofDays(1).toString(); // PT24H
        String period = Period.ofDays(1).toString(); // P1D

        boolean dp1 = duration == period; // false
        boolean dp2 = duration.equals(period); // false

        System.out.println(dp1);
        System.out.println(dp2);
    }
}
