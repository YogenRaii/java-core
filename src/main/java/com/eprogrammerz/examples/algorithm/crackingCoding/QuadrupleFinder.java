package com.eprogrammerz.examples.algorithm.crackingCoding;

import java.util.*;

/**
 * @author Yogen Rai
 *
 *  Print all positive integer solutions to the equation a3 + b3 = c3 + d3 where a, b, c, and d are integers between 1 and 1000.
 */
public class QuadrupleFinder {
    public static List<List<Integer>> findQuadruples(int start, int end) {
        final List<List<Integer>> quadruples = new ArrayList<>();

        final Map<Integer, List<Integer>> numberPair = new HashMap<>();

        // loop over the range and find a3+b3 and store them in map
        for (int i = start; i < end; i++) {
            for (int j = i; j < end; j++) {
                int sum = (int)(Math.pow(i, 3) + Math.pow(j, 3));
                numberPair.put(sum, Arrays.asList(i, j));
            }
        }

        // now check if there is c and d such that c3+d3=a3+b3
        for(int i = start; i < end; i++) {
            for (int j = i; j < end; j++) {
                int sum = (int)(Math.pow(i, 3) + Math.pow(j, 3));
                if(numberPair.containsKey(sum)) {
                    List<Integer> firstPair = numberPair.get(sum);
                    if (i != firstPair.get(0) && j != firstPair.get(1)) {
                        List<Integer> numbers = Arrays.asList(firstPair.get(0), firstPair.get(1), i, j);
                        quadruples.add(numbers);
                    }
                }
            }
        }


        return quadruples;
    }

    public static void main(String[] args) {
        System.out.println(findQuadruples(1, 1000));
    }
}
