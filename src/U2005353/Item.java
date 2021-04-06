package U2005353;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

public class Item<A, B> {
    private A item;
    private B price;

    public Item(A item, B price) {
        this.item = item;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item=" + item +
                ", price=" + price +
                '}';
    }
}
