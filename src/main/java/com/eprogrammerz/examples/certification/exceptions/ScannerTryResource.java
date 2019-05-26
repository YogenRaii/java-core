package com.eprogrammerz.examples.certification.exceptions;

import java.util.Scanner;

public class ScannerTryResource {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println(sc.nextLine());
            sc.close();
            sc.close();
        }
    }
}
