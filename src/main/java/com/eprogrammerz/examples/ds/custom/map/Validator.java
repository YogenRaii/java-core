package com.eprogrammerz.examples.ds.custom.map;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

public class Validator {
    @Test
    public void testMyMap() {
        MyMap<String, String> myMap = new MyMap<>(3);
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");

        assertNotNull(myMap);
        assertEquals(4, myMap.size());
        assertEquals("Kathmandu", myMap.get("Nepal"));
        assertEquals("Sydney", myMap.get("Australia"));
    }
}
