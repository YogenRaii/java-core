package com.eprogrammerz.examples.threading.deadlock;

/**
 * @author Yogen Rai
 *
 *
 * Deadlock occurs when multiple threads need the same locks but obtain them in different order.
 * A Java multithreaded program may suffer from the deadlock condition because the synchronized keyword
 * causes the executing thread to block while waiting for the lock, or monitor, associated with the specified object.
 */
public class DeadLockExample {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        Calculator c2 = new Calculator();

        Thread t1 = new Thread(() -> {
            synchronized (c1) {
                System.out.println(Thread.currentThread().getName() + " holding lock c1 . . .");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting lock c2 . . .");

                synchronized (c2) {
                    System.out.println(Thread.currentThread().getName() + " holding lock c2 . . .");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (c2) {
                System.out.println(Thread.currentThread().getName() + " holding lock c2 . . .");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting lock c1 . . .");

                synchronized (c1) {
                    System.out.println(Thread.currentThread().getName() + " holding lock c1 . . .");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
