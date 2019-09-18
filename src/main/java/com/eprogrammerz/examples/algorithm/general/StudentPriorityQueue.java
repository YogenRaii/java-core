package com.eprogrammerz.examples.algorithm.general;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Find order in which student can be served!
 * Criterion:
 * 1. Highest GPA first
 * 2. If same gpa, alphabetic order
 * 3. If same name, id ascending
 */

public class StudentPriorityQueue {
    @Test
    public void testGetStudents() {
        Priorities priorities = new Priorities();

        List<String> events = Arrays.asList(
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED");
        List<String> toBeServed = Arrays.asList("Dan", "Ashley", "Shafaet", "Maria");
        assertEquals(toBeServed, priorities.getStudents(events).stream().map(Student::getName).collect(Collectors.toList()));
    }
}

class Student {
    private int id;
    private String name;
    private double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getCGPA() {
        return this.cgpa;
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        Comparator<Student> c = (s1, s2) -> {
            double diff = s2.getCGPA() - s1.getCGPA();
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            }
            int nameComp = s1.getName().compareTo(s2.getName());
            if (nameComp == 0) return s1.getId() - s2.getId();

            return nameComp;
        };
        Queue<Student> queue = new PriorityQueue<>(c);
        for (String event : events) {
            if (event.startsWith("ENTER")) {
                String[] parts = event.split(" ");
                String name = parts[1];
                double cgpa = Double.valueOf(parts[2]);
                int id = Integer.valueOf(parts[3]);
                queue.add(new Student(id, name, cgpa));
            } else {
                queue.poll();
            }
        }

        List<Student> result = new ArrayList<>();
        while (!queue.isEmpty()){
            result.add(queue.poll());
        }
        return result;
    }
}
