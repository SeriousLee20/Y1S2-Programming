package PYQ.S2_2017;

import java.util.ArrayList;
import java.util.Scanner;

interface StackInterface<E> {

    ArrayList list = new ArrayList<>();

    // interface cannot has constructor

    int size();

    E peek();

    E pop();

    void push(E element);

    boolean isEmpty();

}

public class GenericStack<E> implements StackInterface<E>{

    public GenericStack() {
        System.out.println("Create a new stack: an empty pile of books");
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E peek() {
        if (size() == 0) {
            return null;
        }

        return (E) list.get(size() - 1);
    }

    @Override
    public E pop() {

        if (size() == 0) {
            return null;
        }
        E element = (E) list.get(size() - 1);
        list.remove(size() - 1);

        return element;
    }

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

class TestGenericStack {

    public static void main(String[] args) {
        GenericStack<String> books = new GenericStack<>();
        Scanner in = new Scanner(System.in);

        System.out.println("isEmpty() returns " + books.isEmpty());

        System.out.println("Push 3 three books to the pile: ");

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter book title " + (i + 1) + ": ");
            books.push(in.nextLine());
        }

        System.out.println("The new books that you added are: " + books + "\n");
        System.out.println("The pile should not be empty:");
        System.out.println("isEmpty returns " + books.isEmpty());
        System.out.println("The pile has " + books.size() + " books.\n");

        System.out.println("Get the top book and remove the top book:\n");
        System.out.println(books.peek() + " is at the top of the pile.");
        System.out.println(books.pop() + " is removed from the pile.\n");

        System.out.println(books.peek() + " is at the top of the pile.");
        System.out.println(books.pop() + " is removed from the pile.\n");

        System.out.println(books.peek() + " is at the top of the pile.");
        System.out.println(books.pop() + " is removed from the pile.\n");

        System.out.println("The pile should be empty:");
        System.out.println("isEmpty() returns " + books.isEmpty());

    }
}
