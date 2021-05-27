package LabTest2;

/*
 * Author: Hui Xin
 * 06 May 2021
 */

import java.util.ArrayList;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String gender;
    private String occupation;
    private ArrayList<String> occupation_list = new ArrayList<>();
    private boolean frontLiner;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        setOccupation_list();
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        setOccupation_list();
    }

    public Person(String name, int age, String gender, String occupation) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        setOccupation_list();
    }

    public void setOccupation_list() {
        occupation_list.add("doctor");
        occupation_list.add("nurse");
        occupation_list.add("teacher");
        occupation_list.add("police");
    }

    public ArrayList<String> getOccupation_list() {
        return occupation_list;
    }

    public void setFrontLiner() {
        frontLiner = true;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean isFrontLiner() {
        return frontLiner;
    }

    @Override
    public int compareTo(Person o) {
        return this.getAge().compareTo(o.getAge());
    }
}

