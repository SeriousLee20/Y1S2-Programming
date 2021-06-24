package LabExercise.L11_21;

/*
 * Author: Hui Xin
 * 20 Jun 2021
 */

public class Searching<T> {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr, 6));
    }

    public static <T> int linearSearch(T[] list, T key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i]) {
                return i;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] list, T key) {
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {

            int mid = (low + high) / 2;
            if (key.compareTo(list[mid]) < 0) {
                high = mid - 1;
            } else if (key == list[mid]) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

