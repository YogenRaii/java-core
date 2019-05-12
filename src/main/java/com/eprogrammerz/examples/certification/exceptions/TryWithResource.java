package com.eprogrammerz.examples.certification.exceptions;

import java.util.Scanner;

public class TryWithResource {
    class MyException extends RuntimeException { }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner("rain")/*; String line = "";*/) { // since string is not auto-closable or closable, this causes compile error
            if (sc.nextLine().equals("rain")) {
//                throw new MyException();
            }
        } finally {
//            sc.close(); // sc is not available on finally block
        }
    }
}
