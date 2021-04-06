package LabExercise.L5_21;

/*
 * Author: Hui Xin
 * 04 Apr 2021
 */

import java.util.Scanner;

public class TestList {
    public static void main(String[] args) {

        //Q1();
        Q2();

    }

    public static void Q1() {
        SList<String> list1 = new SList<>();
        list1.appendEnd("Linked list,");
        list1.appendEnd("is,");
        list1.appendEnd("easy.");

        System.out.println("Original list.");
        list1.display();

        System.out.println(list1.removeInitial() + "is removed");
        list1.display();

        boolean contain = list1.contains("difficult");
        System.out.println("list1 contains \"difficult\": " + contain);

        list1.clear();
        list1.display();
    }

    public static void Q2() {
        Scanner in = new Scanner(System.in);

        StudentList<String> studName = new StudentList<>();

       /* studName.add("Rahmat");
        studName.add("Alice");
        studName.add("Fatymah");
        studName.add("Yoke Ling");
        studName.add("Maniam");
        studName.add("Abu");*/

        String name = "";

        System.out.println("Enter your student name list. Enter 'n' to end.....");

        do {
            name = in.nextLine();
            if (name.equals("n")) {
                break;
            }
            studName.add(name);
        } while (true);

        System.out.println("\nYou have entered the following students' name :");
        studName.printList();

        System.out.println("\nThe number of students entered is : " + studName.getSize());

        System.out.println("\nAll the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
        char rename = in.next().charAt(0);

        in.nextLine();

        if (rename == 'r') {
            System.out.println("\nEnter the existing student name that u want to rename :");
            String nameToReplace = in.nextLine();

            System.out.println("\nEnter the new name :");
            String newName = in.nextLine();

            studName.replace(nameToReplace, newName);

            System.out.println("\nThe new student list is :");
            studName.printList();
        }

        System.out.println("\nDo you want to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
        char removeName = in.next().charAt(0);

        in.nextLine();

        if (removeName == 'y') {
            System.out.println("\nEnter a student name to remove :");
            String nameToRemove = in.nextLine();

            studName.removeElement(nameToRemove);

            System.out.println("\nThe number of student updated is :" + studName.getSize());

            System.out.println("The updated students list is :");
            studName.printList();
        }

        System.out.println("\nAll student data captured complete. Thank you!");

    }
}
