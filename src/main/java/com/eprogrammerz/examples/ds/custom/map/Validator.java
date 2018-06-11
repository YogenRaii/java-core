package com.eprogrammerz.examples.ds.custom.map;

import org.junit.Test;

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

        System.out.println(myMap);

        System.out.println(myMap.get("yogen"));
        System.out.println(myMap.get("Yogen"));
    }
}
