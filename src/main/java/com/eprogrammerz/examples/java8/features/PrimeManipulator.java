package com.eprogrammerz.examples.java8.features;

/**
 * Created by 542596 on 11/10/2016.
 */
public class PrimeManipulator {
    public static void main(String[] args) {
        PrimeManipulator primeManipulator = new PrimeManipulator();
        primeManipulator.printPrimes(1,50);  //print prime between 1 and 50
    }
    public void printPrimes(int start,int end){
        for(int i = start; i <= end; i++ ){
            if(isPrime(i)){  //if number is prime, print it
                System.out.print(i+ " ");
            }
        }
    }

    private boolean isPrime(int n) {
        if(n <= 1){   //if number is 1 or less, it is not prime
            return  false;
        }

        //if number is divisible by any number except 1 and itself, then it is not prime
        for(int i = 2; i <= (n/2); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
