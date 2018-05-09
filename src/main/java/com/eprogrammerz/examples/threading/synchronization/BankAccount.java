package com.eprogrammerz.examples.threading.synchronization;

/**
 * @author Yogen Rai
 */
public class BankAccount {
    private Double balance;
    private Integer accountNumber;

    public BankAccount( Integer accountNumber, Double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void deposit(Double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " depositing the amount: " + amount + ", updated balance: " + balance);
    }

    public Double withdraw(Double amount) {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw " + amount + " from the account " + accountNumber);
        if (balance < amount) {
            System.out.println("OOPS, NO BALANCE LEFT TO WITHDRAW FOR " + Thread.currentThread().getName());
            return 0.0;
        }
        balance = balance - amount;
        System.out.println(Thread.currentThread().getName() + " successfully withdraw the amount, remaining balance: " + balance);
        return amount;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }
}
