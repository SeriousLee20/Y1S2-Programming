package LabExercise.L5_21;

/*
 * Author: Hui Xin
 * 04 Apr 2021
 */

public class StudentList<E> {

    private SNode<E> head;
    private SNode<E> tail;
    private int size;

    public StudentList() {
    }

    public StudentList(SNode<E> head, SNode<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    public void add(E e) {
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

    public void removeElement(E e) {
        boolean found = false;

        if (head == null) {
            System.out.println("The list is empty.");
            return;
        } else if (head.data.equals(e)) {
            head = head.next;
            found = true;
        } else if (tail.data.equals(e)) {

            found = true;
            SNode<E> current = head;

            while (current.next.next != null) {
                current = current.next;
            }

            current.next = null;
            tail = current;

        } else {

            SNode<E> current = head;
            SNode<E> prev = head;

            while (current != null) {
                if (current.data.equals(e)) {
                    found = true;
                    break;
                }
                prev = current;
                current = current.next;
            }

            if (found) {
                prev.next = current.next;
            } else {
                System.out.println("Data was not found.");
            }

        }

        if(found)
            size--;
    }

    public void printList() {
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

    public int getSize() {
        return size;
    }

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

    public void replace(E e, E newE) {

        SNode<E> newNode = new SNode<>(newE);
        boolean found = false;

        if (head == null) {
            System.out.println("The list is empty.");
        } else if (head.data.equals(e)) {
            newNode.next = head.next;
            head = newNode;
            found = true;
        } else if (tail.data.equals(e)) {

            found = true;

            SNode<E> current = head;

            while (current.next.next != null) {

                current = current.next;
            }

            current.next = newNode;
            tail = newNode;
        } else {

            SNode<E> current = head;
            SNode<E> prev = head;

            while (current != null) {
                if (current.data.equals(e)) {
                    found = true;
                    break;
                }

                prev = current;
                current = current.next;
            }

            if (found) {
                newNode.next = current.next;
                prev.next = newNode;
            } else {
                System.out.println("Data was not found.");
            }
        }
    }
}
