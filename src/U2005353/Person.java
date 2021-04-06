package U2005353;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

import java.util.Arrays;

public class Person {

    private String[] name;
    private String contactNumber;
    private String nameContact;

    public Person() {
    }

    public Person(int numOfEmployee, String[] name) {
        name = new String[numOfEmployee];
        this.name = name;
    }

    public Person(String nameContact, String contactNumber) {
        this.nameContact = nameContact;
        this.contactNumber = contactNumber;
    }

    public String[] getName() {
        return name;
    }

    public String toStringEmployee() {
        return "Person{" +
                "name=" + Arrays.toString(name) +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + Arrays.toString(name) +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
