package com.eprogrammerz.examples.algorithm.interviewbit;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://www.interviewbit.com/problems/points-on-the-straight-line/
 */
public class StraightLinePoints {
    public int maxPoints(List<Integer> xs, List<Integer> ys) {
        if (xs.size() <= 2) return xs.size();

        int maxPoints = 0;

        for (int idx = 0; idx < xs.size() - 2; idx++) {
            int x1 = xs.get(idx);
            int x2 = xs.get(idx + 1);

            int y1 = ys.get(idx);
            int y2 = ys.get(idx + 1);

            int currentLinePoints = 2;

            for (int third = idx + 2; third < xs.size(); third++) {
                if (((x1 - xs.get(third)) * (y2-ys.get(third))) == ((x2 - xs.get(third))* (y1-ys.get(third)))) {
                    currentLinePoints++;
                }
            }

            if (maxPoints < currentLinePoints) {
                maxPoints = currentLinePoints;
            }
        }


        return maxPoints;
    }

    @Test
    public void testMaxPointsWithTwoPoints() {
        List<Integer> xs = Arrays.asList(1,2);
        List<Integer> ys = Arrays.asList(1,2);

        assertEquals(2, maxPoints(xs, ys));
    }

    @Test
    public void testMaxPointsWithMorePoints() {
        List<Integer> xs = Arrays.asList(-1,1,2,3,0,1);
        List<Integer> ys = Arrays.asList(-3,1,2,3,0,-1);

        assertEquals(4, maxPoints(xs, ys));
    }

    @Test
    public void testMaxPointsWithSamePoints() {
        List<Integer> xs = Arrays.asList(1,1,1,1,1);
        List<Integer> ys = Arrays.asList(1,1,1,1,1);

        assertEquals(5, maxPoints(xs, ys));
    }

    public int maxPointsOnlySlope(List<Integer> xs, List<Integer> ys) {
        if (xs.size() <= 2) return xs.size();

        int maxPoints = 0;

        Map<Double, Integer> slopePoints = new HashMap<>();

        for (int idx = 0; idx < xs.size() - 1; idx++) {

            int duplicates = 1;

            int verticals = 0;

            for (int i = idx + 1; i < xs.size(); i++) {

                int dx = xs.get(i) - xs.get(idx);
                int dy = ys.get(i) - ys.get(idx);

                if (dx != 0) {
                    double m = ((double) dy) / dx;
                    if (slopePoints.containsKey(m)) {
                        slopePoints.put(m, slopePoints.get(m) + 1);
                    } else {
                        slopePoints.put(m, 1);
                    }
                } else {
                    if (dy == 0) {
                        duplicates++;
                    } else {
                        verticals++;
                    }
                }
            }

            for (int count: slopePoints.values()) {
                if (count + duplicates > maxPoints) {
                    maxPoints = count + duplicates;
                }
            }

            maxPoints = Math.max(maxPoints, verticals + duplicates);
            slopePoints.clear();
        }


        return maxPoints;
    }
}
