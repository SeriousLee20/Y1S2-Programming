package LabExercise.L12_21;

/*
 * Author: Hui Xin
 * 21 Jun 2021
 */

import java.util.Arrays;

public class LabQuestion {
    public static void main(String[] args) {
        int[] arr = {45, 7, 2, 8, 19, 3};
        selectionSortSmallest(arr);
        printArr(arr);
        selectionSortLargest(arr);
        printArr(arr);

        int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void selectionSortSmallest(int[] arr) {

        System.out.println("Selection Sort Smallest");
        int min;
        int minIndex;

        for (int i = 0; i < arr.length - 1; i++) {

            min = arr[i];
            minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    public static void selectionSortLargest(int[] arr) {
        System.out.println("Selection Sort Largest");
        int max;
        int maxIndex;

        for (int i = 0; i < arr.length - 1; i++) {

            max = arr[i];
            maxIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                arr[maxIndex] = arr[i];
                arr[i] = max;
            }
        }

    }

    public static void insertionSort(int[] arr) {

        int current;
        int k;

        for (int i = 1; i < arr.length; i++) {
            current = arr[i];

            for (k = i - 1; k >= 0 && arr[k] > current; k--) {
                arr[k + 1] = arr[k];
            }

            arr[k + 1] = current;
        }
    }

    public static void printArr(int[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
