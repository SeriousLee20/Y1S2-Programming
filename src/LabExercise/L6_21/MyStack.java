package LabExercise.L6_21;

/*
 * Author: Hui Xin
 * 13 Apr 2021
 */

import java.util.ArrayList;

public class MyStack<E> {

    ArrayList<E> list = new ArrayList<>();

    public MyStack() {
    }

    public int getSize() {
        return list.size();
    }

    public E peek() {
        if (getSize() == 0) {
            System.out.println("Empty stack.");
            return null;
        }
        return list.get(getSize() - 1);
    }

    public E pop() {
        if (list.isEmpty()) {
            System.out.println("Empty stack.");
            return null;
        }

        E data = peek();
        //System.out.println(data + " is the last element.");

        list.remove(getSize() - 1);
        return data;
    }

    public void push(E o) {
        list.add(o);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }

    public boolean search(E o) {
        return list.contains(o);
    }

    public E get(int i) {
        return list.get(i);
    }
}
