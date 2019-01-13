package com.eprogrammerz.examples.algorithm.leetcode;

import com.google.common.base.Objects;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class IntervalMerger {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()) return result;

        intervals.sort(Comparator.comparingInt(i -> i.start));

        Stack<Interval> stack = new Stack<>();

        stack.push(intervals.get(0));

        for (Interval interval : intervals) {
            Interval last = stack.pop();

            if (last.end >= interval.start) {
                // merging
                last.end = last.end > interval.end ? last.end : interval.end;
                stack.push(last);
            } else {
                result.add(last);
                stack.push(interval);
            }
        }

        if (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    @Test
    public void testMerge() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,3));

        List<Interval> expected = new ArrayList<>();
        expected.add(new Interval(1,4));

        assertEquals(expected, merge(intervals));
    }

}


class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return start == interval.start &&
                end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(start, end);
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}