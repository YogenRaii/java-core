package com.eprogrammerz.examples.algorithm.bitManipulation;

/**
 * @author Yogen Rai
 * <p>
 * Given a positive integer n. The problem is to check whether this integer has an alternate pattern
 * in its binary representation or not. Here alternate pattern means that the set and unset bits
 * in n occur in alternate order. For example- 5 has an alternate pattern i.e. 101.
 * Print “Yes” if it has an alternate pattern otherwise “No”.
 */
public class AlternateBitPattern {
    public static boolean isAlternatePattern(int n) {
        int allSet = n ^ (n >> 1);
        return isAllBitSet(allSet);
    }

    /**
     *   1 1 1
     * 1 0 0 0
     *  -----
     * 1 0 0 0
     * @param n integer
     * @return true if all bits set else false
     */
    public static boolean isAllBitSet(int n) {
        return (n & (n + 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isAlternatePattern(5));
    }
}
