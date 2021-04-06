package LabExercise.L2_21;

/*
 * Author: Hui Xin
 * 14 Mar 2021
 */

public class FindMax {

    class Circle implements Comparable<Circle> {

        double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public int compareTo(Circle o) {
            if(radius > o.radius)
                return 1;
            else if(radius < o.radius)
                return -1;
            return 0;
        }

        @Override
        public String toString() {
            return "" + radius;
        }
    }

    public <E extends Comparable<E>> String max(E[] genericArray) {

        // check if array is the Circle type
       /* if (genericArray instanceof Circle[]) {

            FindMax.Circle m = (Circle) genericArray[0];

            for (int i = 1; i < genericArray.length; i++) {
                // cast the array to Circle first
                FindMax.Circle temp = (Circle) genericArray[i];

                //then this temp call the compareTo from Circle
                if (temp.compareTo(m) > 0) {
                    m = temp;
                }
            }
            return "Max = " + m.radius;

        } else {*/

            E max = genericArray[0];

            for (int i = 1; i < genericArray.length; i++) {

                if (genericArray[i].compareTo(max) > 0) {
                    max = genericArray[i];
                }
            }
            return "Max = " + max;
       // }

    }
}
