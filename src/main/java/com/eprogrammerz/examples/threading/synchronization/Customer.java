package com.eprogrammerz.examples.threading.synchronization;

/**
 * @author Yogen Rai
 */
public class Customer {
    private BankAccount bankAccount;

    public Customer(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
