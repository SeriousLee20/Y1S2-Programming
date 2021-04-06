package LabExercise.L1;

/*
 * Author: Hui Xin
 * 17 Feb 2021
 */

public class Polynomial {
    private int degree;
    private double[] coefficientInArray;

    public Polynomial(int degree, double[] coefficientInArray) {
        this.degree = degree;
        this.coefficientInArray = coefficientInArray;
    }

    public void calPoly(double x) {
        int i = 0;  // index in array
        double result = 0;

        // start counting from highest degree
        for (int d = degree; d > -1; d--) {
            result += coefficientInArray[i] * power(d, x);
            i ++;
        }

        System.out.println(result);
    }

    public double power(int d, double x) {
        double y = 1;
        for (int i = 0; i < d; i++) {
            y *= x;
        }

        return y;
    }
}
