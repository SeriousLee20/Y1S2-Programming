package LabExercise.L7_21;

/*
 * Author: Hui Xin
 * 23 Jun 2021
 */

import java.util.ArrayList;

public class ArrayListQueue<E> {
    private ArrayList<E> list = new ArrayList<>();
    private int size;

    public ArrayListQueue() {
    }

    public void enqueue(E e) {
        list.add(e);
        size++;
    }

    public E dequeue() {
        if (size == 0) {
            System.out.println("Empty queue.");
            return null;
        }

        E toRemove = list.get(0);
        list.remove(0);
        size--;
        return toRemove;
    }

    public E getElement(int i) {
        if (i < 0 || i >= size) {
            System.out.println("Invalid index.");
            return null;
        }

        return list.get(i);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list.get(i)).append(" ");
        }
        return s.toString();
    }
}
