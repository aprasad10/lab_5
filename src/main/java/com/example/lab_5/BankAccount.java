package com.example.lab_5;
import java.util.Calendar;

public class BankAccount { ;
    static int nextNumber = 1;
    private int accountNumber;
    private double accountBalance;
    private StringBuilder statement;

    public BankAccount() {
        this.accountBalance = 0;
        this.statement = new StringBuilder();
        this.accountNumber = nextNumber++;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public BankAccount(double i) {
        this.accountBalance = i;
        this.statement = new StringBuilder();
    }

    public void deposit(double amount) throws Exception {
        if (amount < 0)
            throw new Exception("Amount cannot be negative");
        this.accountBalance += amount;
        statement.append("Deposited: " + amount + " on " +
                Calendar.getInstance().getTime() + "\n");
    }

    public void withdraw(double amount) throws Exception {
        if (amount < 0)
            throw new Exception("Amount cannot be negative");
        if (amount > this.accountBalance)
            throw new Exception("Not enough funds");
        this.accountBalance -= amount;
        statement.append("Withdrawn: " + amount + " on " +
                Calendar.getInstance().getTime() + "\n");
    }

    public double getBalance() {
        return this.accountBalance;
    }

    public String getStatement() {
        return ("Transaction History: \n" +
                "------------------------------ \n" +
                this.statement +
                "The total balance on this account is: " + this.accountBalance);
    }
}