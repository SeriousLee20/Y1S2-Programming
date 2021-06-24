package LabTest3;

/*
 * Author: Hui Xin
 * 03 Jun 2021
 */

public class Q2 {

    public static void main(String[] args) {

        System.out.println("Mesh Topology");

        // test case 4
        print(4);

        // test case 7
        print(7);
    }

    public static int numOfConnections(int numOfSwitch) {


        if (numOfSwitch > 0) {
            // formula: numOfSwitch * (numOfSwitch - 1)/2
            // expand the formula: (N−1)+(N−2)+(N−3)+⋯+(N−(N−1)); N is numOfSwitch

            return numOfSwitch - 1 + numOfConnections(numOfSwitch - 1);

        } else {

            // return 0 if num of numOfSwitch is 0
            return 0;
        }
    }

    // method to print and accept number of switches to calculate
    public static void print(int numOfSwitch) {

        // Line 1
        System.out.println("There are " + numOfSwitch + " switches in the campus.");

        // Line 2
        System.out.println("The total number of connections required is " + numOfConnections(numOfSwitch));
    }
}
