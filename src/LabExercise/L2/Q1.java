package LabExercise.L2;

/*
 * Author: Hui Xin
 * 20 Feb 2021
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Q1 {
    abstract class ArrayLinkedList<T> {

        abstract void generateNum(int n);

        abstract void display();
    }

    class Array extends ArrayLinkedList<int []> {

        private int[] num;

        public Array(int n) {
            num = new int[n];

            generateNum(n);
            display();
        }

        @Override
        void generateNum(int n) {

            Random rnd = new Random();

            for (int i = 0; i < num.length; i++) {

                num[i] = rnd.nextInt(101);

                for (int j = 0; j < i; j++) {
                    if (num[i] == num[j]) {
                        i--;
                        break;
                    }
                }
            }

            Arrays.sort(num);
        }

        @Override
        void display() {

            System.out.println("Array Implementation");
            for (int i : num) {
                System.out.print(i + " ");
            }
        }
    }

    class linkedList extends ArrayLinkedList<LinkedList> {

        private LinkedList<Integer> list;

        public linkedList(int n) {
            list = new LinkedList<>();

            generateNum(n);
            display();
        }
        @Override
        void generateNum(int n) {

            Random rnd = new Random();

            for (int i = 0; i < n; i++) {
                int temp = rnd.nextInt(101);

                if (list.size() > 0) {
                    while (list.contains(temp)) {
                        temp = rnd.nextInt(101);
                    }
                }

                list.add(temp);
            }

            Collections.sort(list);
        }

        @Override
        void display() {

            System.out.println("Linked List Implementation");

            for (Object i : list) {
                System.out.print(i + " ");
            }
        }
    }


}
