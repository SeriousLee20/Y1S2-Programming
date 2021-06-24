package LabTest3;

/*
 * Author: Hui Xin
 * 03 Jun 2021
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {

        // array for integers
        int[] num = new int[5];

        // call recursive method to input integer
        intArray(num);

    }

    public static void intArray(int[] num) {

        Scanner in = new Scanner(System.in);

        try {

            int i = 0;

            while(true) {
                try {

                    System.out.print("Enter an Integer: ");
                    num[i] = in.nextInt();  // input integer
                    i++;    // increase counter if correct input

                    // throw exception if wrong input type
                } catch (InputMismatchException e) {

                    System.out.println("Invalid input type");
                    System.out.print("Enter an Integer: ");
                    in.next();      // flush the scanner

                    num[i] = in.nextInt();  // input new integer
                    i++;        // increase counter
                }
            }

            // array is full, throw exception
        } catch (IndexOutOfBoundsException e) {

            System.out.println("The array of integers is:");

            // print the numbers
            for (int i : num) {
                System.out.print(i + " ");
            }
        }
    }
}
