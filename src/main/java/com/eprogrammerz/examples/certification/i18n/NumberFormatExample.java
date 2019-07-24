package com.eprogrammerz.examples.certification.i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatExample {
    public static void main(String[] args) throws ParseException {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        int price = 40;
        System.out.println(nf.format(price)); // $40.00

        nf = NumberFormat.getCurrencyInstance(new Locale("np"));
        System.out.println(nf.format(price)); // suppose to print in rupees

        String amt = "$92,807.99";
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        double value = (double) cf.parse(amt);
        System.out.println(value);
    }
}
