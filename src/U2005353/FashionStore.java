package U2005353;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

import java.util.Arrays;

public class FashionStore extends ShopLot {

    private Item<String, Integer>[] clothes;

    public FashionStore(String shopNames, Person contactPerson, Person employee, Item<String, Integer>[] clothes) {
        super(shopNames, contactPerson, employee);

        this.clothes = clothes;
    }

    @Override
    public String toString() {
        return "FashionStore{" +
                "clothes=" + Arrays.toString(clothes) +
                '}';
    }
}
