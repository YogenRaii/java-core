package com.eprogrammerz.examples.java8.dateTime;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
final class Student {
    private final String name;
    private final int age;
    private final LocalDate dateJoined;

    public Student(String name, int age, LocalDate dateJoined) {
        this.name = name;
        this.age = age;
        this.dateJoined = dateJoined;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;
        return this.name.equals(student.getName()) && this.age == student.getAge() && this.dateJoined.equals(student.getDateJoined());
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + "]";
    }
}

public class TestImmutable {
    @Test
    public void testImmutableObject() {
        Student original = new Student("Yogen", 23, LocalDate.of(2016, 5, 1));

        LocalDate modifiedLocalDate = original.getDateJoined().plusYears(2);

        Student expected = new Student("Yogen", 23, LocalDate.of(2016, 5, 1));
        assertEquals(expected, original);
    }
}
