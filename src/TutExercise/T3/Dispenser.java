package TutExercise.T3;

/*
 * Author: Hui Xin
 * 23 Mar 2021
 */

enum Item {

    Candy(100, 1.00), Chip(50, 2.00),
    Gum(100, 0.50), Cookies(50, 2.00);

    private int stockLeft;
    private double price;

    Item(int stockLeft, double price) {
        this.stockLeft = stockLeft;
        this.price = price;
    }

    public int getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class Dispenser implements DispenserInt{

    private int stockLeft;
    private Item item;
    private double price;
    public Dispenser() {
    }

    public Dispenser(Item item) {
        getStockLeft(item);
    }

    public void dispense() {
        item.setStockLeft(stockLeft--);
    }

    public void addStock(int number) {
        item.setStockLeft(stockLeft + number);
    }

    public Item itemName(int code) {

        switch (code) {
            case 1 -> item = Item.Candy;
            case 2 -> item = Item.Chip;
            case 3 -> item = Item.Gum;
            default -> item = Item.Cookies;
        };
        return item;
    }

    public void getStockLeft(Item item) {
        stockLeft = item.getStockLeft();
    }

    public boolean available(Item item) {
        return stockLeft > 0;
    }
}
