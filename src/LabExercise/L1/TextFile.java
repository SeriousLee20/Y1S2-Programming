package LabExercise.L1;

/*
 * Author: Hui Xin
 * 19 Feb 2021
 */

import java.io.*;
import java.util.Scanner;

public class TextFile implements FileIO {
    private String filePath;

    public TextFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void read() {
        try{
            Scanner in = new Scanner(new FileInputStream(filePath));

            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }

            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }

    @Override
    public void write(String sentence) {

        try {

            PrintWriter out = new PrintWriter(new FileOutputStream(filePath, true));
            out.println(sentence);

            out.close();

        } catch (IOException e) {
            System.out.println("Problem with file output.");
        }
    }
}
