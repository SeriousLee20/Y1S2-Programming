package TutExercise.T1;

/*
 * Author: Hui Xin
 * 11 Mar 2021
 */

public class T1Tester {

    public static void main(String[] args) {

        Q1();

    }

    public static void Q1() {
        Telephone[] telephones = {new Telephone("03", 79676300),
                new Telephone("03", 79676301),
                new Telephone("03", 79676302),
                new Telephone("03", 79676303),
                new Telephone("03", 79676304)};

        for (Telephone i : telephones) {
            System.out.println(i.makeFullNumber());
        }
    }
}
