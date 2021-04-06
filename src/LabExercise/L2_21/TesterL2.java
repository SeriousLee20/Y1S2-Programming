package LabExercise.L2_21;

/*
 * Author: Hui Xin
 * 14 Mar 2021
 */

public class TesterL2 {

    public static void main(String[] args) {

        //Q1();
        //Q2();
        //Q3();
        //Q4();
        Q5();
        //Q6();
    }

    public static void Q1() {
        StorePairGeneric<Integer> a = new StorePairGeneric<>(6, 4);
        StorePairGeneric<Integer> b = new StorePairGeneric<>(2, 2);
        StorePairGeneric<Integer> c = new StorePairGeneric<>(6, 3);

        System.out.println("a compare to b: " + a.compareTo(b));
        System.out.println("a compare to c: " + a.compareTo(c));
        System.out.println("b compare to c: " + b.compareTo(c));
        System.out.println("a equals to b: " + a.equals(b));
        System.out.println("a equals to c: " + a.equals(c));

    }

    public static void Q2() {

        MyGeneric<String> strObj = new MyGeneric<>("Hello");
        MyGeneric<Integer> intObj = new MyGeneric<>(2222);

        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
    }

    public static void Q3() {

        // maximum is static method
        System.out.println(CompareMax.maximum(4565, 66, 24546));
    }

    public static void Q4() {

        CompareMax<Integer> intArray = new CompareMax<>();

        Integer[] numArr = {5, 3, 7, 1, 4, 9, 8, 2};
        System.out.println(intArray.minmax(numArr) + " for intArray");

        CompareMax<String> strArr = new CompareMax<>();
        String[] str = {"red", "blue", "orange", "tan"};
        System.out.println(strArr.minmax(str) + " strArray");
    }

    public static void Q5() {

        Integer[] nums = {1, 2, 3};
        String[] str = {"red", "green", "blue"};

        FindMax findMax = new FindMax();
        FindMax.Circle[] r = new FindMax.Circle[3];

        r[0] = findMax.new Circle(3.0);
        r[1] = findMax.new Circle(2.9);
        r[2] = findMax.new Circle(5.9);

        System.out.println(findMax.max(nums));
        System.out.println(findMax.max(str));
        System.out.println(findMax.max(r));
    }

    public static void Q6() {

        MinMaxTwoDArray minMaxTwoDArray = new MinMaxTwoDArray();

        Integer[][] numbers = {{4, 5, 6}, {1, 2, 3}};
        System.out.println("Max number in the 2-D array: " + minMaxTwoDArray.max(numbers));

        System.out.println("Min number in the 2-D array: " + minMaxTwoDArray.min(numbers));
    }
}
