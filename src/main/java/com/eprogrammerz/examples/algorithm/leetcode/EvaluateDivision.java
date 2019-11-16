package com.eprogrammerz.examples.algorithm.leetcode;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;

/**
 * https://leetcode.com/problems/evaluate-division/submissions/
 *
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 * where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 */
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;

        // construct graph with adj list
        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);

            double w = values[i];

            // this is for edge u -> v
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            List<Pair> uNeighbors = graph.get(u);
            uNeighbors.add(new Pair(v, w));

            // there is also an edge v -> u with weight 1/w
            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }
            List<Pair> vNeighbors = graph.get(v);
            vNeighbors.add(new Pair(u, (1.0) / w));
        }

        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String u = q.get(0);
            String v = q.get(1);

            // if there is no node with either of u or v, then division not possible
            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                res[i] = -1.0;
            } else { // else do bfs
                res[i] = bfs(graph, u, v);
            }
        }

        return res;
    }

    private double bfs(Map<String, List<Pair>> graph, String src, String dst) {

        Pair srcPair = new Pair(src, 1.0);
        Queue<Pair> q = new LinkedList<>();
        q.add(srcPair);

        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            Pair p = q.poll();
            visited.add(p.name);

            if (p.name.equals(dst)) {
                return p.val;
            }

            for (Pair n : graph.get(p.name)) {
                if (!visited.contains(n.name)) {
                    double newVal = n.val * p.val;
                    q.add(new Pair(n.name, newVal));
                }
            }
        }
        return -1.0;
    }

    class Pair {
        String name;
        double val;

        Pair(String name, double val) {
            this.name = name;
            this.val = val;
        }
    }

    @Test
    public void test() {
        assertArrayEquals(
                new double[] {6.00000,0.50000,-1.00000,1.00000,-1.00000},
                calcEquation(asList(asList("a","b"),asList("b","c")), new double[] { 2.0,3.0}, asList(asList("a","c"),asList("b","a"),asList("a","e"),asList("a","a"),asList("x","x"))),
                0.0);
    }
}
