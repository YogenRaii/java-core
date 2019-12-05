package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertFalse;


/**
 * https://leetcode.com/problems/possible-bipartition/submissions/
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {

        // create graph with people disliking each other
        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] dislike: dislikes) {
            int u = dislike[0];
            int v = dislike[1];
            graph[u].add(v);
            graph[v].add(u);
        }


        // to track if particular person node has been visited
        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);

        // this is to make sure all graphs in forests has been visited
        for (int i = 1; i <= N; i++) {
            if (visited[i] == -1) {
                Stack<int[]> stack = new Stack<>();
                stack.push(new int[] {i, 0}); // stack [vertex,odd or even]

                while (!stack.isEmpty()) {
                    int[] pair = stack.pop();
                    int curr = pair[0];
                    int status = pair[1];

                    List<Integer> neb = graph[curr];
                    for (int n: neb) {
                        // if not visited, add into stack with opposite status
                        if (visited[n] == -1) {
                            visited[n] = status == 0 ? 1 : 0;
                            stack.push(new int[] {n, visited[n]});
                        } else {
                            if (visited[n] == status) return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    @Test
    public void test() {
        int[][] dislikes = new int[][] {
                {1,2},{3,4},{4,5},{3,5}
        };
        assertFalse(possibleBipartition(5, dislikes));
    }
}
