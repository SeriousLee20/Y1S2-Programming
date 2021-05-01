package LabExercise.Stack_Extra;

/*
 * Author: Hui Xin
 * 28 Apr 2021
 */

public class Customer {
    private int arrivalTime;
    private int transactionTime;
    private int customerNumber;

    public Customer(int clock, int transactionTime, int numberOfArrivals) {
        arrivalTime = clock;
        this.transactionTime = transactionTime;
        this.customerNumber = numberOfArrivals;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getTransactionTime() {
        return transactionTime;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
}
