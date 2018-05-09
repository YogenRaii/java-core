package com.eprogrammerz.examples.threading.synchronization;

/**
 * @author Yogen Rai
 */
public class Transaction implements Runnable {
    private Customer customer;

    public Transaction(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        final BankAccount account = customer.getBankAccount();
        synchronized (account) {
            account.deposit(100.00);
            account.withdraw(200.00);
        }
    }

    public Customer getCustomer() {
        return customer;
    }
}
