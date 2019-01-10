package com.eprogrammerz.examples.threading.locking;

/**
 * @author Yogen Rai
 *
 * If the method is an instance method, then the instance acts as a monitor for the method.
 * Two threads calling the method on different instances acquire different monitors, so none of them gets blocked.
 *
 * If the method is static, then the monitor is the Class object.
 * For both threads, the monitor is the same, so one of them will probably block and wait for another to exit the synchronized method.
 */
public class Calculator {
    public synchronized int add(int a, int b) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " is about to sleep . . .");
        Thread.sleep(10000);
        return a + b;
    }
}
