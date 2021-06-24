package LabTest3;

/*
 * Author: Hui Xin
 * 03 Jun 2021
 */

import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (true) {
            String code = in.next();

            String result = enter(code, 0, 0);

            System.out.println(code + "------>" + result );

            if (result.equals("correct")) {
                break;
            }
        }
    }

    /**
     * @param s the syntax entered
     * @param i index of the character
     * @param numOfAsterisk number of asterisk
     */
    public static String enter(String s, int i, int numOfAsterisk) {

        String wrong = "Please put the digits between two stars";
        String correct = "correct";

        // check if the code is empty
        if (s.equals("")) {
            return "The code cannot be empty";
        }

        // when finish parsing the string
        if (i == s.length()) {

            // true if all the character inside the *
            if (numOfAsterisk % 2 == 0) {

                // true if number of * is even
                return correct;

            } else

                // else wrong
                return wrong;
        }

        if (i == 0 && s.charAt(i) != '*') {

            // wrong if first character is not *
            return wrong;

        } else if (i == s.length() - 1 && s.charAt(i) != '*') {

            // wrong if last character not *
            return wrong;

        } else {

            // check if current character is *
            if (s.charAt(i) == '*') {

                // if *, then call the method again
                // increase i with 1
                // num of * plus 1
                return enter(s, i + 1, numOfAsterisk + 1);

            } else {    // if current character not *

                char a = s.charAt(i);

                // check if the character is digit
                if (Character.isDigit(a)) {

                    // if yes, call the method, to check the next character
                    return enter(s, i + 1, numOfAsterisk);

                } else {

                    // else the code format is wrong
                    return wrong;

                }
            }
        }
    }
}
