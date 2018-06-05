package com.eprogrammerz.examples.java8.comparators;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class StudentSorterOld {
    public enum SORT_METHOD {BYNAME, BYAGE}

    public void sort(final List<Student> students, final SORT_METHOD method) {
        Collections.sort(students, (s1, s2) -> {
            if (SORT_METHOD.BYNAME == method) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            } else {
                if (s1.getAge() == s2.getAge()) return 0;
                else if (s1.getAge() < s2.getAge()) return -1;
                else return 1;
            }
        });
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
