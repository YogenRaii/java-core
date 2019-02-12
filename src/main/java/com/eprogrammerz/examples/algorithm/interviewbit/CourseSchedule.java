package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

        if (prerequisites.length == 0) return 0;

        // find course to prerequisite count
        Map<Integer, Integer> coursePrereqCount = new HashMap<>();

        for (int i = 0; i < courses.length; i++) {
            if (coursePrereqCount.containsKey(courses[i])) {
                coursePrereqCount.put(courses[i], coursePrereqCount.get(courses[i]) + 1);
            } else {
                coursePrereqCount.put(courses[i], 1);
            }

            if (!coursePrereqCount.containsKey(prerequisites[i])) {
                coursePrereqCount.put(prerequisites[i], 0);
            }
        }

        // find courses that doesn't have prerequisite
        Queue<Integer> noPreCourses = new LinkedList<>();

        for (Map.Entry<Integer, Integer> entry : coursePrereqCount.entrySet()) {
            if (entry.getValue() == 0) {
                noPreCourses.add(entry.getKey());
            }
        }

        int completed = noPreCourses.size();
        // do until no courses has prerequisite
        while (!noPreCourses.isEmpty()) {

            int prereq = noPreCourses.poll();

            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i] == prereq) {
                    coursePrereqCount.put(courses[i], coursePrereqCount.get(courses[i]) - 1);

                    if (coursePrereqCount.get(courses[i]) == 0) {
                        completed++;
                        noPreCourses.add(courses[i]);
                    }
                }
            }
        }

        return completed == count ? 1 : 0;
    }

    @Test
    public void testSolve() {

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

        int completed = noPreCourses.size();
        // do until no courses has prerequisite
        while (!noPreCourses.isEmpty()) {

            int prereq = noPreCourses.poll();

            for (int i = 0; i < coursePairs.length; i++) {
                if (coursePairs[i][0] == prereq) {
                    coursePrereqCount.put(coursePairs[i][1], coursePrereqCount.get(coursePairs[i][1]) - 1);

                    if (coursePrereqCount.get(coursePairs[i][1]) == 0) {
                        completed++;
                        noPreCourses.add(coursePairs[i][1]);
                    }
                }
            }
        }

        return completed == numCourses;
    }

    @Test
    public void testCanFinish() {
        assertTrue(canFinish(2, new int[][]{{1, 0}}));
        assertTrue(canFinish(1, new int[][]{}));
        assertFalse(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
