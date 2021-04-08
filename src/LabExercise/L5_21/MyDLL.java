package LabExercise.L5_21;

/*
 * Author: Hui Xin
 * 08 Apr 2021
 */

public class MyDLL<E> {

    private DLLNode<E> head;
    private DLLNode<E> tail;
    private int size;

    public MyDLL(DLLNode<E> head, DLLNode<E> tail) {
        this.head = head;
        this.tail = tail;
    }

    public MyDLL() {
    }

    /**Add node at the beginning*/
    public void addFirst(E data) {

        System.out.println("adding: " + data);

        DLLNode<E> newNode = new DLLNode<>(data);
        newNode.prev = null;

        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
        }

        size++;
    }

    /**Add node at the end*/
    public void addLast(E data) {

        System.out.println("adding: " + data);

        DLLNode<E> newNode = new DLLNode<>(data);

        if (head == null) {
            head = newNode;
            head.prev = null;
            tail = head;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    /**Add node within the list*/
    public void add(E data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index.");
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {

            System.out.println("adding: " + data);

            DLLNode<E> newNode = new DLLNode<>(data);
            DLLNode<E> current = head;

            /*Stop at one node before target node*/
            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;

            size++;
        }
    }

    /**Iterate forward to print*/
    public void iterateForward() {

        if (head == null) {
            System.out.println("Empty list.");
        } else {
            DLLNode<E> current = head;

            System.out.println("Iterating forward.. ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    /**Iterate backward to print*/
    public void iterateBackward() {
        if (head == null) {
            System.out.println("Empty list.");
        } else {
            DLLNode<E> current = tail;

            System.out.println("Iterating backward..");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.prev;
            }
            System.out.println();
        }
    }

    /**Remove the first node*/
    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty list. Nothing to be removed.");
        } else if (head.next == null) {
            System.out.println("deleted: " + head.data);

            head = null;
            tail = null;
            size = 0;
        } else {

            System.out.println("deleted: " + head.data);

            head = head.next;
            head.prev = null;
            size--;
        }
    }

    /**Remove the last node*/
    public void removeLast() {
        if (head == null) {
            System.out.println("Empty list. Nothing to be removed.");
        } else if (head.next == null) {

            System.out.println("deleted: " + head.data);

            head = null;
            tail = null;
            size = 0;
        } else {
            System.out.println("deleted: " + tail.data);
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    /**Remove node within the list*/
    public void remove(int index) {

        if (index < 0 || index >= size - 1) {
            System.out.println("Invalid index.");
        } else if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {

            DLLNode<E> current = head;

            /*Stop at one node before the target node*/
            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            System.out.println("deleted: " + current.next.data);
            current.next = current.next.next;
            current.next.prev = current;
            size--;
        }
    }

    public void clear() {
        System.out.println("successfully clear " + size + " node(s)");

        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }
}
