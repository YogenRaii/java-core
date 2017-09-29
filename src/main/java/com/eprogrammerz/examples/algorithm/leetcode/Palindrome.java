package com.eprogrammerz.examples.algorithm.leetcode;

/**
 * Created by Yogen on 9/28/2017.
 */
public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
    public static boolean isPalindrome(int x) {
        int originalVal = x;
        int reversedX = 0;
        while(x != 0) {
            reversedX = reversedX * 10 + x % 10;
            x /= 10;
        }
        return originalVal == reversedX;
    }
}
