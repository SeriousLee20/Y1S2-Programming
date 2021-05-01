package LabExercise.Stack_Extra;

/*
 * Author: Hui Xin
 * 27 Apr 2021
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class HTMLTagMatching {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\Hui Xin\\Documents\\UM Programming\\Y1S2 Programming\\src\\LabExercise\\Stack_Extra\\SampleHTML.txt";

        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String str;

            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }

            in.close();

        } catch (IOException e) {
        }

        String content = contentBuilder.toString();

        System.out.println(isHTMLMatched(content));

    }
    public static boolean isHTMLMatched(String html) {

        Stack<String> buffer = new Stack<>();

        int j = html.indexOf('<');  //index of '<'

        while (j != -1) {   // no '<' is found
            int k = html.indexOf('>', j + 1);   // index of '>'

            if (k == -1) {  // missing '>'
                return false;
            }

            String tag = html.substring(j + 1, k);  // extracting tag

            // opening tag is pushed into stack sequentially
            // from outermost to innermost
            if (!tag.startsWith("/")) { // if not a closing tag
                    buffer.push(tag);
                } else {
                    if (buffer.isEmpty()) { // if no opening tag
                        return false;
                    }

                // if closing tag not match with opening tag
                // opening tag is pop from last to first (innermost to outermost)
                    if (!tag.substring(1).equals(buffer.pop())) {
                        return false;
                    }
                }

            j = html.indexOf('<', k + 1);
        }
        return buffer.isEmpty();
    }
}
