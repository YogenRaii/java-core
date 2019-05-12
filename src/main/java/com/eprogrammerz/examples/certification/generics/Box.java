package com.eprogrammerz.examples.certification.generics;

public class Box<T> {
    T value;

    Box(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    public static void main(String[] args) {
        Box<String> one = new Box<>("a string");
        Box<Integer> two = new Box<>(123);

        System.out.println(one.getValue());
        System.out.println(two.getValue());
    }
}
