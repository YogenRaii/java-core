package com.eprogrammerz.examples.algorithm.codility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 542596 on 2/21/2017.
 */
public class EquilibriumArray {
    public static int solution(int[] A) {
        long sum = 0;

        for(int i = 0; i <A.length; i++) {
            sum += A[i];
        }

        List<Integer> results = new ArrayList<>();
        long left = 0;
        long right = sum;
        for(int i = 0; i< A.length; i++) {
            left = left + ((i == 0)? 0 : A[i-1]);
            right = right -  A[i];
            if(left == right) results.add(i);
        }
        System.out.println(results);
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {-1, 3, -4, 5,1,-6,2,1,2147483647,2147483647};
        System.out.println(solution(A));

        String s = "12:32:34";
        String newS = s.replace(":","");
        System.out.println(newS);
    }
}
