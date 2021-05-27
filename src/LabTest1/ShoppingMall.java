package LabTest1;

/*
 * Author: Hui Xin
 * 05 May 2021
 */

public class ShoppingMall {
    public static void main(String[] args) {

        String[] names;
        String[] foods;
        int[] price;
        Person[] employees;
        Item<String, Integer>[] itemList;
        Person contact;

        ShopLot[] foodStores = {new FoodStore("McDonalds"),
        new FoodStore("Shushi Mentai"), new FoodStore("Waroeng Penyet")};

        //McD
        contact = createContact("Mike", "0101122334");

        names = new String[]{"Jack", "Jane"};
        employees = createEmployees(names);

        foods = new String[]{"Burger", "Fried Chicken"};
        price = new int[]{12, 10};

        itemList = createItem(foods, price);

        createFoodShopLot(foodStores[0], contact, employees, itemList);
        System.out.println(foodStores[0]);

        //sushi
        contact = createContact("Max", "0112233445");

        names = new String[]{"Adam", "Alex", "Andrew"};
        employees = createEmployees(names);

        foods = new String[]{"Chicken Katsu Don", "Ramen"};
        price = new int[]{12, 10};

        itemList = createItem(foods, price);

        createFoodShopLot(foodStores[1], contact, employees, itemList);

        System.out.println(foodStores[1]);

        System.out.println(((FoodStore) foodStores[0]).compareTo((FoodStore) foodStores[1]));
    }

    public static ShopLot createFoodShopLot(ShopLot shopLot, Person contactPerson, Person[] employees, Item<String, Integer>[] itemList) {
        shopLot.setEmployees(employees);
        shopLot.setContactPerson(contactPerson);

        if(shopLot instanceof FoodStore)
            ((FoodStore) shopLot).setMenu(itemList);

        else if(shopLot instanceof FashionStore)
            ((FashionStore) shopLot).setClothes(itemList);

        return shopLot;
    }

    public static Person createContact(String name, String contactNum) {
        return new Person(name, contactNum);
    }

    public static Person[] createEmployees(String[] name) {
        Person[] employees = new Person[name.length];

        for (int i = 0; i < name.length; i++) {
            employees[i] = new Person(name[i]);
        }
        return employees;
    }

    public static Item<String, Integer>[] createItem(String[] itemList, int[] priceList) {
        Item<String, Integer>[] items = new Item[itemList.length];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item<>(itemList[i], priceList[i]);
        }
        return items;
    }
}
