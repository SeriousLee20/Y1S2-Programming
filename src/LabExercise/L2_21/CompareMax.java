package LabExercise.L2_21;

/*
 * Author: Hui Xin
 * 14 Mar 2021
 */

public class CompareMax<E> {

    public CompareMax() {
    }

    public static <E extends Comparable<E>> E maximum(E o1, E o2, E o3) {
        if (o1.compareTo(o2) > 0 && o1.compareTo(o3) > 0) {
            return o1;
        } else if (o2.compareTo(o1) > 0 && o2.compareTo(o3) > 0) {
            return o2;
        }
        return o3;
    }

    public <E extends Comparable<E>> String minmax(E[] genericArray) {
        E min = genericArray[0];
        E max = genericArray[0];

        for (int i = 1; i < genericArray.length; i++) {

            if (genericArray[i].compareTo(max) > 0) {
                max = genericArray[i];
            } else if (genericArray[i].compareTo(min) < 0) {
                min = genericArray[i];
            }
        }

        return "Min = " + min + "   Max = " + max + " for";
    }
}
