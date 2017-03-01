package com.eprogrammerz.examples.general.collection;

import java.util.HashMap;
import java.util.Map;

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

        Map<Student, String> studentStringMap = new HashMap<>();
        Student studentKey1 = new Student(14,"Student1");
        studentStringMap.put(studentKey1, "Student1");
        studentStringMap.put(studentKey1, "Student2");
        Student studentKey2 = new Student(14,"Student1");
        studentStringMap.put(studentKey2, "student3");
        System.out.println(studentStringMap.size());

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

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o instanceof Student) {
            Student student = (Student) o;
            if(student.getName().equals(this.getName()) && student.getId()== this.getId()) return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 37 *hashCode + id;
        hashCode = 37 * hashCode + name == null ? 0 : name.hashCode();
        return hashCode;
    }
}