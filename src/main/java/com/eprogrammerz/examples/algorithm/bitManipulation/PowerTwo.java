package com.eprogrammerz.examples.algorithm.bitManipulation;

/**
 * @author Yogen Rai
 *
 * How to know if a number is a power of 2?
 *
 */
public class PowerTwo {
    static boolean isPowerOfTwo(int n) {
        /**
         * Power to two has only one 1's
         * ANDing this with (n-1) will give 0
         * For example:
         *
         * 8 & 7 = 0
         */
        return n != 0 && ((n & (n-1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(7));
        System.out.println(isPowerOfTwo(24));
        System.out.println(isPowerOfTwo(64));
    }
}
