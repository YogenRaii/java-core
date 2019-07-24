package com.eprogrammerz.examples.certification.i18n;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class DataFormatExample {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2019, 7, 8);
        LocalTime time = LocalTime.of(14,59);
        LocalDateTime dateTime = LocalDateTime.of(date, time);

        DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(shortF.format(dateTime)); // 7/8/19 2:59 PM
        System.out.println(mediumF.format(dateTime)); // Jul 8, 2019 2:59:00 PM
    }
}
