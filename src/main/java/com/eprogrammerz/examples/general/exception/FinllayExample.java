package com.eprogrammerz.examples.general.exception;

/**
 * Created by 542596 on 2/23/2017.
 */
public class FinllayExample {
    public static void main(String[] args) {
        System.out.println("Before call...");
        exceptionThrowingMethod();
        System.out.println("After thrown...");
        /*
        output will be:
        Before call...
        java.lang.ArithmeticException: / by zero
        finally
        After thrown...
        */
    }

    public static void exceptionThrowingMethod() {
        try {
            int ans = 1/0;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("finally");
        }
    }

    public void nonStaticMethod() {
        main(new String[]{});
    }
}
