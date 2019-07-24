package com.eprogrammerz.examples.certification.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ZooOpen {
    public static void main(String[] args) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");

        printProps(us);

        System.out.println();

        printProps(france);
    }

    private static void printProps(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
//        System.out.println(rb.getString("default"));  // this fails since there java Zoo.java can't be loaded with zoo! it has to be package.ClassName
    }
}
