package LabExercise.L1_21;

/*
 * Author: Hui Xin
 * 12 Mar 2021
 */

import java.text.DecimalFormat;
import java.util.Date;

public class Transaction {

    private Date date;
    private char type;
    private double amount;
    private double balance;
    private String description;
    private DecimalFormat df = new DecimalFormat("$,###.##");

    public Transaction(char typeOfTransaction, double amount, double balance, String description) {
        this.type = typeOfTransaction;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
        date = new Date();
    }

    public String toString() {
        String dateString = String.format("%td/%<tm/%<tY", date);
        return String.format("%7s  %8s %12s %13s %15s \n%s %4s %14s %13s %16s",
                "Date", "Type", "Amount", "Balance", "Description",
                dateString, type, df.format(amount), df.format(balance), description);

    }
}
