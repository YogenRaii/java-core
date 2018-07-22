package com.eprogrammerz.examples.algorithm.general;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Yogen Rai
 *
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements.
 * You need to find the minimum number of swaps required to sort the array in ascending order.
 */
public class MinimumSwap2 {
    static int minimumSwaps(int[] arr) {
        int swapCount = 0;

        Map<Integer, Integer> numberIndex = IntStream.range(0, arr.length)
                .boxed()
                .collect(Collectors.toMap(i -> arr[i], Function.identity()));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int reqIndex = numberIndex.get(i + 1);
                numberIndex.put(arr[i], reqIndex);
                numberIndex.put(i + 1, i);
                swap(arr, i, reqIndex);
                swapCount++;
            }
        }

        return swapCount;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
//        System.out.println(minimumSwaps(new int[]{7,1,3,2,4,5,6}));
        System.out.println(minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 8}));
    }
}
