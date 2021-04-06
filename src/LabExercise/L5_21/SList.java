package LabExercise.L5_21;

/*
 * Author: Hui Xin
 * 04 Apr 2021
 */

import LabExercise.L4_21.Node;

public class SList<E> {

    private SNode<E> head;
    private SNode<E> tail;
    private int size;

    public SList() {
    }

    public SList(SNode<E> head, SNode<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    /**Append a new element at the end of the list*/
    public void appendEnd(E e) {
        SNode<E> newNode = new SNode<>(e);

        if (tail == null) {
            tail = newNode;
            head = tail;
            size++;
            return;
        }

        tail.next = newNode;
        tail = newNode;
        size++;
    }

    /**Eliminate the first element in the list*/
    public E removeInitial() {
        if (head == null) {
            System.out.println("The list is empty. No element is removed.");
            return null;
        }

        if (head.next == null) {
            E data = head.data;
            head = null;
            tail = null;
            size = 0;
            return data;
        }

        E data = head.data;
        head = head.next;
        size--;

        return data;
    }

    /**Search for an element and returns true if
     * this list contains the searched element*/
    public boolean contains(E e) {
        if (head == null) {
            return false;
        }

        SNode<E> current = head;

        while (current.next != null) {

            if (current.data.equals(e)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    /**Empty all elements in the list and return a statement that reports that the list is
     empty.*/
    public void clear() {
        head = null;
    }

    /**Display all values from the list in a successive order.*/
    public void display() {
        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            SNode<E> current = head;

            while (current != null) {
                System.out.print(current.data +" ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
