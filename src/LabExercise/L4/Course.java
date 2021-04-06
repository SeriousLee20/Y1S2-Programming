package LabExercise.L4;

/*
 * Author: Hui Xin
 * 06 Mar 2021
 */

import java.text.DecimalFormat;

public class Course {

    String courseCode, courseName;
    int creditHours;
    char grade;
    LinkedList<String> dataList = new LinkedList<>();
    protected int sumCreditHours;
    protected int totalPoints;

    public Course() {
    }

    public Course(String courseCode, String courseName, int creditHours, char grade) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.grade = grade;
    }

    public void insertData(String courseCode, String courseName, int creditHours, char grade) {

        setCreditHours(creditHours);
        setGrade(grade);

        computeTotalCredit();
        computeTotalPoint();

        String data = "Course : " + courseCode + " (" + courseName + ") " +
                "- " + creditHours + " credit hours. Grade : " + grade;

        dataList.append(data);
    }

    public void computeTotalCredit() {
        sumCreditHours += creditHours;
    }

    public void computeTotalPoint() {
        int gradePoint = 0;

        switch (grade) {
            case 'A' -> gradePoint = 4;
            case 'B' -> gradePoint = 3;
            case 'C' -> gradePoint = 2;
            case 'D' -> gradePoint = 1;
            case 'F' -> gradePoint = 0;
        }

        //System.out.println(gradePoint + "*" + creditHours);
        totalPoints += gradePoint * creditHours;
    }

    public String GPA() {

        DecimalFormat df = new DecimalFormat("###.##");

        double GPA = (double) totalPoints / sumCreditHours;

        return df.format(GPA);
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }
}
