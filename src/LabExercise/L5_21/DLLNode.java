package LabExercise.L5_21;

/*
 * Author: Hui Xin
 * 08 Apr 2021
 */

public class DLLNode<E> {
    E data;
    DLLNode<E> next, prev;

    public DLLNode(E data) {
        this.data = data;
        this.next = null;
    }


}
