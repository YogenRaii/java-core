package com.eprogrammerz.examples.java8.comparators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class StudentSortNew {
    public enum SORT_METHOD {BYNAME, BYAGE}

    public void sort(final List<Student> students, final SORT_METHOD method) {
        if (SORT_METHOD.BYNAME == method) {
            Collections.sort(students, Comparator.comparing(s -> s.getName()));
        } else {
            Collections.sort(students, Comparator.comparing(s -> s.getAge()));
        }
    }

    @Test
    public void testSortByName() {
        final List<Student> students = getStudents();

        sort(students, SORT_METHOD.BYNAME);

        assertEquals(new Student("Pratima", 25), students.get(0));
        assertEquals(new Student("Yogen", 23), students.get(1));
    }

    @Test
    public void testSortByAge() {
        final List<Student> students = getStudents();

        sort(students, SORT_METHOD.BYAGE);

        assertEquals(new Student("Yogesh", 21), students.get(0));
        assertEquals(new Student("Yogen", 23), students.get(1));
    }

    public List<Student> getStudents() {
        final List<Student> students = new ArrayList<>();
        students.add(new Student("Yogen", 23));
        students.add(new Student("Pratima", 25));
        students.add(new Student("Yogesh", 21));
        return students;
    }
}
