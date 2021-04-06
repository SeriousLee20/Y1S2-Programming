package LabExercise.L4_21;

/*
 * Author: Hui Xin
 * 25 Mar 2021
 */

public class Node<E> {

    E data;
    Node<E> next;

    public Node() {
    }

    public Node(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
