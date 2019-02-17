package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


/**
 * here are a total of N courses you have to take, labeled from 1 to N. Some courses may have prerequisites,
 * for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses. return 1/0 if it is possible/not possible.
 * The list of prerequisite pair are given in two integer arrays B and C where B[i] is a prerequisite for C[i].
 * <p>
 * Example: If N = 3 and the prerequisite pairs are [1,2] and [2,3], then you can finish courses in the following
 * order: 1, 2 and 3. But if N = 2 and the prerequisite pairs are [1,2] and [2,1], then it is not possible for you to finish all the courses.
 * <p>
 * <p>
 * 1. courseToPrerequisite count
 * <p>
 * 2. noPreCourse: no prerequisite courses list
 * <p>
 * 3.
 * take each noPreCourse noPre
 * for each coursePair in input
 * if noPre == prerequisite
 * courseToPrerequisite[coursePair]--
 */
public class CourseSchedule {
    public int findCourseCompleteSemesters(int[][] coursePairs) {
        if (coursePairs == null) throw new IllegalArgumentException("Course pairs can not be null!");

        if (coursePairs.length == 0) return 0;

        // find course to prerequisite count
        Map<Integer, Integer> coursePrereqCount = new HashMap<>();

        for (int[] pair : coursePairs) {
            if (coursePrereqCount.containsKey(pair[1])) {
                coursePrereqCount.put(pair[1], coursePrereqCount.get(pair[1]) + 1);
            } else {
                coursePrereqCount.put(pair[1], 1);
            }

            if (!coursePrereqCount.containsKey(pair[0])) {
                coursePrereqCount.put(pair[0], 0);
            }
        }

        // find courses that doesn't have prerequisite
        Queue<Integer> noPreCourses = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : coursePrereqCount.entrySet()) {
            if (entry.getValue() == 0) {
                noPreCourses.add(entry.getKey());
            }
        }

        int semester = 0;
        // do until no courses has prerequisite
        while (!noPreCourses.isEmpty()) {
            // got into next semester
            semester++;

            int prereq = noPreCourses.poll();

            for (int i = 0; i < coursePairs.length; i++) {
                if (coursePairs[i][0] == prereq) {
                    coursePrereqCount.put(coursePairs[i][1], coursePrereqCount.get(coursePairs[i][1]) - 1);

                    if (coursePrereqCount.get(coursePairs[i][1]) == 0) {
                        noPreCourses.add(coursePairs[i][1]);
                    }
                }
            }
        }

        return semester;
    }

    @Test
    public void testFindCourseCompleteSemesters() {

        assertEquals(2, findCourseCompleteSemesters(new int[][]{{1, 0}}));
        assertEquals(3, findCourseCompleteSemesters(new int[][]{{1, 2}, {2, 3}}));
    }

    /**
     * https://www.interviewbit.com/problems/possibility-of-finishing-all-courses-given-prerequisites/
     *
     * @param count
     * @param prerequisites
     * @param courses
     * @return
     */
    public int solve(int count, int[] prerequisites, int[] courses) {
        // create adj list of prerequisites to course
        List<Integer>[] prereqToCourses = new ArrayList[count + 1];

        for (int i = 0; i < prereqToCourses.length; i++) {
            prereqToCourses[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            prereqToCourses[prerequisites[i]].add(courses[i]);
        }

        // to track if the prerequisite is completed
        boolean[] visited = new boolean[count+1];

        Stack<Integer> stack = new Stack<>();
        stack.push(prerequisites[0]);
        visited[prerequisites[0]] = true;

        while (!stack.isEmpty()) {
            int prereq = stack.pop();
            List<Integer> dependents = prereqToCourses[prereq];

            for (int i = 0; i < dependents.size(); i++) {
                int dependent = dependents.get(i);

                // if dependent is already completed, then it forms cycle and hence course can not be completed
                if (visited[dependent]) return 0;
                else {
                    visited[dependent] = true;
                    stack.push(dependent);
                }
            }
        }

        return 1;
    }

    @Test
    public void testSolve() {
        assertEquals(1, solve(4, new int[]{1, 2, 1}, new int[]{2, 3, 4}));
        assertEquals(1, solve(2, new int[]{1}, new int[]{0}));
        assertEquals(0, solve(2, new int[]{1, 0}, new int[]{0, 1}));

    }

    /**
     * https://leetcode.com/problems/course-schedule/submissions/
     *
     * @param numCourses
     * @param coursePairs
     * @return
     */
    public boolean canFinish(int numCourses, int[][] coursePairs) {
        if (coursePairs == null) throw new IllegalArgumentException("Course pairs can not be null!");

        if (coursePairs.length == 0) return true;

        // find prerequisite to dependents list (adj list)
        int[][] adjMatrix = new int[numCourses][numCourses];
        int[] prereCount = new int[numCourses];

        for (int[] pair: coursePairs) {
            adjMatrix[pair[0]][pair[1]] = 1;
            prereCount[pair[1]]++;
        }

        Stack<Integer> noPreCourses = new Stack<>();

        for (int i = 0; i < prereCount.length; i++) {
            if (prereCount[i] == 0) noPreCourses.push(i);
        }

        int count = 0;

        while (!noPreCourses.isEmpty()) {
            int noPre = noPreCourses.pop();
            count++;

            for (int i = 0; i < numCourses; i++) {
                if (adjMatrix[noPre][i] != 0) {
                    if (--prereCount[i] == 0) {
                        noPreCourses.push(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    @Test
    public void testCanFinish() {
        assertTrue(canFinish(2, new int[][]{{1, 0}}));
        assertTrue(canFinish(1, new int[][]{}));
        assertFalse(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        assertTrue(canFinish(3, new int[][]{{0, 1}, {0, 2}, {1,2}}));
    }
}
