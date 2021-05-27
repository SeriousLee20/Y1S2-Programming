package LabTest1;

/*
 * Author: Hui Xin
 * 05 May 2021
 */

public class FashionStore extends ShopLot {

    Item<String, Integer>[] clothes;

    public FashionStore(String shopName) {
        super(shopName);
    }

    public FashionStore(Person contactPerson, Person[] employees) {
        super("Fashion Store", contactPerson, employees);
    }

    public void setClothes(Item<String, Integer>[] clothes) {
        this.clothes = clothes;
    }
}
