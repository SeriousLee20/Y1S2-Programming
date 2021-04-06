package LabExercise.L3_21;

/*
 * Author: Hui Xin
 * 21 Mar 2021
 */

public class ArrayBag<T> implements BagInterface<T> {

    private T[] bag;
    private final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    public ArrayBag() {
        bag = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == DEFAULT_CAPACITY;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if(isFull())
            return false;

        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {

        if (!isEmpty()) {
            T temp = bag[numberOfEntries - 1];

            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return temp;
        }

        return null;
    }

    @Override
    public boolean remove(T anEntry) {

        if (isEmpty()) {
            return false;
        }

        int pos = 0;

        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                pos = i;
                break;
            }
        }

        if (pos == DEFAULT_CAPACITY - 1) {
            remove();
        } else {
            for (int i = pos; i < numberOfEntries - 1; i++) {
                bag[i] = bag[i + 1];
            }
            numberOfEntries--;
        }

        return true;
    }

    @Override
    public void clear() {

        new ArrayBag<T>();
        numberOfEntries = 0;
    }

    @Override
    public int getFrequencyOf(T anEntry) {

        if (isEmpty()) {
            return 0;
        }

        int count = 0;

        for (T i : bag) {
            if (i == anEntry) {
                count++;
            }
        }

        return count;
    }

    @Override
    public boolean contains(T anEntry) {

        if(isEmpty())
            return false;

        for (T i : bag) {
            if (i.equals(anEntry)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public T[] toArray() {
        //size of new array is the current number of entries
        T[] temp = (T[]) new Object[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++) {
            temp[i] = bag[i];
        }
        return temp;
    }

    @Override
    public ArrayBag<T> union(ArrayBag<T> bag) {

        if (this.bag == null || bag.isEmpty()) {
            System.out.println("Both bags cannot be empty.");
            return null;
        }

        if(this.getCurrentSize() + bag.getCurrentSize() > DEFAULT_CAPACITY) {
            System.out.println("The total number of elements exceed the capacity.");
            return null;
        }

        ArrayBag<T> everything = new ArrayBag<>();
        for (T i : this.bag) {
            if (i == null) {
                break;
            }
            everything.add(i);
        }

        for (T i : bag.bag) {
            if (i == null) {
                break;
            }
            everything.add(i);
        }

        return everything;
    }

    @Override
    public ArrayBag<T> intersection(ArrayBag<T> bag) {

        if (this.isEmpty() || bag.isEmpty()) {
            System.out.println("Both bags cannot be empty.");
            return null;
        }

        ArrayBag<T> commonItems = new ArrayBag<>();
        T[] temp = (T[]) new Object[bag.getCurrentSize()];
        System.arraycopy(bag.bag, 0, temp, 0, bag.getCurrentSize());

        for (T i : this.bag) {
            if (i == null)
                break;

            for (int j = 0; j < bag.getCurrentSize(); j++) {
                if (temp[j] == null) {
                    continue;
                }

                if (i.equals(temp[j])) {
                    commonItems.add(i);
                    temp[j] = null;
                    break;
                }
            }
        }
        return commonItems;
    }

    @Override
    public ArrayBag<T> difference(ArrayBag<T> bag) {
        if (bag.isEmpty() || this.isEmpty()) {
            System.out.println("Both bags cannot be empty.");
            return null;
        }

        ArrayBag<T> leftOver = new ArrayBag<>();
        T[] temp = (T[]) new Object[bag.getCurrentSize()];

        System.arraycopy(bag.bag, 0, temp, 0, temp.length);

        boolean notFoundInOtherBag = true;

        for (T i : this.bag) {

            if(i == null)
                break;

            for (int j = 0; j < bag.getCurrentSize(); j++) {

                notFoundInOtherBag = true;

                if (temp[j] == null)
                    continue;

                if (i.equals(temp[j])) {
                    temp[j] = null;
                    notFoundInOtherBag = false;
                    break;
                }

            }
            if(notFoundInOtherBag)
                leftOver.add(i);
        }

        return leftOver;
    }

    public void print() {
        for (int i = 0; i < numberOfEntries; i++) {
            System.out.print(bag[i] + " ");
        }
        System.out.println();
    }
}
