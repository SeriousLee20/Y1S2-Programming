package LabExercise.L2_21;

/*
 * Author: Hui Xin
 * 14 Mar 2021
 */

public class StorePairGeneric<E extends Comparable<E>> implements Comparable<StorePairGeneric<E>> {

    private E first, second;

    public StorePairGeneric(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public void setPair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "first = " + first + " second " + second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StorePairGeneric<?> that = (StorePairGeneric<?>) o;
        return first.equals(that.first);
    }

    @Override
    public int compareTo(StorePairGeneric<E> o) {
        return (Integer) this.first - (Integer) o.first;
    }
}
