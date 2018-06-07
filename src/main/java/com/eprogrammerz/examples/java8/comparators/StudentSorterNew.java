package com.eprogrammerz.examples.java8.comparators;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class StudentSorterNew {
    public enum SORT_METHOD {BYNAME, BYAGE}

    Function<Student, String> byName = e -> e.getName();
    Function<Student, Double> byAge = e -> e.getAge();

    public void sort(final List<Student> students, final SORT_METHOD method) {
        if (SORT_METHOD.BYNAME == method) {
            Collections.sort(students, Comparator.comparing(byName).thenComparing(byAge));
        } else {
            Collections.sort(students, Comparator.comparing(byAge).thenComparing(byName));
        }
    }

    @Test
    public void testSortByName() {
        final List<Student> students = getStudents();

        sort(students, SORT_METHOD.BYNAME);

        assertEquals(new Student("Pratima", 25), students.get(0));
        assertEquals(new Student("Reeta", 25), students.get(1));
        assertEquals(new Student("Yogen", 21), students.get(2));
        assertEquals(new Student("Yogen", 23), students.get(3));
    }

    @Test
    public void testSortByAge() {
        final List<Student> students = getStudents();

        sort(students, SORT_METHOD.BYAGE);

        assertEquals(new Student("Yogen", 21), students.get(0));
        assertEquals(new Student("Yogen", 23), students.get(1));
        assertEquals(new Student("Pratima", 25), students.get(2));
        assertEquals(new Student("Reeta", 25), students.get(3));
    }

    public List<Student> getStudents() {
        final List<Student> students = new ArrayList<>();
        students.add(new Student("Yogen", 23));
        students.add(new Student("Reeta", 25));
        students.add(new Student("Pratima", 25));
        students.add(new Student("Yogen", 21));
        return students;
    }
}
