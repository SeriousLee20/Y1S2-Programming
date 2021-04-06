package TutExercise.T3;

/*
 * Author: Hui Xin
 * 23 Mar 2021
 */

public interface CashRegisterInt {

    /**accept coin if the stock is available and while the total is not enough
     * @param coinValue is the value of coin inserted by buyer*/
    void acceptCoin(int coinValue);

    /**check if the amount paid is enough
     * @return true if amount is enough, else false*/
    boolean checkFullPaid();

    /**check if the coin stock is enough for change
     * dedicated number of diff coin values will be deducted from the coin stock if enough for change
     * else the amount paid will be refunded (not added to the coin stock)
     * @return true if enough, else false*/
    boolean checkEnoughChange();

    /**clear the coin bag when the deal ends*/
    void newDeal();
}
