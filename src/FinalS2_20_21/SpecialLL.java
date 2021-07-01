package FinalS2_20_21;

/*
 * Author: Hui Xin
 * 25 Jun 2021
 */

import java.util.ArrayList;
import java.util.Collections;

public class SpecialLL<E> {
    Node<E> head, tail;
    int size = 0;

    public SpecialLL() {}

    public int getSize() {
        return size;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e);
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    public void print() {
        Node<E> current = head;
        for(int i=0; i<size; i++) {
            System.out.print(current.element + " ");
            current=current.next;
        }
        System.out.println();
    }

    // 2a
    public void printOdd() {
        Node<E> current = head;
        int i = 1;

        while (current != null) {
            if (i % 2 != 0) {
                System.out.print(current.element + " ");
            }
            current = current.next;
            i++;
        }
        System.out.println();
    }

    //2b
    public ArrayList<E> getEven() {

        Node<E> current = head;
        ArrayList<E> even = new ArrayList<>();
        int i = 1;

        while (current != null) {
            if(i % 2 == 0)
                even.add(current.element);
            current = current.next;
            i++;
        }

        Collections.reverse(even);
        return even;
    }
}

