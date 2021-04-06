package LabExercise;

/*
 * Author: Hui Xin
 * 15 Feb 2021
 */

public class L2Q1_ {

    private int count;

    public static void main(String[] args) {

        L2Q1_ obj = new L2Q1_();

        String str = "flabbergasted";
        str = obj.substituteAI(str);
        System.out.println(str);

        L2Q1_ obj1 = new L2Q1_();
        str = "Astronaut";
        str = obj1.substituteAI(str);
        System.out.println(str);
    }

    public String substituteAI(String str) {

        if (count == str.length()) {
            return str;
        }

        else {
            char c = str.charAt(count);

            if (c == 'a') {
                c = 'i';
                str = str.substring(0, count) + c + str.substring(count + 1);
            }

            count++;
            return substituteAI(str);
        }
    }
}
