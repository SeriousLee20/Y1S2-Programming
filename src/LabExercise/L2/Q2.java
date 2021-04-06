package LabExercise.L2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Q2 {

    interface SimpleLog {
        void insert(String str);

        boolean notFull();

        void bagSize();

        void contains(String str);

        void clear();

        void display();

    }

    class TextFileLog implements SimpleLog{

        private String filePath;
        private int maxRecord;
        private int fileSize;
        private Scanner out;
        private PrintWriter in;

        public TextFileLog(String filePath, int maxRecord) {
            this.filePath = filePath;
            this.maxRecord = maxRecord;
        }

        @Override
        public void insert(String str) {
            try{
                in = new PrintWriter(new FileOutputStream(filePath, true));

                if (notFull()) {
                    in.println(str);
                    fileSize++;
                } else {
                    System.out.println("Adding another record");
                    System.out.println("The log is full");
                }

                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File was not found.");
            }
        }

        public boolean notFull() {
            return fileSize < maxRecord;
        }

        @Override
        public void bagSize() {
            System.out.println("Text File Log Size " + fileSize);
        }

        @Override
        public void contains(String str) {
            boolean contain = false;

            try{
                out = new Scanner(new FileInputStream(filePath));
                System.out.println("Searching for " + str + " in the file");

                while (out.hasNextLine()) {


                    if (str.equals(out.nextLine())) {
                        System.out.println("Text File Log contains " + str);
                        contain = true;
                        break;
                    }
                }

                if (!contain) {
                    System.out.println("The log does not contain " + str);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File was not found.");
            }
        }

        @Override
        public void clear()  {

            try{
                in = new PrintWriter(new FileOutputStream(filePath));

                System.out.println("Clear the text file log");

                fileSize = 0;

                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File was not found.");
            }
        }

        @Override
        public void display() {

            try {
                out = new Scanner(new FileInputStream(filePath));

                while (out.hasNextLine()) {
                    System.out.println(out.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File was not found.");
            }
        }
    }


    public static void main(String[] args) {
        Q2 q2 = new Q2();

        Q2.TextFileLog log = q2.new TextFileLog("Log File.txt", 5);

        System.out.println("Create a text file log with maximum record equal to 5");

        log.insert("James");
        log.insert("Ahmad");
        log.insert("Siti");
        log.insert("Ramesh");
        log.insert("John");

        log.bagSize();
        log.display();

        System.out.println();
        log.insert("Lily");

        log.contains("Siti");

        log.clear();
        log.bagSize();
    }
}

