package LabExercise.L1_21;

/*
 * Author: Hui Xin
 * 11 Mar 2021
 */

import java.util.Date;

public class Account {

    private int id;
    private static double balance;

    // assume all accounts have the same interest rate
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        dateCreated = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return annualInterestRate/12;
    }

    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public String toString() {
        return String.format("""
                        Account balance: RM %.2f\s
                        Monthly Interest: RM %.2f\s
                        Date Created the Account: %3$ta, %3$td %3$tB %3$tY""",
                balance, getMonthlyInterest(), dateCreated);
    }

    // tester
    public static void main(String[] args) {
        Account a = new Account(1122, 20000);
        a.setAnnualInterestRate(4.5);

        a.withdraw(2500);
        a.deposit(3000);

        System.out.println(a);

    }
}
