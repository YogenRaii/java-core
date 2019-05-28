package com.eprogrammerz.examples.certification.generics;

import java.io.IOException;
import java.util.*;

/**
 * Example of generic parameter
 *
 */
public class WildCardEx {

    public void showSize(List<?> list) {
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        WildCardEx wildCard = new WildCardEx();
//        List<? extends Number> list = new ArrayList<Integer>(); // OK
//        List<Exception> list = new ArrayList<IOException>(); // Not OK
//        List<? extends Exception> list = new ArrayList<IOException>(); // OK
        Vector<? extends Number> list = new Vector<Integer>(); // ok
//        ArrayDeque<? extends Date> list = new ArrayDeque<>(); // Not ok since ArrayDeque is not List
        wildCard.showSize(list);
    }
}
