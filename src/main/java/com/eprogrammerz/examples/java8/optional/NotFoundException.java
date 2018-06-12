package com.eprogrammerz.examples.java8.optional;

/**
 * @author Yogen Rai
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
