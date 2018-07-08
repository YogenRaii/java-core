package com.eprogrammerz.examples.ds.custom.map;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

public class Validator {
    @Test
    public void testMyMap() {
        MyMap<String, Object> myMap = new MyMap();
        myMap.put("yogen", "Yogen");
        myMap.put("yogen", "Ram");
        myMap.put("rita", "Rita");
        myMap.put("gita", "Gita");
        myMap.put("shyam", "Shyam");
        myMap.put("man", "Man");
        myMap.put("dan", "Dan");
        myMap.put("Jan", "Jan");

        assertNotNull(myMap);
        assertNull(myMap.get("Yogen"));
        assertEquals("Ram", myMap.get("yogen"));
        assertEquals("Shyam", myMap.get("shyam"));
    }
}
