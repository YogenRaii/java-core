package com.eprogrammerz.examples.java8.comparators;

/**
 * @author Yogen Rai
 */
public class Student {
    private String name;
    private double age;

    public Student(String name, double age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Student)) return false;

        Student student = (Student) o;
        if (this.name.equals(student.getName()) && this.age == student.getAge()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + "]";
    }
}
