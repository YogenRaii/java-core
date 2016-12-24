package com.eprogrammerz.examples.java8.general;

/**
 * Created by 542596 on 12/8/2016.
 */
public class RegexExample {
    public static void main(String[] args) {

        String str = "C:/Yogen/api/content-api/content-delivery/src/main/resources/data-v1.json";
        String[] dirs = str.split("/");
        String fileName = dirs[dirs.length - 1];
        System.out.println(fileName);
    }
}
