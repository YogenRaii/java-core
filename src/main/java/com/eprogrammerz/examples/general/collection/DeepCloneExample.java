package com.eprogrammerz.examples.general.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeepCloneExample {
	public static void main(String[] args) {
		Dog dog1 = new Dog("Puppy", 4);
		Dog dog2 = new Dog("Tom", 5);
		Dog dog3 = new Dog("Hen", 3);
		Dog dog4 = new Dog("Jen", 7);
		List<Dog> dogs = new ArrayList<>();
		dogs.add(dog1);
		dogs.add(dog2);
		dogs.add(dog3);
		dogs.add(dog4);
		log.info(dogs.toString());
		
		//clone with java 8
		List<Dog> clonedList = dogs.stream().map(Dog::new).collect(Collectors.toList());
		log.info(clonedList.toString());
		
		clonedList.add(new Dog("New", 3));
		dogs.remove(0);
		
		log.info(dogs.toString());
		log.info(clonedList.toString());
		
		dog2.setName("Very New Name");
		log.info(dogs.toString());
		log.info(clonedList.toString());		
		
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
}