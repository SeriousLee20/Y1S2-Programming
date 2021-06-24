package LabExercise.Lab9;

/*
 * Author: Hui Xin
 * 27 May 2021
 */

public class Permute {
    public static void main(String[] args) {

        permute("", "abc");
    }

    public static void permute(String beg, String end) {

        if (end.length() <= 1) {
            System.out.println(beg + end);
        } else {

            for (int i = 0; i < end.length(); i++) {
                String newStr = end.substring(0, i) + end.substring(i + 1);
                System.out.println("newString: " + newStr);
                permute(beg +  end.charAt(i), newStr);
            }
        }
    }
}
