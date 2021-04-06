package LabExercise.L3;

/*
 * Author: Hui Xin
 * 23 Feb 2021
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new FileInputStream("C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\text2.txt"));

        recursiveRead(in);

    }

    public static void recursiveRead(Scanner input) {

        if (input.hasNextLine()) {
            String str = input.nextLine();
            recursiveRead(input);
            System.out.println(str);

            try{

                PrintWriter out = new PrintWriter(new FileOutputStream("Another file.txt", true));

                out.println(str);

                out.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
