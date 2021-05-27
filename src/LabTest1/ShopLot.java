package LabTest1;

/*
 * Author: Hui Xin
 * 05 May 2021
 */

import java.util.Arrays;

public class ShopLot {

    private String shopName;
    private Person contactPerson;
    private Person[] employees;
    private int numberOfEmployees;

    public ShopLot() {
    }

    public ShopLot(String shopName) {
        this.shopName = shopName;
    }

    public ShopLot(String shopName, Person contactPerson) {
        this.shopName = shopName;
        this.contactPerson = contactPerson;
    }

    public ShopLot(String shopName, Person contactPerson, Person[] employees) {
        this.shopName = shopName;
        this.contactPerson = contactPerson;
        this.employees = employees;
        numberOfEmployees = employees.length;
    }

    public void setContactPerson(Person contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public void setEmployees(Person[] employees) {
        this.employees = employees;
    }

    public Person[] getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "ShopLot{" +
                "shopName='" + shopName + '\'' +
                ", contactPerson=" + contactPerson;
    }
}
