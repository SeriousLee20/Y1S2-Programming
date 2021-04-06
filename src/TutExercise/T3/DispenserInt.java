package TutExercise.T3;

public interface DispenserInt {

    /**minus stock number with 1 if deal is successful*/
    void dispense();

    /**add new stock
     * @param number is added to the current stock number*/
    void addStock(int number);

    /**get the item name
     * @code is the code for item
     * @return Item based on the code*/
    Item itemName(int code);

    /**get the number of stock left
     * @param item is the object of Item enum class*/
    void getStockLeft(Item item);

    /**check the availability of the item
     * @return true if available, else false*/
    boolean available(Item item);
}
