package FinalS2_20_21;

/*
 * Author: Hui Xin
 * 25 Jun 2021
 */

import java.util.Scanner;
import java.util.ArrayList;

public class PrintPages {
    public static void main(String[] args) {
        SpecialLL<Integer> bookPage = new SpecialLL<>();
        ArrayList<Integer> selectedList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the starting page: ");
        int start = input.nextInt();
        System.out.print("Enter number of pages: ");
        int page = input.nextInt();

        // add 2 lines of code here to
        //     insert values to bookPage
        //2c
        for (int i = start; i < start + page; i++)
            bookPage.addLast(i);

        // test add bookPage
        bookPage.print();

        // test printOdd
        bookPage.printOdd();

        // test getEven
        selectedList = bookPage.getEven();
        System.out.println(selectedList);

        // insert multiple lines of code here

        // print the odd numbered pages
        for (int i = start; i < page + 1; i += 2) {
            System.out.print(i +  " ");
        }
        System.out.println();

        // print the even numbered pages
        for (int i = start + 1; i < page + 2; i += 2) {
            System.out.print(" " + i);
        }
    }
}
