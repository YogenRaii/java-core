package com.eprogrammerz.examples.certification.core;

import java.io.Console;

/**
 * NullPointerException might be thrown if no Console is associated with JVM
 */
public class ConsoleTest {
    public static void main(String[] args) {
        Console console = System.console(); // return Console if JVM has been assigned one

        String line;

        if ((line = console.readLine()) != null) {
            System.out.println(line);
        }
    }
}
