package PYQ;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

public class Tester {
    public static void main(String[] args) {
        CourseRegistrationSystem ds = new CourseRegistrationSystem("Data Structure", "WIX3003", 10);
        ds.addStud(new Student("Ali", 2));
        ds.addStud(new Student("Brandon", 3));
        ds.addStud(new Student("Charles", 3));
        ds.addStud(new Student("Ben", 3));
        ds.addStud(new Student("Erick", 1));
        ds.addStud(new Student("Jack", 2));
        ds.addStud(new Student("Ram", 3));
        ds.addStud(new Student("James", 1));
        ds.addStud(new Student("Danish", 2));
        ds.addStud(new Student("Tan", 2));
        ds.addStud(new Student("Moon", 3));
        ds.addStud(new Student("Yusof", 3));
        ds.addStud(new Student("Zed", 3));
        ds.addStud(new Student("Jun", 2));
        ds.addStud(new Student("Yeoh", 3));

        System.out.println(ds.toString());
    }
}
