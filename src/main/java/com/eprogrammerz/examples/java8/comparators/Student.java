package com.eprogrammerz.examples.java8.comparators;

/**
 * @author Yogen Rai
 */
public class Student {
    private final String name;
    private final float age;

    public Student(String name, float age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public float getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;
        return this.name.equals(student.getName()) && this.age == student.getAge();
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + "]";
    }
}
