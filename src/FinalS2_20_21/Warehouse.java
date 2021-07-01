package FinalS2_20_21;

/*
 * Author: Hui Xin
 * 25 Jun 2021
 */

import java.util.Random;
import java.util.Scanner;

public class Warehouse {
    private int[] tag;
    private int tagNum;

    public static void main(String[] args) {
        Random rn = new Random();
        Scanner in = new Scanner(System.in);

        int[] tags = new int[1000];

        for (int i = 0; i < tags.length / 2; i++) {
            tags[i] = rn.nextInt(1000);
        }

        Warehouse w = new Warehouse(tags, tags.length / 2);
        System.out.println("Which parcel to find: ");
        int find = in.nextInt();

        System.out.println("Time needed by using linear search: " + w.linearSearch(find) + " minutes");

        double time1 = w.system1(find);
        double time2 = w.system2(find);
        System.out.println("Time needed for system 1: " + time1 + " minutes");
        System.out.println("Time needed for system 2: " + time2 + " minutes");

        System.out.println((time1 < time2) ? "System 1 is more efficient." : " System 2 is more efficient.");

    }

    public Warehouse(int[] tag, int numOfTag) {
        this.tag = tag.clone();
        tagNum = numOfTag;

        System.out.println("----Tag list----");
        System.out.print(tag[0] + " ");

        for (int i = 1; i < numOfTag; i++) {
            System.out.print(tag[i] + " ");

            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public double linearSearch(int find) {
        int seconds = 0;

        for (int i = 0; i < tagNum; i++) {
            seconds += 15;
            if (find == tag[i]) {
                System.out.println("Parcel is found at location " + i);
                return seconds/60;
            }
        }

        System.out.println("Parcel was not found.");
        return seconds / 60.0;
    }

    // insertion sort + binary search
    public double system1(int find) {
        double time = insertionSort();
        binarySearch(find);
        return time;
    }

    // bubble sort + binary search
    public double system2(int find) {
        double time = bubbleSort();
        binarySearch(find);
        return time;
    }

    public void binarySearch(int find) {

        int low = 0;
        int high = tagNum - 1;
        int location;

        while (high >= low) {

            int mid = (low + high) / 2;
            if (find < tag[mid]) {

                high = mid - 1;

            } else if (find == tag[mid]) {
                System.out.println("Parcel was found at location " + mid);
                location = mid;
                return;
            } else {
                low = mid + 1;
            }
        }
        System.out.println("Parcel was not found.");
    }

    public double insertionSort() {
        int[] temp = tag.clone();

        int currentElement;
        int k;
        int seconds = 0;

        for (int i = 1; i < tagNum; i++) {

            currentElement = temp[i];

            // relocate the other elements until get the position for the current element
            for (k = i - 1; k >= 0 && tag[k] > currentElement; k--) {
                seconds += 15; // time to identify tag
                seconds += 6;   // time to swap tag
                tag[k + 1] = tag[k];
            }

            seconds += 6;
            // insert current element to its location
            tag[k + 1] = currentElement;
        }

        System.out.println("----Insertion Sorted list----");
        System.out.print(tag[0] + " ");

        for (int i = 1; i < tagNum; i++) {
            System.out.print(tag[i] + " ");

            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();

        return seconds/60.0;
    }

    public double bubbleSort() {
        boolean needNextPass = true;
        int seconds = 0;
        int[] tempTags = tag.clone();
        for (int i = 1; i < tagNum && needNextPass; i++) {

            // if list is sorted then this flag will remain false until the end of inner loop
            // then, the outer loop is terminated
            needNextPass = false;

            for (int j = 0; j < tempTags.length - i; j++) {

                seconds += 15; // time to identify tag
                if (tag[j] > tempTags[j + 1]) {

                    int temp = tempTags[j];
                    tempTags[j] = tempTags[j + 1];
                    tempTags[j + 1] = temp;
                    seconds += 18; // time to swap = 3 * 6

                    // if swap occurs, then the list is not fully sorted
                    needNextPass = true;
                }
            }
        }

        System.out.println("----Bubble Sorted list----");
        System.out.print(tag[0] + " ");

        for (int i = 1; i < tagNum; i++) {
            System.out.print(tag[i] + " ");

            if (i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        return seconds/60.0;
    }
}
