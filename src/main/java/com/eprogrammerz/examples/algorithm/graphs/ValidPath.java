package com.eprogrammerz.examples.algorithm.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There is a rectangle with left bottom as  (0, 0) and right up as (x, y). There are N circles such that their centers are inside the rectangle.
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 * <p>
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 */
public class ValidPath {
    public String solve(int tx, int ty, int n, int r, List<Integer> cx, List<Integer> cy) {
        int[] dx = {1, 0, -1, -1, -1, 0, 1, 1};
        int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        boolean[][] visited = new boolean[tx + 1][ty + 1];

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            visited[x][y] = true;

            if (x == tx && y == ty) return "YES";

            for (int i = 0; i < 8; i++) {
                x = x + dx[i];
                y = y + dy[i];

                if (isValid(x, y, tx, ty, n, r, cx, cy) && !visited[x][y]) {
                    queue.add(new int[]{x, y});
                }
            }
        }
        return "NO";
    }

    private boolean isValid(int x, int y, int tx, int ty, int n, int r, List<Integer> cx, List<Integer> cy) {
        if (x < 0 || y < 0 || x > tx || y > ty) return false;

        // check if (x,y) falls in one of the circle
        for (int i = 0; i < n; i++) {
            int centerX = cx.get(i);
            int centerY = cy.get(i);

            if (Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)) <= r) {
                return false;
            }

        }

        return true;
    }
}
