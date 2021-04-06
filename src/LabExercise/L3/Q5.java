package LabExercise.L3;

/*
 * Author: Hui Xin
 * 22 Feb 2021
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        integerArray(arr);

    }

    public static void integerArray(int[] arr) {

        Scanner in = new Scanner(System.in);

        try {

            int i = 0;

            while(true) {
                try {

                    System.out.print("Enter an Integer: ");
                    arr[i] = in.nextInt();
                    i++;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input type");
                    System.out.print("Enter an Integer: ");
                    in.next();
                    // when Scanner throws this exception, the token wasn't passed
                    // Scanner retrieves/skips it using other method
                    arr[i] = in.nextInt();
                    i++;
                }
            }
        } catch (IndexOutOfBoundsException e) {

            System.out.println("The array of integers is:");
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
}
