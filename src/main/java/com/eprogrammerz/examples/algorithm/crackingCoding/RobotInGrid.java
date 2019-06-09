package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that the robot cannot step on them.
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class RobotInGrid {
    public List<Pair> findPath(int[][] grid) {
        List<Pair> path = new ArrayList<>();
        if (grid == null) return path;

        findPath(grid, 0, 0, path);
        return path;
    }

    private boolean findPath(int[][] grid, int row, int col, List<Pair> path) {
        if (row >= grid.length || col >= grid[0].length || grid[row][col] == 1) {
            return false;
        }

        boolean isAtEnd = row == grid.length - 1 && col == grid[0].length - 1;

        if (isAtEnd || findPath(grid, row + 1, col, path) || findPath(grid, row, col + 1, path)) {
            path.add(0, new Pair(row, col));
            return true;
        }

        return false;
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair)) return false;

            Pair pair = (Pair) obj;

            return this.x == pair.x && this.y == pair.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    @Test
    public void testFindPathInGrid() {
        int[][] grid = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        List<Pair> path = findPath(grid);

        List<Pair> expected = new ArrayList<>(Arrays.asList(new Pair(0, 0), new Pair(0, 1), new Pair(0, 2), new Pair(1, 2), new Pair(2, 2)));
        assertThat(expected, is(path));
    }

}
