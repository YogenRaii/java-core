package com.eprogrammerz.examples.certification.enums;

public class VisitPark {
    enum AnimalInPark {
        SQURRIL,CHIMPUNK
    }

    public static void main(String[] args) {
        AnimalInPark[] animals = AnimalInPark.values();
        System.out.println(animals[1]);
    }
}
