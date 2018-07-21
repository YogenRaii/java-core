package com.eprogrammerz.examples.algorithm.bitManipulation;

import java.util.Arrays;
import java.util.List;

/**
 * @author Yogen Rai
 *
 * Consider an array of integers where all but one of the integers occur in pairs.
 * In other words, every element occurs exactly twice except for one unique element. Find the unique element.
 * For example, given the array [1,1,2,3,2], you would return 3.
 */
public class LonelyInteger {
    static int findLonely(List<Integer> arr) {

        int num = 0;

        for (int n: arr) {
            num ^= n;  // 0 ^ 1 = 1
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(findLonely(Arrays.asList(1,1,2)));
        System.out.println(findLonely(Arrays.asList(1,1,2,3,2)));
    }
}
