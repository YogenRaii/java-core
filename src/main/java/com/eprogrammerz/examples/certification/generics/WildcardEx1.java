package com.eprogrammerz.examples.certification.generics;

/**
 * Example of generic method
 */
public class WildcardEx1 {
//    public static <?> T identity(T t) { // not ok since type has to be specified
    public static <T> T identity(T t) {
        return t;
    }
}
