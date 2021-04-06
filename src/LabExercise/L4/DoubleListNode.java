package LabExercise.L4;

/*
 * Author: Hui Xin
 * 07 Mar 2021
 */

public class DoubleListNode<T> {

     T data;
     DoubleListNode<T> next;
     DoubleListNode<T> prev;

    public DoubleListNode(T data) {
        this.data = data;
    }

    public DoubleListNode(T data, DoubleListNode<T> prev, DoubleListNode<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleListNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleListNode<T> next) {
        this.next = next;
    }

    public DoubleListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleListNode<T> prev) {
        this.prev = prev;
    }
}
