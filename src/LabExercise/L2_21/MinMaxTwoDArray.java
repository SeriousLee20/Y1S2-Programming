package LabExercise.L2_21;

/*
 * Author: Hui Xin
 * 15 Mar 2021
 */

public class MinMaxTwoDArray {

    // return the min element in 2D array
    public <E extends Comparable<E>> E max(E[][] list) {

        E max = list[0][0];

        for (int i = 0; i < list.length; i++) {

            for (int j = 1; j < list[i].length; j++) {

                if (list[i][j].compareTo(max) > 0) {
                    max = list[i][j];
                }
            }
        }
        return max;
    }

    public <E extends Comparable<E>> E min(E[][] list) {

        E min = list[0][0];

        for (int i = 0; i < list.length; i++) {

            for (int j = 1; j < list[i].length; j++) {

                if (list[i][j].compareTo(min) < 0) {
                    min = list[i][j];
                }
            }
        }
        return min;
    }


}
