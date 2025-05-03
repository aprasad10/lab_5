package com.example.lab_5;
import java.util.Calendar;
/**
 * Bank Account Class Partner Lab 5
 * @author Aagna Modi (interface design, BankAccount)
 * @since 05/02/2025
 */
public class BankAccount { ;
    static int nextNumber = 1;
    private int accountNumber;
    private double accountBalance;
    private StringBuilder statement;
    /**
     * Instantiates the necessary variables.
     */
    public BankAccount() {
        this.accountBalance = 0;
        this.statement = new StringBuilder();
        this.accountNumber = nextNumber++;
    }
    /**
     * This public method returns the account number.
     * @return accountNumber
     */
    public int getAccountNumber() {
        return this.accountNumber;
    }
    /**
     * This method initializes the bankAccount balance with the inputted value from the user
     * @param i is the value given to the account balance.
     */
    public BankAccount(double i) {
        this.accountBalance = i;
        this.statement = new StringBuilder();
    }
    /**
     * Method to deposit a specified amount into bank account, recording it in the
     transaction statement
     * @param amount : amount to be deposited into the account.
     */
    public void deposit(double amount) throws Exception {
        if (amount < 0)
            throw new Exception("Amount cannot be negative");
        this.accountBalance += amount;
        statement.append("Deposited: " + amount + " on " +
                Calendar.getInstance().getTime() + "\n");
    }
    /**
     * Method to withdraw a specified amount into bank account, recording it in the
     transaction statement
     * @param amount : amount to be withdrawn from the balance.
     */
    public void withdraw(double amount) throws Exception {
        if (amount < 0)
            throw new Exception("Amount cannot be negative");
        if (amount > this.accountBalance)
            throw new Exception("Not enough funds");
        this.accountBalance -= amount;
        statement.append("Withdrawn: " + amount + " on " +
                Calendar.getInstance().getTime() + "\n");
    }
    /**
     * Description : Method to get the balance from the bank account.
     *
     * @return : current bank balance.
     */
    public double getBalance() {
        return this.accountBalance;
    }
    /**
     * Description : Method that returns all the transaction history of the
     associated account.
     */
    public String getStatement() {
        return ("Transaction History: \n" +
                "------------------------------ \n" +
                this.statement +
                "The total balance on this account is: " + this.accountBalance);
    }
}