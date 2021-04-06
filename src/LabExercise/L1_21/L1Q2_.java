package LabExercise.L1_21;

/*
 * Author: Hui Xin
 * 14 Feb 2021
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L1Q2_ {
    public static void main(String[] args) {

       /*Text1();
       Text2();
       Text3();*/

        System.out.println("Text 1");
        readText("C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\L1New\\text1.txt", ",");

        System.out.println("\n\nText 2");
        readText("C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\L1New\\text2.txt", ", ");

        System.out.println("\n\nText 3");
        readText("C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\L1New\\text3.txt", "; ");

        System.out.println("\n\nText 4");
        readText("C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\L1New\\text4.txt", "\\d+");
    }


    public static void readText(String filePath, String separator) {

        int count = 0;
        String str;

        try{

            Scanner input = new Scanner(new FileInputStream(filePath));

            while (input.hasNextLine()) {
                str = "";
                String[] temp = input.nextLine().split(separator);

                for(String i : temp)
                    str += i;

                count += temp.length;
                System.out.println(str);
            }

            System.out.println("Total number of characters found without special characters: " + count);

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }
    }

    public static void Text1() {
        int count;
        String str;
        String filePath = "C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\text1.txt";

        // Text 1
        try {
            Scanner input = new Scanner(new FileInputStream(filePath));

            count = 0;

            while(input.hasNextLine()) { //check end of text file
                str = input.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    if (Character.isLetterOrDigit(str.charAt(i))) {
                        count++;
                        System.out.print(str.charAt(i));
                    }
                }
            }
            System.out.println("\nTotal characters in text without special characters: " + count);

            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File was not found");
        }
        System.out.println();
    }

    public static void Text2() {
        int count;
        String str;
        String filePath;

        filePath = "C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\L1New\\text1.txt";

        // Text 2
        try {
            Scanner input = new Scanner(new FileInputStream(filePath));

            int line = 0;


            while(input.hasNextLine()) { //check end of text file

                count = 0;
                line ++;

                str = input.nextLine();

                for (int i = 0; i < str.length(); i++) {
                    if (Character.isLetterOrDigit(str.charAt(i))) {

                        count++;
                        System.out.print(str.charAt(i));
                    }
                }

                System.out.println("\nNumber of characters without special characters in Line " + line + ": " + count);
            }



            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File was not found");
        }

    }

    public static void Text3() {
        int count;
        String str;
        String filePath;

        // Text 3
        filePath = "C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\text3.txt";

        // Read all text
        try {
            Scanner input = new Scanner(new FileInputStream(filePath));

            count = 0;
            String temp = "";

            Pattern p = Pattern.compile("([0-9]+\\.*[0-9]*)");

            while(input.hasNextLine()) { //check end of text file
                str = input.nextLine();

                Matcher matcher = p.matcher(str);

                for (int i = 0; i < str.length(); i++) {
                    while (matcher.find()) {
                        count++;
                        System.out.println(matcher.group(1));
                    }
                }

            }

            //System.out.println(temp);
            System.out.println("Total number of numbers in the text: " + count);
            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File was not found");
        }
        System.out.println();


        // Text 3, read by line
        try {
            Scanner input = new Scanner(new FileInputStream(filePath));

            int line = 0;

            Pattern p = Pattern.compile("([0-9]+\\.*[0-9]*)");

            while(input.hasNextLine()) { //check end of text file
                //String temp = "";
                count = 0;
                line ++;
                str = input.nextLine();

                Matcher matcher = p.matcher(str);

                for (int i = 0; i < str.length(); i++) {
                    while (matcher.find()) {
                        count++;
                        //temp += matcher.group(1);
                        System.out.println(matcher.group(1));
                    }
                }

                //System.out.println(temp);
                System.out.println("\nTotal number of numbers in Line " + line + ": " + count);
            }

            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File was not found");
        }
        System.out.println();
    }
}
