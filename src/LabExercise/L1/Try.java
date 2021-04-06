package LabExercise.L1;

/*
 * Author: Hui Xin
 * 21 Feb 2021
 */

import java.io.*;
import java.util.Scanner;

public class Try {
    interface FileIO {
        public static void TextFile(String fileName) {
        }

        ;

        public static void BinaryFile(String fileName) {
        }

        ;
    }

    static class TextFile implements FileIO {
        public static void writeFile(String fileName, String line) {
            System.out.println("Write to text file");
            try {
                PrintWriter output;
                output = new PrintWriter(new FileOutputStream(fileName + ".txt"));
                output.println(line);
                System.out.println(line);
                output.close();
            } catch (Exception e) {
                System.out.println("Error!");
            }

        }

        public static void readFile(String fileName) throws FileNotFoundException {
            System.out.println("Read from text file");
            Scanner input = new Scanner(new FileInputStream(fileName + ".txt"));
            try {
                while (input.hasNextLine()) {
                    System.out.println(input.nextLine());
                }
                input.close();
            } catch (Exception e) {
                System.out.println("Error!");
            }


        }
    }


    class BinaryFile implements FileIO {
        public void writeFile(String fileName, String line) {
            System.out.println("Write to binary file");
            try {
                ObjectOutputStream output;
                output = new ObjectOutputStream(new FileOutputStream(fileName + ".txt"));
                output.writeUTF(line);
                System.out.println(line);
                output.close();
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

        public void readFile(String fileName) throws IOException {
            System.out.println("Read from binary file");
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName + ".dat"));
            try {
                while (true) {
                    System.out.println(input.readUTF());
                    input.close();
                }
            } catch (EOFException e) {
                System.out.println("Error!");
            }
        }
    }


    public static void main(String[] args) throws IOException {

        String file = "Binary File";
        Try t = new Try();

        Try.BinaryFile b = t.new BinaryFile();
        b.writeFile(file, "Welcome to FSKTM");
        b.writeFile(file, "Please register your matric number");
        b.writeFile(file, "Please register your UMMail account");

        b.readFile(file);
    }
}
