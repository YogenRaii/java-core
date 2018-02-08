package com.eprogrammerz.examples.algorithm.general;

public class NumberFinder {
    static String findNumbers(int digit, int start, int end) {
        if(start > end) {
            int temp = start;
            start = end;
            end = temp;
        }
        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = start; i <=  end; i++) {
            if (contains(i, digit)) {
                stringBuilder.append(i);
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }

    static boolean contains(int num, int digit) {
        while (num > 0) {
            int div = num % 10;
            if (digit == div) {
                return true;
            }
            num = num / 10;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(3, 5,23));
        System.out.println(findNumbers(3, 23,5));
        System.out.println(findNumbers(1, 5,23));
        System.out.println(findNumbers(2, 5,23));
        System.out.println(findNumbers(9, 5,23));
        System.out.println(findNumbers(0, 5,7));
        System.out.println(findNumbers(7, 1,9));
        System.out.println(findNumbers(7, 9,1));
    }
}
