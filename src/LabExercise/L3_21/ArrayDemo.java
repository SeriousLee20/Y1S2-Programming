package LabExercise.L3_21;

/*
 * Author: Hui Xin
 * 21 Mar 2021
 */

public class ArrayDemo {
    public static void main(String[] args) {

        ArrayBag<String> bag1 = new ArrayBag<>();
        ArrayBag<String> bag2 = new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};

        System.out.println("bag1");
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);

        System.out.println("bag2");
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);

        BagInterface<String> bag3 = bag1.union(bag2);
        System.out.println("bag3, test the method union of bag1 and bag2:");
        displayBag(bag3);

        BagInterface<String> bag4 = bag1.intersection(bag2);
        System.out.println("bag4, test the method intersection of bag1 and bag2:");
        displayBag(bag4);

        BagInterface<String> bag5 = bag1.difference(bag2);
        System.out.println("bag5, test the method difference of bag1 and bag2:");
        displayBag(bag5);

        //Q1();
    }

    public static void Q1() {

        ArrayBag<String> bag1 = new ArrayBag<>();

        bag1.add("a");
        bag1.add("b");
        bag1.add("c");

        System.out.println("Bag1");
        bag1.print();

        ArrayBag<String> bag2 = new ArrayBag<>();
        bag2.add("b");
        bag2.add("b");
        bag2.add("d");
        bag2.add("e");
        System.out.println("Bag2");
        bag2.print();
        System.out.println("Bag2 original size: " + bag2.getCurrentSize());

        System.out.println("Union bag");
        BagInterface<String> everything = bag1.union(bag2);
        everything.print();
        System.out.println("Size of combined bag: " + everything.getCurrentSize());

        /*bag2.remove("b");
        System.out.println("Bag2 removed b");
        bag2.print();
        System.out.println("Bag2 latest size: " + bag2.getCurrentSize());
        */

        BagInterface<String> commonItems = bag1.intersection(bag2);
        System.out.println("Common Items in Bag1 and Bag2");
        commonItems.print();

        BagInterface<String> leftOver1 = bag1.difference(bag2);
        System.out.println("Bag1 - Bag2");
        leftOver1.print();

        BagInterface<String> leftOver2 = bag2.difference(bag1);
        System.out.println("Bag2 - Bag1");
        leftOver2.print();
    }

    private static void testAdd(BagInterface<String> aBag, String[] content) {

        System.out.print("Adding ");
        for (String i : content) {
            System.out.print(i + " ");
            aBag.add(i);
        }
        System.out.println();
    }

    private static void displayBag(BagInterface<String> aBag) {

        Object[] arr =  aBag.toArray();

        System.out.println("The bag contains of " + aBag.getCurrentSize() + " string(s), as follows:");

        for (Object i : arr) {
            System.out.print(i + " ");
        }

        System.out.println("\n");
    }
}
