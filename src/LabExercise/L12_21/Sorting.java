package LabExercise.L12_21;

/*
 * Author: Hui Xin
 * 20 Jun 2021
 */

import java.util.Arrays;

/**
 * Sorting
 */
public class Sorting<T> {
    public static void main(String[] args) {
        String[] s = {"z", "c", "x", "d", "p"};
        System.out.println(Arrays.toString(selectionSort(s)));

        System.out.println(Arrays.toString(insertionSort(s)));

        System.out.println(Arrays.toString(mergeSort(s)));
        System.out.println(Arrays.toString(bubbleSort(s)));
    }

    public static <T extends Comparable<T>> T[] selectionSort(T[] list) {
        int minIndex;
        T min;

        // outer loop: sorted array
        for (int i = 0; i < list.length - 1; i++) {
            minIndex = i;
            min = list[i];

            // inner loop: unsorted loop
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(min) < 0) {
                    minIndex = j;
                    min = list[j];
                }
            }

            // swap min to the front if necessary
            if (minIndex != i) {
                list[minIndex] = list[i];
                list[i] = min;
            }
        }

        return list;
    }


    public static <T extends Comparable<T>> T[] insertionSort(T[] list) {
        T currentElement;
        int k;

        for (int i = 1; i < list.length; i++) {

            currentElement = list[i];

            // relocate the other elements until get the position for the current element
            for (k = i - 1; k >= 0 && list[k].compareTo(currentElement) > 0; k--) {
                list[k + 1] = list[k];
            }

            // insert current element to its location
            list[k + 1] = currentElement;
        }
        return list;
    }

    public static <T extends Comparable<T>> T[] bubbleSort(T[] list) {
        boolean needNextPass = true;

        for (int i = 1; i < list.length && needNextPass; i++) {

            // if list is sorted then this flag will remain false until the end of inner loop
            // then, the outer loop is terminated
            needNextPass = false;

            for (int j = 0; j < list.length - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;

                    // if swap occurs, then the list is not fully sorted
                    needNextPass = true;
                }
            }
        }
        return list;
    }

    public static String[] mergeSort(String[] list) {


        if (list.length > 1) {

            //Merge sort first half
            String[] firstHalf = new String[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort second half
            int secondHalfLength = list.length - list.length / 2;
            String[] secondHalf = new String[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }

        return list;
    }

    public static <T extends Comparable<T>> T[] merge(T[] list1, T[] list2, T[] temp) {

        int l1Current = 0;
        int l2Current = 0;
        int tempCurrent = 0;

        while (l1Current < list1.length && l2Current < list2.length) {

            // add elem in first half to temp if it's smaller than in second half
            if (list1[l1Current].compareTo(list2[l2Current]) < 0) {
                temp[tempCurrent++] = list1[l1Current++];
            } else {
                // else, add elem in second half to temp
                temp[tempCurrent++] = list2[l2Current++];
            }
        }

        // add the rest of first half
        while (l1Current < list1.length) {
            temp[tempCurrent++] = list1[l1Current++];
        }

        // add the rest of second half
        while (l2Current < list2.length) {
            temp[tempCurrent++] = list2[l2Current++];
        }
        return temp;
    }
}
