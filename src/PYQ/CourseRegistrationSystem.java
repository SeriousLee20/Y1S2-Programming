package PYQ;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

import LabExercise.L4.Course;

public class CourseRegistrationSystem {

    private MyArrayList<Student> confirmedList;
    private MyArrayList<Student> waitingList;
    private MyArrayList<Student> registeredList;

    private int maxStud;
    private String course;
    private String courseCode;
    private int registeredNum;

    public CourseRegistrationSystem(String course, String courseCode, int maxStud) {
        confirmedList = new MyArrayList<>(maxStud);
        waitingList = new MyArrayList<>(2000);
        registeredList = new MyArrayList<>(2000);
        this.course = course;
        this.courseCode = courseCode;
        this.maxStud = maxStud;
    }

    public void addStud(Student stud) {
        registeredList.add(stud);
        registeredNum++;

        System.out.println(stud + " register to the course");

        if (confirmedList.getExistingEntries() == maxStud) {
            boolean replaced = false;

            if (stud.getYearOfStudy() >= courseYearOfStudy()) {
                for (int i = confirmedList.getExistingEntries() - 1; i > -1; i++) {
                    if (confirmedList.getFromIndex(i).getYearOfStudy() < courseYearOfStudy()) {

                        waitingList.addToIndex(confirmedList.getFromIndex(i), 0);
                        confirmedList.removeFromIndex(i);
                        confirmedList.add(stud);
                        replaced = true;
                        break;
                    }
                }

                if (!replaced) {
                    for (int i = 0; i < waitingList.getSize(); i++) {
                        if (waitingList.getFromIndex(i).getYearOfStudy() < stud.getYearOfStudy())
                            waitingList.addToIndex(stud, i - 1);
                    }
                }
            } else {
                waitingList.add(stud);
            }
        }

        confirmedList.add(stud);
    }

    public int courseYearOfStudy() {
        return Integer.parseInt(String.valueOf(courseCode.charAt(3)));
    }



    @Override
    public String toString() {

        System.out.println("Course: " + course);
        System.out.println("Course Code: " + courseCode);

        System.out.println("\nConfirmed list:");
        for (int i = 0; i < confirmedList.getExistingEntries(); i++) {
            System.out.println(confirmedList.getFromIndex(i) + ", ");
        }

        System.out.println("\nWaiting list: ");
        for (int i = 0; i < waitingList.getExistingEntries(); i++) {
            System.out.println(waitingList.getFromIndex(i) + ", ");
        }
        return "";
    }
}
