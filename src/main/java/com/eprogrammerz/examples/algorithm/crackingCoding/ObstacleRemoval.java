package com.eprogrammerz.examples.algorithm.crackingCoding;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * 1 -> valid grid
 * 0 -> barrier
 * 9 -> obstacle
 * Find the shortest path for robot to get to the obstacle starting from top left most grid
 */
public class ObstacleRemoval {
    public int findShortestPath(int rowNum, int colNum, int[][] lot) {
        boolean[][] visited = new boolean[rowNum][colNum];
        int[][] distances = new int[rowNum][colNum];

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,0));
        distances[0][0] = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            int distance = distances[x][y];

            if (lot[x][y] == 9) return distance;

            visited[x][y] = true;

            if (isValid(x + 1, y, rowNum, colNum, visited, lot)) {
                queue.add(new Pair(x + 1, y));
                distances[x + 1][y] = distances[x][y] + 1;
            }

            if (isValid(x, y + 1, rowNum, colNum, visited, lot)) {
                queue.add(new Pair(x , y +1));
                distances[x][y + 1] = distances[x][y] + 1;
            }

            if (isValid(x - 1, y, rowNum, colNum, visited, lot)) {
                queue.add(new Pair(x - 1, y));
                distances[x - 1][y] = distances[x][y] + 1;
            }

            if (isValid(x, y - 1, rowNum, colNum, visited, lot)) {
                queue.add(new Pair(x, y - 1));
                distances[x][y - 1] = distances[x][y] + 1;
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, int rowNum, int colNum, boolean[][] visited, int[][] lot) {
        if (x >= 0 && x < rowNum && y >= 0 && y < colNum && !visited[x][y] && (lot[x][y] == 1 || lot[x][y] == 9)) {
            return true;
        }
        return false;
    }

    private class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    @Test
    public void testShortestPath() {
        int[][] lot1 = new int[][] {
                {1,0,0},
                {1,0,0},
                {1,9,0}
        };
        assertEquals(3, findShortestPath(3,3,lot1));

        int[][] lot2 = new int[][] {
                {1,0,0},
                {1,1,0},
                {1,1,9}
        };
        assertEquals(4, findShortestPath(3,3,lot2));

        int[][] lot3 = new int[][] {
                {1,1,1,1},
                {1,1,0,1},
                {1,0,0,9},
                {1,1,1,1}
        };
        assertEquals(5, findShortestPath(4,4,lot3));
    }
}
