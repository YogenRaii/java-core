package com.eprogrammerz.examples.java8.dateTime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by Yogen on 9/27/2017.
 */
public class DateTimeApiExample {
    public static void main(String[] args) {
        //Date and time instance in JDK 8 is immutable
        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println(currentTime);

        //currentTime remains same and changedTime will be pointing to new dateTime instance
        LocalDateTime changedTime = currentTime.minusSeconds(100000);

        System.out.println(currentTime);
        System.out.println(changedTime);

        // it is easy to do the manipulation on date
        System.out.println(currentTime.minusDays(3));

        Date threeDaysBack = Date.from(LocalDateTime.now().minusDays(3).atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(threeDaysBack);
    }
}
