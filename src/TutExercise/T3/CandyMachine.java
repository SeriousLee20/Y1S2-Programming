package TutExercise.T3;

/*
 * Author: Hui Xin
 * 23 Mar 2021
 */

import java.util.Scanner;

public class CandyMachine {

    private int itemCode;
    Scanner in = new Scanner(System.in);

    public void buy() {
        CashRegister cashRegister = new CashRegister();
        Dispenser dispenser = new Dispenser();

        Item item = dispenser.itemName(itemCode);
        dispenser = new Dispenser(item);

        if (dispenser.available(item)) {
            double price = item.getPrice();

            cashRegister = new CashRegister(price);

            System.out.println("Amount to pay: RM " + price);

            while (!cashRegister.checkFullPaid()) {
                System.out.println("Please insert coin.");
                cashRegister.acceptCoin(in.nextInt());
            }

            if (cashRegister.checkEnoughChange()) {
                dispenser.dispense();
                System.out.println("Thanks for purchasing. Remember to collect your item.");
            }
        }

        cashRegister.newDeal();
    }

    public void displayMessage() {
        System.out.println("Welcome to HAHAHA vending machine.");
        System.out.println("Please enter item code");
        System.out.println("1 Candy: RM 1.00    2 Chip: RM 2.00   3 Gum: RM 0.50   4 Cookies: RM 2.00");

        itemCode = in.nextInt();
    }
}
