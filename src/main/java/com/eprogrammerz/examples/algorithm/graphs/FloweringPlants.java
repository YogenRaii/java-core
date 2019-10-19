package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;


/**
 * You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.
 *
 * paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.
 *
 * Also, there is no garden that has more than 3 paths coming into or leaving it.
 *
 * Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.
 *
 * Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.
 * The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 3, paths = [[1,2],[2,3],[3,1]]
 * Output: [1,2,3]
 */
public class FloweringPlants {
    public int[] gardenNoAdj(int N, int[][] paths) {
        // 1 --- 2
        // |     |
        //  --3--

        // adjacency matrix
        // 1 - [2,3]
        // 2 - [1,3]
        // 3 - [1,2]

        // 1 - 1
        // 2 - 2
        int[] colors = new int[N];

        Arrays.fill(colors, 1);

        Map<Integer, List<Integer>> gardens = new HashMap<>();

        for (int[] path : paths) {
            List<Integer> neighbors = gardens.get(path[0]);
            if (neighbors == null) {
                neighbors = new ArrayList<>();
            }
            neighbors.add(path[1]);
            gardens.put(path[0], neighbors);

            neighbors = gardens.get(path[1]);
            if (neighbors == null) {
                neighbors = new ArrayList<>();
            }
            neighbors.add(path[0]);
            gardens.put(path[1], neighbors);
        }

        for (int garden : gardens.keySet()) {
            List<Integer> neighbors = gardens.get(garden);

            int[] gone = new int[5];
            for (int n : neighbors) {
                if (colors[n - 1] != -1) {
                    gone[colors[n - 1]] = colors[n - 1];
                }
            }

            int color = 1;

            for (int i = 1; i <= 5; i++) {
                if (gone[i] != i) {
                    color = i;
                    break;
                }
            }
            colors[garden - 1] = color;
        }
        return colors;
    }

    @Test
    public void test1() {
        int[] expected = new int[]{2, 3, 1};
        int[][] paths = new int[][]{
                {1, 2},
                {2, 3},
                {3, 1}
        };
        assertArrayEquals(expected, gardenNoAdj(3, paths));
    }

    @Test
    public void test2() {
        int[] expected = new int[]{2, 1, 2, 1};
        int[][] paths = new int[][]{
                {1, 2},
                {3, 4}
        };
        assertArrayEquals(expected, gardenNoAdj(4, paths));
    }

    @Test
    public void test3() {
        int[] expected = new int[]{2, 3, 4, 1};
        int[][] paths = new int[][]{
                {1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}
        };
        assertArrayEquals(expected, gardenNoAdj(4, paths));
    }
}
