package PYQ;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

public class Student {

    private String name;
    private int yearOfStudy;

    public Student(String name, int yearOfStudy) {
        this.name = name;
        this.yearOfStudy = yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Student: %-11s Year of Study: %d", name, yearOfStudy);
    }
}
