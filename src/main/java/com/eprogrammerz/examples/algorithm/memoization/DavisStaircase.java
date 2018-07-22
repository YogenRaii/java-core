package com.eprogrammerz.examples.algorithm.memoization;

import java.util.Arrays;

/**
 * @author Yogen Rai
 *
 *
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
 *
 * Davis has a number of staircases in his house and he likes to climb each staircase , ,
 * or  steps at a time. Being a very precocious child, he wonders how many ways there are to
 * reach the top of the staircase.
 *
 * Given the respective heights for each of the  staircases in his house,
 * find and print the number of ways he can climb each staircase, module  on a new line.
 *
 */
public class DavisStaircase {
    static final long MOD = 10000000007L;

    // memoization
    static int[] steps = null;

    static int countSteps(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (steps[n] != -1) return steps[n];

        steps[n] = ((int)((countSteps(n - 1) + countSteps(n - 2) + countSteps(n - 3)) % MOD));
        return steps[n];
    }

    // Complete the stepPerms function below.
    static int stepPerms(int n) {
        steps = new int[n + 1];

        Arrays.fill(steps, -1);

        return countSteps(n);
    }

    public static void main(String[] args) {
        System.out.println(stepPerms(1));
        System.out.println(stepPerms(3));
        System.out.println(stepPerms(7));
    }
}
