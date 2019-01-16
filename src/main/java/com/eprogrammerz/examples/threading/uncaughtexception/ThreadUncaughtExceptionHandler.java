package com.eprogrammerz.examples.threading.uncaughtexception;

/**
 * @author Yogen Rai
 *
 * How can you catch an exception thrown by another thread in Java?
 *
 * This can be done using Thread.UncaughtExceptionHandler.
 */
public class ThreadUncaughtExceptionHandler {
    public static void main(String[] args) {
        Thread.UncaughtExceptionHandler handler = (t, e) -> System.out.println("Caught Exception: " + e);

        Thread otherThread = new Thread(() -> {
            System.out.println("Putting thread into sleep state...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Now Throwing Exception . . .");
            throw new RuntimeException("This exception is thrown from " + Thread.currentThread().getName());
        });

        otherThread.setUncaughtExceptionHandler(handler);

        otherThread.start();
    }
}
