package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertArrayEquals;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adjMatrix = new int[numCourses][numCourses];

        int[] prereCount = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];

            adjMatrix[pre][course] = 1;
            prereCount[course]++;
        }

        Stack<Integer> stack = new Stack<>();

        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < prereCount.length; i++) {
            if (prereCount[i] == 0) {
                stack.push(i);
                order.add(i);
            }
        }

        while (!stack.isEmpty()) {
            int prere = stack.pop();

            for (int i = 0; i < numCourses; i++) {
                if (adjMatrix[prere][i] != 0) {
                    if (--prereCount[i] == 0) {
                        stack.push(i);
                        order.add(i);
                    }
                }
            }
        }

        if (order.size() != numCourses) return new int[]{};

        int[] result = new int[order.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = order.get(i);
        }

        return result;
    }

    @Test
    public void testFindOrder() {
        assertArrayEquals(new int[]{0, 1}, findOrder(2, new int[][]{{1, 0}}));
        assertArrayEquals(new int[]{0, 1, 2, 3}, findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }
}
