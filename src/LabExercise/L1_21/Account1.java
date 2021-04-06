package LabExercise.L1_21;

/*
 * Author: Hui Xin
 * 12 Mar 2021
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class Account1 extends Account{
    private String name;
    private int id;
    private double balance;

    // assume all accounts have the same interest rate
    private double annualInterestRate;
    private Date dateCreated = new Date();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private Transaction t;

    public Account1(String name, int id, double balance) {
        super(id, balance);
        t = new Transaction('D', balance, balance, "Initial deposit");
        transactions.add(t);

        this.name = name;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            t = new Transaction('W', amount, balance, "Withdrawal");
            transactions.add(t);
            return true;
        }
        System.out.println("Not enough balance.");
        return false;
    }

    public void deposit(double amount) {
        balance += amount;
        t = new Transaction('D', amount, balance, "Deposit");
        transactions.add(t);
    }

    public void printInfo() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.printf("""
                        Account holder: %s\s
                        Monthly Interest rate: %s\s
                        Account balance: RM %.2f\s""",
                name, df.format(getMonthlyInterestRate()), balance);

        System.out.println("\n");
        for(Transaction i : transactions)
            System.out.println(i);
    }

    public static void main(String[] args) {

        Account1 a1 = new Account1("George", 1122, 1000);
        a1.setAnnualInterestRate(1.5);

        a1.deposit(30);
        a1.deposit(40);
        a1.deposit(50);
        a1.withdraw(5);
        a1.withdraw(4);
        a1.withdraw(2);

        a1.printInfo();
    }
}
