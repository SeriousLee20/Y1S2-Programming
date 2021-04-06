package PYQ;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

public class MyArrayList<T> {

    private T[] array;
    private int size;
    private int existingEntries;

    public MyArrayList() {
    }

    public MyArrayList(int size) {
        this.size = size;
        array = (T[]) new Object[size];
    }

    public void add(T data) {

        if (existingEntries == size) {
            //System.out.println("The list is full.");
            return;
        }

        array[existingEntries] = data;
        existingEntries++;
        //System.out.println(data + " is added to the list.");

    }

    public void addToIndex(T data, int index) {

        if (existingEntries == size) {
            System.out.println("The list is full.");
            return;
        }

        if (array[index] != null) {
            T[] temp = (T[]) new Object[existingEntries - index];

            int x = index;
            for (int i = 0; i < temp.length; i++) {
                temp[i] = array[x];
                x++;
            }

            array[index] = data;

            x = 0;
            for (int i = index + 1; i < size; i++) {
                array[i] = temp[x];
                x++;
            }
        }
    }

    public void removeFromIndex(int index) {

        if (existingEntries == 0) {
            System.out.println("The list is empty.");
            return;
        }

        for (int i = index; i < existingEntries - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    public T getFromIndex(int index) {
        if (existingEntries == 0) {
            System.out.println("The list is empty.");
            return null;
        }

        if (index < 0 || index >= existingEntries) {
            System.out.println("Invalid index.");
            return null;
        }

        return array[index];
    }

    public int getSize() {
        return size;
    }

    public int getExistingEntries() {
        return existingEntries;
    }

    @Override
    public String toString() {
        return "";
    }
}
