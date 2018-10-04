package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Yogen Rai
 * <p>
 * 1 6 3 4 2 5
 * steps:
 * 1 3 4 2 5 6
 * 1 3 2 4 5 6
 * 1 2 3 4 5 6
 * <p>
 * Worst if array is sorted in ascending order
 * <p>
 * Best if only one element is out of order
 */
public class BubbleSorter {
    public static void bubbleSort(int[] arr) {
        boolean isSorted = false;

        // optimizes naive solution by limiting length of unsorted array on each pass
        int notSorted = arr.length - 1;
        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < notSorted; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            notSorted--;
        }
    }

    public static void bubbleSortForLoop(int[] arr) {
        // optimizes naive solution by limiting length of unsorted array on each pass
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int n, int m) {
        int temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    @Test
    public void testBubbleSortWhileLoop() {
        int[] arr = new int[]{1, 6, 3, 4, 2, 5};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        bubbleSort(arr);

        assertArrayEquals(arr, expected);
    }

    @Test
    public void testBubbleSortForLoop() {
        int[] arr = new int[]{1, 6, 3, 4, 2, 5};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        bubbleSortForLoop(arr);

        assertArrayEquals(arr, expected);
    }
}
