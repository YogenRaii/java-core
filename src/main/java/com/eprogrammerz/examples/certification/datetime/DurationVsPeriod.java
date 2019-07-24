package com.eprogrammerz.examples.certification.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DurationVsPeriod {
    public static void main(String[] args) {
        String duration = Duration.ofDays(1).toString(); // PT24H
        String period = Period.ofDays(1).toString(); // P1D

        boolean dp1 = duration == period; // false
        boolean dp2 = duration.equals(period); // false

        System.out.println(dp1);
        System.out.println(dp2);

        System.out.println(ZonedDateTime.now());
        System.out.println(ZonedDateTime.now(ZoneId.of("Australia/Sydney")));

        System.out.println(Period.of(1,2,3)); // P1Y2M3D
        System.out.println(Period.ofWeeks(3)); // P21D
        System.out.println(Period.ofMonths(13)); // P13M

        Duration d = Duration.of(20, ChronoUnit.MINUTES);
        System.out.println(d); // PT20M

        LocalDate now = LocalDate.now();
//        System.out.println(now.plus(d)); // Unsupported unit: Seconds
    }
}
