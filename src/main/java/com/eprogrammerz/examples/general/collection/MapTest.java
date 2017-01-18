package com.eprogrammerz.examples.general.collection;

import java.util.HashMap;

/**
 * Created by 542596 on 12/13/2016.
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<>();
        map.put("key1", new Student(12, "me"));
        map.put("key2", new Student(13, "you"));

        System.out.println(map);

        Student fromMap = map.get("key2");
        fromMap.setId(15);

        System.out.println(map);

    }
}
class Student{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString(){
        return "["+id+", "+name+"]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}