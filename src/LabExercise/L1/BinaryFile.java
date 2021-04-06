package LabExercise.L1;

/*
 * Author: Hui Xin
 * 19 Feb 2021
 */

import java.io.*;

public class BinaryFile implements FileIO {

    private String filePath;

    public BinaryFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void read() {
        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));

            try {
                while (true) {
                    System.out.println(in.readUTF());
                }
            } catch (EOFException e) {
                System.out.println("Reached end of file.");
            }

            in.close();
        }catch (FileNotFoundException e) {
                System.out.println("File was not found.");
        } catch (IOException e) {
            System.out.println("Error reading from file");
        }
    }

    @Override
    public void write(String sentence) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath, true));

            out.writeUTF(sentence);

            out.close();
        } catch (IOException e) {
            System.out.println("Problem with file output.");
        }
    }
}
