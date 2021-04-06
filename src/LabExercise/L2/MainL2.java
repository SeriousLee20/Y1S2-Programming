package LabExercise.L2;

/*
 * Author: Hui Xin
 * 20 Feb 2021
 */

public class MainL2 {
    public static void main(String[] args) {
        Q1();

    }

    public static void Q1() {

        Q1 all = new Q1();

        System.out.println("Generate 20 non-duplicate integer within 0-100");

        Q1.linkedList list = all.new linkedList(20);

        System.out.println();

        Q1.Array array = all.new Array(20);

    }
}
