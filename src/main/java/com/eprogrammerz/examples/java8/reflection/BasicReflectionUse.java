package com.eprogrammerz.examples.java8.reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Yogen Rai
 */
public class BasicReflectionUse {
    @Test
    public void testStudentWhenCreated() {
        Student student = new Student(1, "Yogen");

        Class<?> clazz = student.getClass();

        // class name
        assertEquals("Student", clazz.getSimpleName());
        assertEquals("com.eprogrammerz.examples.java8.reflection.Student", clazz.getName());
        // package name
        assertEquals("com.eprogrammerz.examples.java8.reflection", clazz.getPackage().getName());

        // modifier
        assertFalse(Modifier.isPublic(clazz.getModifiers()));


        // fields
        Field[] fields = clazz.getDeclaredFields();
        List<String> actualFieldNames = getFieldNames(fields);

        List<String> expectedFieldNames = Arrays.asList("id", "name");
        assertEquals(expectedFieldNames, actualFieldNames);

        // methods
        Method[] methods = clazz.getDeclaredMethods();
        List<String> actualMethodNames = getMethodNames(methods);
        List<String> expectedMethodNames = Arrays.asList("getName", "getId");
        assertEquals(expectedMethodNames, actualMethodNames);
    }

    private List<String> getMethodNames(Method[] methods) {
        return Arrays.stream(methods).map(Method::getName).collect(Collectors.toList());
    }

    private List<String> getFieldNames(Field[] fields) {
        return Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());
    }
}


class Student {
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}