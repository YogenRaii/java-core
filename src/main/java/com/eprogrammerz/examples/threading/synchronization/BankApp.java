package com.eprogrammerz.examples.threading.synchronization;

public class BankApp {
    public static void main(String[] args) {
        final BankAccount account = new BankAccount(12345, 120.00);
        final Customer customer = new Customer(account);

        final Transaction tx1 = new Transaction(customer);
        final Transaction tx2 = new Transaction(customer);

        Thread t1 = new Thread(tx1);
        Thread t2 = new Thread(tx2);
        t1.setName("Tx-1");
        t2.setName("Tx-2");

        t1.start();
        t2.start();
    }
}
