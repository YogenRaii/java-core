package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/black-shapes/
 * <p>
 * <p>
 * Given N * M field of O's and X's, where O=white, X=black
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 * <p>
 * Example:
 * <p>
 * OOOXOOO
 * OOXXOXO
 * OXOOOXO
 * <p>
 * answer is 3 shapes are  :
 * (i)    X
 * X X
 * (ii)
 * X
 * (iii)
 * X
 * X
 * Note that we are looking for connected shapes here.
 */
public class BlackShapes {
    /**
     * Answer := 0
     * Loop i = 1 to N :
     *     Loop j = 1 to M:
     *           IF MATRIX at i, j equal to 'X' and not visited:
     *                  BFS/DFS to mark the connected area as visited
     *                  update Answer
     *     EndLoop
     * EndLoop
     *
     * return Answer
     *
     * @param graph
     * @return
     */
    public int black(String[] graph) {
        if (graph == null) return 0;

        int width = graph[0].length();
        int height = graph.length;

        boolean[][] adjMatrix = new boolean[height][width];

        int graphs = 0;
        for (int row = 0; row < graph.length; row++) {
            char[] chars = graph[row].toCharArray();

            for (int column = 0; column < chars.length; column++) {
                char ch = chars[column];
                if (ch == 'X' && !adjMatrix[row][column]) {
                    // encountered graph
                    graphs++;


                    // do bfs
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{row, column});
                    adjMatrix[row][column] = true;

                    while (!queue.isEmpty()) {
                        int[] box = queue.poll();

                        int r = box[0];
                        int c = box[1];
                        adjMatrix[r][c] = true;

                        if ((c + 1) < width) {
                            char next = graph[r].toCharArray()[c + 1];
                            if (next == 'X' && !adjMatrix[r][c + 1]) {
                                queue.add(new int[]{r, c + 1});
                            }
                        }

                        if ((c - 1) > -1) {
                            char next = graph[r].toCharArray()[c - 1];
                            if (next == 'X' && !adjMatrix[r][c - 1]) {
                                queue.add(new int[]{r, c - 1});
                            }
                        }

                        if ((r + 1) < height) {
                            char next = graph[r + 1].toCharArray()[c];
                            if (next == 'X' && !adjMatrix[r + 1][c]) {
                                queue.add(new int[]{r + 1, c});
                            }
                        }

                        if ((r - 1) > -1) {
                            char next = graph[r - 1].toCharArray()[c];
                            if (next == 'X' && !adjMatrix[r - 1][c]) {
                                queue.add(new int[]{r - 1, c});
                            }
                        }
                    }
                }
            }
        }


        return graphs;
    }

    @Test
    public void testBlack() {
        String[] input1 = new String[] {"OOOXOOO", "OOXXOXO", "OXOOOXO"};
        assertEquals(3, black(input1));

        String[] input2 = new String[] {"XOOOOOXXOX", "OOXXXXOOXX", "XXOXXOOXXO", "OXOXXXXXXO", "XOXXOXOXXX", "OOOOOOOXOO", "XOXXXOOXOX", "XXXOXOXXXO"};
        assertEquals(7, black(input2));
    }


    // this uses dfs
    public int blackRecursive(String[] graph) {
        if (graph == null) return 0;

        int width = graph[0].length();
        int height = graph.length;

        char[][] graphMatrix = new char[height][width];

        for (int idx = 0; idx < graph.length; idx++) {
            graphMatrix[idx] = graph[idx].toCharArray();
        }

        int graphs = 0;
        for (int row = 0; row < graphMatrix.length; row++) {
            for (int column = 0; column < graphMatrix[0].length; column++) {
                char ch = graphMatrix[row][column];
                if (ch == 'X') {
                    // encountered graph
                    graphs++;

                    updateConnected(graphMatrix, row, column);
                }
            }
        }


        return graphs;
    }

    private void updateConnected(char[][] graphMatrix, int row, int column) {
        if (row < 0 || row > graphMatrix.length - 1 || column < 0 || column > graphMatrix[0].length - 1) return;

        if (graphMatrix[row][column] != 'X') return;

        graphMatrix[row][column] = 'O';

        updateConnected(graphMatrix, row - 1, column);
        updateConnected(graphMatrix, row + 1, column );
        updateConnected(graphMatrix, row, column - 1);
        updateConnected(graphMatrix, row, column + 1);
    }

    @Test
    public void testBlackRecursive() {
        String[] input1 = new String[] {"OOOXOOO", "OOXXOXO", "OXOOOXO"};
        assertEquals(3, blackRecursive(input1));

        String[] input2 = new String[] {"XOOOOOXXOX", "OOXXXXOOXX", "XXOXXOOXXO", "OXOXXXXXXO", "XOXXOXOXXX", "OOOOOOOXOO", "XOXXXOOXOX", "XXXOXOXXXO"};
        assertEquals(7, blackRecursive(input2));
    }
}
