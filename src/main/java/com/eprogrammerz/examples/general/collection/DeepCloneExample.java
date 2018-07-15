package com.eprogrammerz.examples.general.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@Slf4j
public class DeepCloneExample {

    @Test
    public void testDeepClone() {
        Dog dog1 = new Dog("Puppy", 4);
        Dog dog2 = new Dog("Tom", 5);
        Dog dog3 = new Dog("Hen", 3);
        Dog dog4 = new Dog("Jen", 7);
        List<Dog> dogs = new ArrayList<>();
        dogs.add(dog1);
        dogs.add(dog2);
        dogs.add(dog3);
        dogs.add(dog4);

        //clone with java 8
        List<Dog> clonedList = dogs.stream().map(Dog::new).collect(Collectors.toList());

        assertThat(dogs, is(clonedList));

        // modify original list
        dogs.remove(0);
        // make sure cloned list remains unaffected
        assertEquals(3, dogs.size());
        assertEquals(4, clonedList.size());

        // modify cloned list
        clonedList.add(new Dog("New", 3));
        // make sure original list remains unaffected
        assertEquals(3, dogs.size());
        assertEquals(5, clonedList.size());

        // modify element in dogs
        dog2.setName("Very New Name");

        assertEquals("Very New Name", dogs.get(0).getName());
        assertEquals("Tom", clonedList.get(1).getName());

        //with normal
        //copy all the items in the list to new list
        //but, the items in the collection need to implement Cloneable interface
        //meaning Object on list must be cloneable
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    //copy constructor to create the copy of the Dog object
    public Dog(Dog dog) {
        this.name = dog.name;
        this.age = dog.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("(%s, %d)", name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Dog)) {
            return false;
        }

        Dog dog = (Dog) obj;

        return this.name.equals(dog.getName()) && this.age == dog.getAge();
    }
}