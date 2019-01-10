package com.eprogrammerz.examples.threading.locking;

/**
 * @author Yogen Rai
 */
public class CalculatorApp {
    public static void main(String[] args) {

        /*
        Two threads calling the method on same instances acquire same monitors, so one of them gets blocked.
         */
        /*Calculator calculator = new Calculator();
        Thread t1 = new Thread(() -> {
            int sum = 0;
            try {
                sum = calculator.add(2,3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " --> Sum: " + sum);
        });

        Thread t2 = new Thread(() -> {
            int sum = 0;
            try {
                sum = calculator.add(4,5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " --> Sum: " + sum);
        });

        t1.start();
        t2.start();*/


        /*
        Two threads calling the method on different instances acquire different monitors, so none of them gets blocked.
         */
        Calculator calculator1 = new Calculator();
        Calculator calculator2 = new Calculator();
        Thread t1 = new Thread(() -> {
            int sum = 0;
            try {
                sum = calculator1.add(2,3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " --> Sum: " + sum);
        });

        Thread t2 = new Thread(() -> {
            int sum = 0;
            try {
                sum = calculator2.add(4,5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " --> Sum: " + sum);
        });

        t1.start();
        t2.start();
    }
}
