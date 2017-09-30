package com.eprogrammerz.examples.algorithm.leetcode;

/**
 * Created by Yogen on 9/29/2017.
 * <p>
 * "123" --> 123
 * <p>
 * "123" --> ["1", "2", "3"]
 * 1 * 100 + 2 * 10 + 3 * 1
 * 1 * 10^2 + 2 * 10^1 + 3 * 10^0
 */
public class AtoI {
    public static void main(String[] args) {
        System.out.println(atoi("123"));
        //["1","2","3"]
        //num = 0 + 1 * 10 ^ 2
        //num = 100 + 2 * 10^1

        System.out.println(itoa(123));
    }

    public static int atoi(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String can not be null or empty.");
        }
        int num = 0;
        char[] charEq = str.toCharArray();
        for (int i = 0; i < charEq.length; i++) {
            num += (charEq[i] - 48) * Math.pow(10, charEq.length - i - 1);
        }

        return num;
    }

    public static String itoa(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int digit = n % 10;
            sb.insert(0, digit);
//            sb.append(digit);
            n = n / 10;
        }
        return sb.toString();
//        return sb.reverse().toString();
    }
}
