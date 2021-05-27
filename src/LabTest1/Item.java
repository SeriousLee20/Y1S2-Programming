package LabTest1;

/*
 * Author: Hui Xin
 * 05 May 2021
 */

public class Item<A, B> {

    private String item;
    private int price;

    public Item(String item, int price) {
        this.item = item;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                ", price=" + price +
                '}';
    }
}
