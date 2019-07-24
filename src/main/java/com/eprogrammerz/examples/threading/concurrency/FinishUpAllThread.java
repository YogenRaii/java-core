package com.eprogrammerz.examples.threading.concurrency;

import java.util.concurrent.*;

public class FinishUpAllThread {
    public static void testExecutorService() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            es.execute(new Thread(() -> {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread -> " + Thread.currentThread().getName());
            }));
        }

        es.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("Done executing all threads . . .");
        if (!es.isShutdown()) {
            System.out.println("Shutting down executor . . .");
            es.shutdown(); // graceful shutdown of the service
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        testExecutorService();
        testWithJoin();
    }

    public static void testWithJoin() throws InterruptedException {
        Runnable r = () -> {
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread -> " + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // join all threads to the main thread i.e. before joining t2 to main thread, t1 should
        // have been joined
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Done with all threads!");
    }
}
