package TutExercise.T2;

/*
 * Author: Hui Xin
 * 16 Mar 2021
 */

import java.util.ArrayList;
import java.util.Arrays;

public class TesterT2 {
    public static void main(String[] args) {

        Q8();

    }


    public static <T> void allTransportation(ArrayList<? extends T> list1, ArrayList<?> list2) {

    }
    public static void Q7() {
        ArrayList<String> vehicle = new ArrayList<>();
        ArrayList<Object> transportation = new ArrayList<>();

        allTransportation(vehicle, transportation);
    }

    public static void displayList(ArrayList<?> list) {

        for (Object o : list) {

            System.out.println(o);
        }
    }

    public static void Q8() {

        ArrayList<Integer> numOfCars = new ArrayList<>();
        ArrayList<Double> milesPerHour = new ArrayList<>();

        System.out.println("Number of cars");
        numOfCars.add(12);
        numOfCars.add(34);
        displayList(numOfCars);

        System.out.println("miles per hour");
        milesPerHour.add(23.0);
        milesPerHour.add(45.665);
        displayList(milesPerHour);

    }

    public static void Q9() {

    }

    public static void Q10() {

    }
}
