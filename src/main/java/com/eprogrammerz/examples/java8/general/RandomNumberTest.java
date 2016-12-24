package com.eprogrammerz.examples.java8.general;

/**
 * Created by 542596 on 11/17/2016.
 */
public class RandomNumberTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++){
            System.out.println((int)(Math.random()*7 + 1)+2000);
        }
    }
}
