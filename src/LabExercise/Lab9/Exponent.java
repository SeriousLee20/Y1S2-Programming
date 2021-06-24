package LabExercise.Lab9;

/*
 * Author: Hui Xin
 * 27 May 2021
 */

public class Exponent {
    public static void main(String[] args) {
        System.out.println(exponent(2, 3));
    }

    public static long exponent(int x, int n) {

        if (n == 1) {
            return x;
        }
        else
            return x * exponent(x, n - 1);
    }
}
