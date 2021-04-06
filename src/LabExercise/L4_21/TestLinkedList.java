package LabExercise.L4_21;

/*
 * Author: Hui Xin
 * 03 Apr 2021
 */

public class TestLinkedList {
    public static void main(String[] args) {

        MyLinkedList<Character> list = new MyLinkedList<>();

        list.add('a');
        list.add('b');
        list.add('c');
        list.add('d');
        list.add('e');

        System.out.println("Original list.");
        list.print();

        System.out.println("Reversed list");
        list.reverse();
        list.print();

        int size = list.getSize();
        System.out.println("Size of list: " + size);

        System.out.println("First value: " + list.getFirst());
        System.out.println("Last value: " + list.getLast());

        if (size % 2 == 0) {
            list.remove(size / 2 - 1);
        } else {
            list.remove(size / 2 );
        }

        System.out.println("Removed middle value: ");
        list.print();

        System.out.println("The list contains 'c': " + list.contains('c'));

        list.set(0, 'h');
        list.set(1, 'e');
        list.set(2, 'p');
        list.print();
        list.set(3, 'l');
        list.add('o');
        System.out.println("Replaced list.");
        list.print();

        System.out.println("Middle value: " + list.getMiddleValue());

    }
}
