package com.eprogrammerz.examples.java8.features;

/**
 * Created by 542596 on 11/11/2016.
 */
public class PrimeManipulator2 {
    public static void main(String[] args) {
        int n = 3; //input value; you are reading using Scanner

        int flag = 1; //number is prime; suppose

        for(int i = 2; i <= (n/2); i++){
            if(n % i == 0){
                flag = 0; // number is not prime
                break;
            }
        }
        if(flag == 0){
            System.out.println(n + " is not prime number.");
        }else{
            System.out.println(n +" is prime number.");
        }
    }
}
