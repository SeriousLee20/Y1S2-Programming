package LabTest1;

/*
 * Author: Hui Xin
 * 05 May 2021
 */

public class Person {

    private String name;
    private String contactNum;

    public Person(String name) {
        this.name = name;
        contactNum = null;
    }

    public Person(String name, String contactNum) {
        this.name = name;
        this.contactNum = contactNum;
    }

    public String getName() {
        return name;
    }

    public String getContactNum() {
        return contactNum;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", contactNum='" + contactNum + '\'' +
                '}';
    }
}
