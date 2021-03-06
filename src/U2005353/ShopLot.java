package U2005353;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

public class ShopLot {
    private String shopName;
    private Person contactPerson;
    private Person employees;
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

    public ShopLot(String shopName, Person contactPerson, Person employees) {
        this.shopName = shopName;
        this.contactPerson = contactPerson;
        this.employees = employees;
    }

    public Person getContactPerson() {
        return contactPerson;
    }

    public Person getEmployees() {
        return employees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
}
