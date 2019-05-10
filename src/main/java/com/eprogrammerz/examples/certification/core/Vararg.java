package com.eprogrammerz.examples.certification.core;

public class Vararg {
    public static void main(String[] args) {
        int x = 0;
        if (args.length > 0) {
            x = 10;
        }
        System.out.println(x); // if x is not initialized, then there would be compilation error
    }
}
