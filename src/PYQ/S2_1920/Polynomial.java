package PYQ.S2_1920;

/*
 * Author: Hui Xin
 * 24 Jun 2021
 */

public class Polynomial implements PolynomialInterface {

    private int[] coeff;
    private int deg;

    public Polynomial() {
        deg = 0;
    }

    public Polynomial(int[] coeff) {
        deg = coeff.length - 1;
        this.coeff = coeff.clone();
    }

    @Override
    public int[] getCoeff() {
        return coeff;
    }

    @Override
    public int getDeg() {
        return deg;
    }

    @Override
    public void add(Polynomial first, Polynomial second) {

        int[] eqn1 = first.coeff.clone();
        int[] eqn2 = second.coeff.clone();

        int deg1 = first.deg;
        int deg2 = second.deg;

        if (deg1 > deg2) {
            this.coeff = eqn1.clone();

            for (int i = deg1, j = deg2; i >= 0 && j >= 0; i--, j--) {
                coeff[i] += eqn2[j];
            }

        } else {
            this.coeff = eqn2.clone();

            for (int i = deg1, j = deg2; i >= 0 && j >= 0; i--, j--) {
                coeff[i] += eqn1[j];
            }
        }

        deg = coeff.length - 1;
    }

    @Override
    public int getValue(int x) {

        int ans = 0;

        int index = 0;

        for (int i = deg; i >= 0; i--) {
            ans += Math.pow(x, i) * coeff[index];
            index++;
        }

        return ans;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int degTemp = deg;

        for (int i = 0; i < deg + 1; i++) {

            if (coeff[i] == 0) {
                continue;
            }

            if (coeff[i] > 0) {
                if (i == 0) {
                    s.append(coeff[i]);
                } else {
                    s.append("+").append(coeff[i]);
                }
            } else {
                s.append(coeff[i]);
            }

            if (degTemp == 1) {
                s.append("x");
                degTemp--;
            } else if (degTemp == 0) {

            } else {
                s.append("x^").append(degTemp);
                degTemp--;
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        int x = 2;
        int[] co1 = {5, 0, -3, 8, -4};
        int[] co2 = {-2, -4, 0, 5};
        Polynomial p1 = new Polynomial(co1);
        Polynomial p2 = new Polynomial(co2);

        Polynomial p3 = new Polynomial();

        p3.add(p1, p2);

        System.out.println(p1 + " + " + p2 + " = " + p3);
        System.out.println("When x = " + x + " ; " + p3 + " = " + p3.getValue(x));

    }
}
