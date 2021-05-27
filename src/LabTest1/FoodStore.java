package LabTest1;

/*
 * Author: Hui Xin
 * 05 May 2021
 */

import java.util.Arrays;
import java.util.Objects;

public class FoodStore extends ShopLot implements Comparable<FoodStore>{

    private Item<String, Integer>[] menu;

    public FoodStore(String shopName) {
        super(shopName);
    }

    public FoodStore(Person contactPerson, Person[] employees, Item<String, Integer>[] menu) {
        super("Food Store", contactPerson, employees);
        this.menu = menu;
    }

    public void setMenu(Item<String, Integer>[] menu) {
        this.menu = menu;
    }

    @Override
    public int compareTo(FoodStore o) {

        return super.getEmployees().length - o.getEmployees().length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodStore foodStore = (FoodStore) o;
        return Objects.equals(super.getContactPerson(), foodStore.getContactPerson());
    }

    @Override
    public String toString() {
        return super.toString() +
                "menu=" + Arrays.toString(menu) +
                ", employees{" + Arrays.toString(super.getEmployees()) + "}";
    }
}
