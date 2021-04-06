package LabExercise.L1_21;

/*
 * File I/O
 * Q1
 * Author: Hui Xin
 * 14 Feb 2021
 */

import java.io.*;
import java.util.Scanner;

public class L1Q1_ {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\Lee Hui Xin_U2005353.txt";
        Scanner in = new Scanner(System.in);

        try {

            PrintWriter output = new PrintWriter(new FileOutputStream(filePath, true));

            output.println("\n");
            /*output.println("How is the performance? Are you happy with your performance?");
            output.println("What has learning DS taught you");
            output.println("Is there any change to your target grade");
            output.println("What you did well during the course");
            output.println("What could have been done better during the course");*/

            output.println("\n\nThursday, 18 June 2021\n");

            String line = "";
            while(!(line = in.nextLine()).equals(""))
                output.println(line);
            output.close();
        }
        catch(IOException e) {
            System.out.println("Problem with file output.");
        }



        try {
            Scanner input = new Scanner(new FileInputStream(filePath));

            while(input.hasNextLine()) { //check end of text file
                System.out.println(input.nextLine());
            }

            input.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("File was not found");
        }


    }
}
