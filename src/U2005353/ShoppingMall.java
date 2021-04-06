package U2005353;

/*
 * Author: Hui Xin
 * 01 Apr 2021
 */

public class ShoppingMall {
    public static void main(String[] args) {
        ShopLot[] foodStores = new FoodStore[3];

        Item<String, Integer>[] mcD = new Item[]{new Item("Burger", 10), new Item("Fried Chicken", 12)};
        Item<String, Integer>[] sushiMentai = new Item[]{new Item("Chicken Katsu Don", 15), new Item("Ramen", 12)};
        Item<String, Integer>[] waroeng = new Item[]{new Item("Ayam Penyet", 10)};

        Person[] contactFoodStore = {new Person("Mike", "0101122334"), new Person("Max", "0112233445")};
        Person[] employees = new Person[]{new Person(2, new String[]{"Jack", "Jane"}),
                new Person(3, new String[]{"Adam", "Alex", " Andrew"}),
                new Person(2, new String[]{"Lex", "Leon"})};

        foodStores[0] = new FoodStore("McDonalds", contactFoodStore[0], employees[0], mcD);
        foodStores[1] = new FoodStore("Shushi Mentai", contactFoodStore[1], employees[1], sushiMentai);
        foodStores[2] = new FoodStore("Waroeng Penyet", contactFoodStore[0], employees[2], waroeng);

        ShopLot[] fashionStores = new FashionStore[3];

        Item<String, Integer>[] uniqlo = new Item[]{new Item("Shirt", 80), new Item("T-shirt0", 60)};
        Item<String, Integer>[] padini = new Item[]{new Item("Blouse", 100), new Item("Skirt", 80)};
        Item<String, Integer>[] mango = new Item[]{new Item("Dress", 120)};
        Person[] contactFashionStore = {new Person("Nate", "0199987765"), new Person("Nick", "0195544332"), new Person("Nicole", "0194433221")};
        Person[] employeesFashion = new Person[]{new Person(2, new String[]{"Kate", "Ken", "Kurt"}),
                new Person(2, new String[]{"Frank", "Felix"}),
                new Person(2, new String[]{"Ron", "John"})};

        fashionStores[0] = new FashionStore("Uniqlo", contactFashionStore[0], employeesFashion[0], uniqlo);
        fashionStores[1] = new FashionStore("Padini", contactFashionStore[1], employeesFashion[1], padini);
        fashionStores[2] = new FashionStore("Mango", contactFashionStore[2], employeesFashion[2], mango);

        System.out.println(foodStores[1].toString());
        System.out.println(fashionStores[2].toString());

        for (int i = 0; i < foodStores.length; i++) {
            for (int j = 1; j < foodStores.length; j++) {
                if (foodStores[i].getContactPerson().equals(foodStores[j].getContactPerson())) {
                    System.out.println(foodStores[i] + " " + foodStores[j] + " have same contact person");
                }
            }
        }

        for (int i = 0; i < fashionStores.length; i++) {
            for (int j = 1; j < fashionStores.length; j++) {
                if (fashionStores[i].getContactPerson().equals(fashionStores[j].getContactPerson())) {
                    System.out.println(foodStores[i] + " " + fashionStores[j] + " have same contact person");
                }
            }
        }
        mostEmployee(foodStores);
        System.out.println();
        mostEmployee(fashionStores);
    }

    public static void mostEmployee(ShopLot[] shopLot) {
        ShopLot max = shopLot[1];
        for (int i = 0; i < shopLot.length - 1; i++) {
            if (shopLot[i + 1].getEmployees().getName().length > shopLot[i].getEmployees().getName().length) {
                max = shopLot[i + 1];
            }
        }
        System.out.println(max + " has the most employees");
    }
}
