package LabExercise.L7_21;

/*
 * Author: Hui Xin
 * 19 Apr 2021
 */

import java.util.Arrays;
import java.util.Scanner;

public class TesterQueue {
    public static void main(String[] args) {
        //Q1();
        //palindrome("madam");

        //shareGainLoss();
        testArrayQueue();
    }

    public static void testArrayQueue() {
        ArrayQueue<Integer> test = new ArrayQueue<>(5);

        test.enqueue(2);
        test.enqueue(7);
        test.enqueue(1);
        test.enqueue(2);
        test.enqueue(0);
        test.enqueue(9);
        System.out.println(test);

        test.dequeue();
        System.out.println(test);
        System.out.println(test.getElement(4));
        //System.out.println(test.getElement(9));

    }

    public static void Q1() {
        String[] fruit = {"Durian", "Bluberry"};

        MyQueue<String> fruitQ = new MyQueue<>(fruit);

        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");

        System.out.println(fruitQ);

        System.out.println("First element: " + fruitQ.peek());

        System.out.println("Queue size: " + fruitQ.size());

        System.out.println("First element is removed: " + fruitQ.dequeue());

        System.out.println("Element at index 2: " + fruitQ.getElement(2));

        System.out.println("Queue consists of Cherry: " + fruitQ.contains("Cherry"));

        System.out.println("Queue consists of Durian: " + fruitQ.contains("Durian"));

        System.out.println("Queue is empty: " + fruitQ.isEmpty());
    }

    public static void palindrome(String str) {

        MyQueue<String> reverseLetter = new MyQueue<>();

        String[] letter = str.split("");

        System.out.println(Arrays.toString(letter));

        for (int i = letter.length - 1; i > -1; i --) {
            reverseLetter.enqueue(letter[i]);
        }

        System.out.println(reverseLetter);

        for (int i = 0; i < letter.length; i++) {
            if (!reverseLetter.getElement(i).equals(letter[i])) {
                System.out.println(str + " is not a palindrome.");
                return;
            }
        }

        System.out.println(str + " is a palindrome.");
    }

    public static void shareGainLoss() {
        Scanner in = new Scanner(System.in);
        MyQueue<Integer> share = new MyQueue<>();
        MyQueue<Integer> price = new MyQueue<>();
        int shareUnit;
        int sharePrice;
        String[] deals;
        int totalBuyPrice = 0;
        int totalSellPrice = 0;
        int totalGainLoss = 0;

        do {
            System.out.print("Enter your query (In format 'Buy / Sell x shares at $y each: ");
            String deal = in.nextLine();
            deals = deal.split(" ");

            sharePrice = Integer.parseInt(deals[4].replace("$", ""));
            shareUnit = Integer.parseInt(deals[1]);

            if (deals[0].equals("Buy")) {
                System.out.println("Buying now...");
                share.enqueue(shareUnit);
                price.enqueue(sharePrice);

            } else {
                System.out.println("Selling the shares now...");
                boolean canSell = true;

                while (shareUnit > 0 && canSell) {

                    if (!share.isEmpty()) {

                        int availableShare = share.peek();

                        if (shareUnit > availableShare) {
                            share.dequeue();

                            int buyPrice = price.peek();
                            totalBuyPrice += buyPrice * availableShare;
                            totalSellPrice += sharePrice * availableShare;

                            price.dequeue();
                            shareUnit -= availableShare;

                        } else {

                            share.enqueue(share.dequeue() - shareUnit);

                            int buyPrice = price.peek();

                            totalBuyPrice += buyPrice * shareUnit;
                            totalSellPrice += sharePrice * shareUnit;

                            shareUnit = 0;

                        }

                        totalGainLoss = totalSellPrice - totalBuyPrice;
                        System.out.println("Total Capital Gain / Loss: " + totalGainLoss);
                    } else {
                        canSell = false;
                        System.out.println("No shares to sell!");
                    }
                }
            }
            System.out.println("Queue for Share: " + share);
            System.out.println("Queue for Price: " + price);
        } while (!share.isEmpty());

        System.out.println("Final Capital Gain / Loss: " + totalGainLoss);

    }
}
