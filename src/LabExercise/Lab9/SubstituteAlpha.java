package LabExercise.Lab9;

/*
 * Author: Hui Xin
 * 27 May 2021
 */

public class SubstituteAlpha {
    public static void main(String[] args) {

        System.out.println(sub("flabbergasted"));

    }

    public static String sub(String str) {

        if (str.length() < 1) {
            return str;
        }
        else {
            char first = 'a' == str.charAt(0) ? 'i' : str.charAt(0);
            return first + sub(str.substring(1));
        }
    }
}
