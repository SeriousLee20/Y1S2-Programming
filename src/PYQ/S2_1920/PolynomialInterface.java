package PYQ.S2_1920;

/*
 * Author: Hui Xin
 * 24 Jun 2021
 */

public interface PolynomialInterface {

    // constructor not allowed in interface

    int[] getCoeff();

    int getDeg();

    void add(Polynomial first, Polynomial second);

    int getValue(int x);
}
