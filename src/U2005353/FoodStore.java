package U2005353;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

import java.util.Arrays;

public class FoodStore extends ShopLot implements Comparable<FoodStore> {

    private Item<String, Integer>[] menu;

    public FoodStore(String shopNames, Person contactPerson, Person employee, Item<String, Integer>[] menu) {
        super(shopNames, contactPerson, employee);

        this.menu = menu;
    }

    @Override
    public int compareTo(FoodStore o) {
        Person p = new Person();
        return getEmployees().getName().length - o.getEmployees().getName().length;
    }

    @Override
    public boolean equals(Object o) {

        if (this.getClass() != o.getClass()) {
            return false;
        }

        ShopLot that = (ShopLot) o;
        return getContactPerson() == ((ShopLot) o).getContactPerson();
    }

    @Override
    public String toString() {
        return "FoodStore{" +
                "menu=" + Arrays.toString(menu) +
                '}';
    }
}
