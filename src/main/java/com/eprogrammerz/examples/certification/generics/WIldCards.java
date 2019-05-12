package com.eprogrammerz.examples.certification.generics;

import java.util.HashSet;
import java.util.Set;

public class WIldCards {
    public static void main(String[] args) {
        Set<? extends RuntimeException> exceptions1 = new HashSet<NullPointerException>(); // OK
        Set<? extends RuntimeException> exceptions2 = new HashSet<RuntimeException>(); // ok
//        Set<? extends RuntimeException> exceptions3 = new HashSet<Exception>(); // not ok
//        Set<? extends RuntimeException> exceptions3 = new HashSet<? extends RuntimeException>(); // not ok

        System.out.println(1/0.0); // prints Infinity
        System.out.println(1/0); // throws an ArithmeticException
    }
}
