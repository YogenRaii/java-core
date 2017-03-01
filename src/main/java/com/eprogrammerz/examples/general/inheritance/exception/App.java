package com.eprogrammerz.examples.general.inheritance.exception;

import java.io.IOException;

/**
 * Created by 542596 on 2/23/2017.
 */
public class App {
    public static void main(String[] args) {
        Parent parent = new Child();
        try {
            parent.parentMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
