package com.eprogrammerz.examples.algorithm.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSorter {
    public static void main(String[] args) {
        List<String> numberStr = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            numberStr.add(String.valueOf(i));
        }

        // sort
        Collections.sort(numberStr);
        System.out.println(numberStr);

        System.out.println(limitDigits(123232)); //123
        System.out.println(limitDigits(12)); //012
    }

    public static String limitDigits(int n) {
        while (n > 1000) {
            n = n/ 10;
        }
        return String.format("%03d", n);
    }


}
