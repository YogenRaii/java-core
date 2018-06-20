package com.eprogrammerz.examples.java8.testing;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author Yogen Rai
 */
public class LambdaTester {
    public static final Logger LOGGER = LoggerFactory.getLogger(LambdaTester.class);

    public static Class[] mapClasses(final List<String> exceptions) {
        return exceptions.stream().map(className -> {
            try {
                return Class.forName(className);
            } catch(Exception ex) {
                LOGGER.error("Failed to load class for exceptionWhiteList: {}", className);
            }
            return null;
        } ).toArray(Class[]::new);
    }

    public static Class[] mapClassesBetter(final List<String> exceptions) {
        return exceptions.stream().map(LambdaTester::mapClass).toArray(Class[]::new);
    }

    public static Class mapClass(String className) {
        try {
            return Class.forName(className);
        } catch(Exception ex) {
            LOGGER.error("Failed to load class for name: {}", className);
        }
        return null;
    }

    @Test
    public void testMapClass() throws ClassNotFoundException {
        assertEquals(null, mapClass("a"));
        assertEquals(null, mapClass("apple"));
        assertEquals(Object.class, mapClass("java.lang.Object"));
    }

    @Test
    public void testMapClasses() {
        Class[] expected = new Class[]{null, null, Object.class};
        List<String> input = Arrays.asList("a", "apple", "java.lang.Object");

        assertArrayEquals(expected, mapClasses(input));
    }

    @Test
    public void testMapClassesBetter() {
        Class[] expected = new Class[]{null, null, Object.class};
        List<String> input = Arrays.asList("a", "apple", "java.lang.Object");

        assertArrayEquals(expected, mapClassesBetter(input));
    }
}
