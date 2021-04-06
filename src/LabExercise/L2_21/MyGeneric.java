package LabExercise.L2_21;

/*
 * Author: Hui Xin
 * 14 Mar 2021
 */

public class MyGeneric<E> {

    E e;

    public MyGeneric() {
    }

    public MyGeneric(E e) {
        this.e = e;
    }

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
}
