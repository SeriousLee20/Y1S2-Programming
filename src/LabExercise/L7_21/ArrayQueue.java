package LabExercise.L7_21;

/*
 * Author: Hui Xin
 * 23 Jun 2021
 */

public class ArrayQueue<E> {
    private E[] list;
    private int size;

    public ArrayQueue() {
        list = (E[]) new Object[20];
    }

    public ArrayQueue(int initial) {
        list = (E[]) new Object[initial];
    }

    public void enqueue(E e) {

        // if the array is full
        if (size == list.length) {
            resize();
        }

        //new element is added to the list
        // last empty index = occupied
        list[size] = e;
        size++;
    }

    public E dequeue() {
        if (size == 0) {
            System.out.println("Empty queue.");
            return null;
        }

        E toRemove = list[0];
        System.arraycopy(list, 1, list, 0, size - 1);
        size--;
        return toRemove;
    }

    public E getElement(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return null;
        }
        return list[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void resize() {
        // temp array to store old elements
        E[] temp = (E[]) new Object[size];

        // copy the old elements to temp array
        System.arraycopy(list, 0, temp, 0, size);

        // double the size of list
        list = (E[]) new Object[size * 2];

        // copy the old elements back to the list
        System.arraycopy(temp, 0, list, 0, temp.length);
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < size; i++) {
            s.append(list[i]).append(" ");
        }

        return s.toString();
    }
}
