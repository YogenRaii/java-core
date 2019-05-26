package com.eprogrammerz.examples.certification.exceptions;

class MyResource implements AutoCloseable {

    @Override
    public void close() {
        System.out.println("Closing...");
    }
}
public class CustomCloseable {
    public static void main(String[] args) {
        try (AutoCloseable resource = new MyResource()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
