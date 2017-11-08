package com.eprogrammerz.examples.algorithm.general;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringSorter {
    public static void main(String[] args) {
        //numbers in string form sorting won't work as expected
        System.out.println("Working with String numbers: ");
        List<String> strNums = Arrays.asList("1969948", "2435212", "25582376", "27829693", "33159479", "3472231", "3472260", "38328893");

        System.out.println("Before sorting: " + strNums);

        Collections.sort(strNums);

        System.out.println("After sorting: " + strNums);

        System.out.println("Working with numbers: ");
        List<Integer> nums = Arrays.asList(1969948, 2435212, 25582376, 27829693, 33159479, 3472231, 3472260, 38328893);

        System.out.println("Before sorting: " + nums);

        Collections.sort(nums);

        System.out.println("After sorting: " + nums);
    }
}
