package com.eprogrammerz.examples.general.inheritance.exception;

/**
 * Created by 542596 on 2/23/2017.
 */
public class Child extends Parent {
    @Override
    public void parentMethod() {
        System.out.println("Parent Overriden...");
    }

    public final void finalMethod() {
        Thread thread= new Thread();
    }
}
