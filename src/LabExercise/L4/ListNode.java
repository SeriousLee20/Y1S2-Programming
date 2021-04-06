package LabExercise.L4;

/*
 * Author: Hui Xin
 * 23 Feb 2021
 */

public class ListNode<T extends Comparable<T>> {

    protected ListNode<T> next;
    protected T data;

    public ListNode() {
    }

    public ListNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }
}
