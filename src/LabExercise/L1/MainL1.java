package LabExercise.L1;

/*
 * Author: Hui Xin
 * 17 Feb 2021
 */

import java.util.Scanner;

public class MainL1 {

    public static void main(String[] args) {
        //Q1();
        //Q2();
        //Q3();

        Q5();
    }

    public static void Q1() {

        Scanner in = new Scanner(System.in);

        System.out.print("Hour: ");
        int hour = in.nextInt();

        in.nextLine();

        System.out.print("\b\b");
        System.out.print(" Minute: ");
        int min = in.nextInt();

        Time x = new Time(hour, min);
        x.validTime();
        x.timeAmPm();
    }

    public static void Q2() {

        int degree = 3;
        double[] coefficientInArray = {4.0, 2.0, -0.5, -20};
        Polynomial a = new Polynomial(degree, coefficientInArray);

        System.out.println("The polynomial is 4.0x^3 +2.0x^2 -0.5x -20.0");
        System.out.println("when x = 2.0");
        System.out.print("4.0x^3 +2.0x^2 - 0.5x -20.0 = ");
        a.calPoly(2.0);

        System.out.println("when x = -3.5");
        System.out.print("4.0x^3 +2.0x^2 - 0.5x -20.0 = ");
        a.calPoly(-3.5);
    }

    public static void Q3() {

        SimpleNetwork a = new SimpleNetwork("Host 1", "10.1.1.1", "255.255.255.224", "UP");
        SimpleNetwork b = new SimpleNetwork("Host 2", "10.1.1.2", "255.255.255.224", "DOWN");
        SimpleNetwork c = new SimpleNetwork("Host 3", "10.1.1.70", "255.255.255.224", "UP");
        SimpleNetwork d = new SimpleNetwork("Host 4", "10.1.1.1", "255.255.255.224", "UP");

        a.ping(b);
        a.ping(c);
        a.ping(d);
    }

    public static void Q5() {

        Scanner in = new Scanner(System.in);

        TextFile t = new TextFile("C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\L1\\TextFile");
        System.out.println("Write to text file");

        /*String a = in.nextLine();
        String b = in.nextLine();
        String c = in.nextLine();

        t.write(a);
        t.write(b);
        t.write(c);

        System.out.println("Read from text file");
        t.read();*/

        BinaryFile bin = new BinaryFile("Binary File.dat");

        System.out.println("Write to binary file");
        bin.write(in.nextLine());
        bin.write(in.nextLine());
        bin.write(in.nextLine());

        System.out.println("Read from binary file");
        bin.read();
    }


}
