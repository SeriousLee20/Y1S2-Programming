package LabExercise.L3;

/*
 * Author: Hui Xin
 * 22 Feb 2021
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    static class Permutation {

        public int[] swap(int[] elements, int x, int y) {
            int temp = elements[x];
            elements[x] = elements[y];
            elements[y] = temp;

            System.out.println("\t" + Arrays.toString(elements));
            return elements;
        }

        /*
        * @param beg = initial index
        * @param end = end index
        * */
        public void permute(int[] elements, int beg, int end) {

            System.out.println("beg: " + beg);
            // print non-duplicated result
            if (beg == end) {

                if (elements[0] == 0) {
                    for (int i = 1; i < elements.length; i++) {
                        System.out.print(elements[i]);
                    }
                } else
                    for (int i : elements) {
                        System.out.print(i);
                    }
                System.out.println("\n");

            } else {

                for (int i = beg; i <= end; i++) {
                    System.out.println("    1) i: " + i + "; beg: " + beg);
                    swap(elements, beg, i);

                    System.out.print("3) i: " + i + "; ");
                    permute(elements, beg + 1, end);

                    System.out.println("    2) i: " + i + "; beg: " + beg);
                    swap(elements, beg, i); //backtrack, unswap
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Permutation p = new Permutation();

        System.out.print("Enter number of elements: ");
        int numOfElement = in.nextInt();

        in.nextLine();

        System.out.print("The elements of the array: ");
        String elem = in.nextLine();

        int[] elements = new int[elem.length()];

        for (int i = 0; i < elem.length(); i++) {
            elements[i] = Integer.parseInt(String.valueOf(elem.charAt(i)));
        }

        p.permute(elements, 0, elements.length - 1);
    }
}

/*
* head
* 1) if(beg == end) => print
*       continue the loop (backtracking)
*       swap, loop, (if applicable, increase loop count), else continue backtracking
* 2) else loop
*   swap, call permute, back to 1
*
* end when cant increase loop count, and cant backtrack anymore*/