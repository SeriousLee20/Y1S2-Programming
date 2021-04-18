package LabExercise.L7_21;

/*
 * Author: Hui Xin
 * 19 Apr 2021
 */

import java.util.LinkedList;

public class MyQueue<E> {

    private LinkedList<E> list = new LinkedList<>();

    public MyQueue(E[] e) {
        for (E i : e) {
            list.add(i);
        }
    }

    public MyQueue() {
    }

    public void enqueue(E e) {
        list.add(e);
    }

    public E dequeue() {
        E data = list.getFirst();
        list.removeFirst();
        return data;
    }

    public E getElement(int i) {
        return list.get(i);
    }

    public E peek() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean contains(E e) {
        return list.contains(e);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public String toString() {
        return "Queue: " + list.toString();
    }
}
