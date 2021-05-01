package LabExercise.Stack_Extra;

/*
 * Author: Hui Xin
 * 28 Apr 2021
 */

import java.util.Queue;

import LabExercise.L7_21.MyQueue;

public class WaitLine {

    private MyQueue <Customer> line;
    private int numberOfArrivals;
    private int numberServed;
    private int totalTimeWaited;


    public WaitLine() {

        line = new MyQueue<>();
        reset();

    }
    public void simulate(int duration, double arrivalProbability, int maxTransactionTime) {
        int transactionTimeLeft = 0;

        // each time clock increases, one minute past
        // max time is the durations set initially
        for (int clock = 0; clock < duration; clock++) {


            // random arrival probability
            if (Math.random() < arrivalProbability) {

                numberOfArrivals++;

                // random transaction time
                int transactionTime = (int) (Math.random() * maxTransactionTime + 1);

                // Create new customer
                Customer nextArrival = new Customer(clock, transactionTime, numberOfArrivals);

                // Enqueue new customer to the line
                line.enqueue(nextArrival);

                System.out.println("Customer: " + numberOfArrivals +
                        " enters line at time " + clock +
                        ". \nTransaction time is " + transactionTime);
            } //end if


            // not finish serving a customer
            if (transactionTimeLeft > 0) {
                transactionTimeLeft--;

            // after a customer ended transaction
            } else if (!line.isEmpty()) {

                // dequeue customer from the line
                Customer nextCustomer = line.dequeue();

                // Each loop decreases 1 min transaction time
                transactionTimeLeft = nextCustomer.getTransactionTime() - 1;

                // how long the current customer has waited
                int timeWaited = clock - nextCustomer.getArrivalTime();

                // total time of waiting for all customers
                totalTimeWaited = totalTimeWaited + timeWaited;

                numberServed++;

                System.out.println("Customer " + nextCustomer.getCustomerNumber() +
                        " begins service at time " + clock +
                        ". Time waited is " + timeWaited);
            }
        }
    }

    public void displayResult() {

        System.out.println();
        System.out.println("Number served = " + numberServed);
        System.out.println("Total time waited = " + totalTimeWaited);
        double averageTimeWaited = ((double) totalTimeWaited / numberServed);
        System.out.println("Average time waited = " + averageTimeWaited);

        int leftInLine = numberOfArrivals - numberServed;
        System.out.println("Number left in line = " + leftInLine);
    }

    public void reset() {

        line.clear();
        numberOfArrivals = 0;
        numberServed = 0;
        totalTimeWaited = 0;
    }


    public static void main(String[] args) {
        WaitLine customerLine = new WaitLine();
        customerLine.simulate(20, 0.5, 5);
        customerLine.displayResult();
    }
}
