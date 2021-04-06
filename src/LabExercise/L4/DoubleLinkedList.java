package LabExercise.L4;

/*
 * Author: Hui Xin
 * 07 Mar 2021
 */

public class DoubleLinkedList<T> {

    private DoubleListNode<T> head;

    public int length() {

        if (isEmpty()) {
            return 0;
        }

        DoubleListNode<T> current = head;
        int count = 0;

        while (current != null) {
            count ++;
            current = current.getNext();
        }

        return count;
    }

    public void printList() {

        if (isEmpty()) {
            System.out.println("The list is empty.");
        }

        DoubleListNode<T> current = head;

        while (current != null) {
            System.out.print("<-- " + current.getData() + " --> ");
            current = current.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty() {

        return head == null;
    }

    public void deleteFront() {

        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        head = head.getNext();
        head.setPrev(null);
    }

    public void prepend(T data) {
            head = new DoubleListNode<>(data, null, head);
    }

    public void pop() {

        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        DoubleListNode<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;

    }

    public void append(T data) {

        if (isEmpty()) {
            head = new DoubleListNode<>(data, null, head);
            return;
        }

        DoubleListNode<T> newNode = new DoubleListNode<>(data);
        newNode.setNext(null);

        DoubleListNode<T> current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        newNode.prev = current;
        current.next = newNode;
    }

    public void addByPosition(int index, T data) {
        if (isEmpty()) {
            System.out.println("The list is empty. No data is added.");
        } else if (index == 0) {
            append(data);
        } else if (index == length() - 1) {
            append(data);
        } else if (index < 0 || index >= length()) {
            System.out.println("Invalid index.");
        } else {
            DoubleListNode<T> newNode = new DoubleListNode<>(data);
            DoubleListNode<T> current = head;

            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
            newNode.setPrev(current);

            /*newNode.next = current.getNext();
            current.next.prev = newNode;
            current.next = newNode;
            newNode.prev = current;*/
        }
    }

    public void deleteByPosition(int index) {
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else if (index == 0) {
            deleteFront();
        } else if (index == length() - 1) {
            pop();
        } else if (index < 0 || index >= length()) {
            System.out.println("Invalid index. No data is deleted.");
        } else {

            DoubleListNode<T> current = head;

            for (int i = 1; i < index; i++) {
                current = current.next;
                //System.out.print(current.getData() + " ");
            }

            //DoubleListNode<T> temp = current.next;

            current.next = current.next.next;
            if (current.next != null) {
                current.next.prev = current;
            }
        }
    }

    public void replace(int index, T data) {

        DoubleListNode<T> newNode = new DoubleListNode<>(data);

        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else if (index == 0) {

            newNode.next = head.next;
            head = newNode;

        } else if (index < 0 || index >= length()) {
            System.out.println("Invalid index.");

        } else {

            DoubleListNode<T> current = head;

            for (int i = 1; i < index; i++) {
                //if(current.next != null)
                    current = current.next;
            }

            newNode.next = current.next.next;
            newNode.prev = current;
            current.next = newNode;
        }
    }

    public T getFront() {
        if (isEmpty()) {
            return null;
        }

        return head.getData();
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }

        DoubleListNode<T> current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        return current.getData();
    }

    public T getData(int index) {

        if (head == null) {
            return null;
        } else if (index == 0) {
            getFront();
        } else if (index == length() - 1) {
            getLast();
        } else if (index < 0 || index >= length()) {
            System.out.println("Invalid index.");
            return null;
        }

        DoubleListNode<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current.getData();
    }

    public void deleteData(T data) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
        } else if (head.getData().equals(data)) {
            head.setNext(head.getNext());
            head.setPrev(null);
        } else {

            DoubleListNode<T> current = head;

            while (current.next != null) {
                if (current.next.data == data) {

                    DoubleListNode<T> temp = current.next.next;

                    current.next = temp;

                    if (temp != null) {
                        current.next.prev = current;
                    }

                    return;
                }

                current = current.getNext();
            }
        }
    }

}
