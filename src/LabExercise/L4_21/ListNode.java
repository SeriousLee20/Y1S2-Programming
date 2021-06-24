package LabExercise.L4_21;

/*
 * Author: Hui Xin
 * 25 Mar 2021
 */

public class ListNode<E> {

    E data;
    ListNode<E> next;

    public ListNode() {
    }

    public ListNode(E data) {
        this.data = data;
    }

    public ListNode<E> getNext() {
        return next;
    }

    public void setNext(ListNode<E> next) {
        this.next = next;
    }
}
