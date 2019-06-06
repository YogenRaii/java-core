package com.eprogrammerz.examples.algorithm.graphs;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects,
 * where the second project is dependent on the first project).
 * All of a project's dependencies must be built before the project is.
 * Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
 * EXAMPLE
 * Input:
 * projects: a, b, c, d, e, f
 * dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output: f, e, a, b, d, c
 */
public class BuildOrder {
    List<Integer> findBuildOrder(List<Integer> projects, List<Pair> dependencies) {
        Map<Integer, Set<Integer>> projectToDependencies = new HashMap<>();

        // initialize project to empty set
        for (int project : projects) {
            projectToDependencies.put(project, new HashSet<>());
        }

        // set project to dependencies
        for (Pair pair : dependencies) {
            Set<Integer> dep = projectToDependencies.get(pair.y);
            dep.add(pair.x);
        }

        // adj list representation of dependencies
//        System.out.println(projectToDependencies); // {1=[6], 2=[6], 3=[4], 4=[1, 2], 5=[], 6=[]}
        // build order storing variable
        List<Integer> buildOrder = new ArrayList<>();

        // to track the completed ones
        Queue<Integer> toBeBuilt = new LinkedList<>();
        projectToDependencies.forEach((p, d) -> {
            if (d.isEmpty()) {
                toBeBuilt.add(p);
            }
        });

        while (!toBeBuilt.isEmpty()) {
            int ready = toBeBuilt.poll();
            buildOrder.add(ready);

            // scan this to each dependencies
            // if found, remove that
            // after removal, if empty
            // add that to queue

            projectToDependencies.forEach((p, d) -> {
                if (d.remove(ready) && d.isEmpty()) {
                    toBeBuilt.add(p);
                }
            });
        }

        return buildOrder;
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    @Test
    public void testFindBuildOrder() {

        List<Integer> projects = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Pair> deps = Arrays.asList(new Pair(1, 4), new Pair(2, 4), new Pair(6, 2), new Pair(6, 1), new Pair(4, 3));
        List<Integer> buildOrder = findBuildOrder(projects, deps);
        List<Integer> expected = Arrays.asList(5, 6, 1, 2, 4, 3);
        assertEquals(expected, buildOrder);
    }
}
