package TutExercise.T3;

/*
 * Author: Hui Xin
 * 23 Mar 2021
 */

import LabExercise.L3_21.BagInterface;
import LabExercise.L3_21.ArrayBag;

enum Coin{

    $5Cent(2, 10), $10Cent(10, 10),
    $20Cent(20, 10), $50Cent(50, 10);

    private int value;
    private int stock;

    Coin(int value, int stock) {
        this.value = value;
        this.stock = stock;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }
}

public class CashRegister implements CashRegisterInt{

    private double toPay;
    private double amountPaid;
    BagInterface<Integer> coinBag = new ArrayBag<>();
    private int $5cent = 0, $10cent = 0, $20cent = 0, $50cent = 0;

    public CashRegister() {
    }

    public CashRegister(double toPay) {
        this.toPay = toPay * 100;
    }

   /* public void setToPay(double toPay) {
        this.toPay = toPay;
    }
*/
    public void acceptCoin(int coinValue) {

        Coin coin;

        coinBag.add(coinValue);

        amountPaid += coinValue;

        switch (coinValue) {
            case 5:
                coin = Coin.$5Cent;
                break;
            case 10:
                coin = Coin.$10Cent;
                break;
            case 20:
                coin = Coin.$20Cent;
                break;
            default:
                coin = Coin.$50Cent;
                break;
        }

        coin.setValue(coin.getStock() + 1);

    }

    public boolean checkFullPaid() {
        return amountPaid >= toPay;
    }

    public boolean checkEnoughChange() {
        double change = amountPaid - toPay;
        double temp = change;

        int available50Cent = Coin.$50Cent.getStock();
        int available20Cent = Coin.$20Cent.getStock();
        int available10Cent = Coin.$10Cent.getStock();
        int available5Cent = Coin.$5Cent.getStock();

        if (change == 0) {
            System.out.println("Amount paid is correct. " +
                    "Thank you for purchasing. " +
                    "Please collect your item.");
            return false;
        }

        System.out.println("Please wait for the change.");
        while (change != 0 && change % 50 == 0 && available50Cent > 0) {
            $50cent++;
            change -= 50;
            available50Cent--;
        }

        while (change != 0 && change % 20 == 0 && available20Cent > 0) {
            $20cent ++;
            change -= 20;
            available20Cent--;
        }

        while (change != 0 && change % 10 == 0 && available10Cent > 0) {
            $10cent ++;
            change -= 10;
            available10Cent--;
        }

        while (change != 0 && change % 5 == 0 && available5Cent > 0) {
            $5cent++;
            change -= 5;
            available5Cent--;
        }

        if (change != 0) {
            System.out.println("Not enough coins for the change. Amount paid is refunded.");
            $5cent = coinBag.getFrequencyOf(5);
            $10cent = coinBag.getFrequencyOf(10);
            $20cent = coinBag.getFrequencyOf(20);
            $50cent = coinBag.getFrequencyOf(50);

            Coin.$5Cent.setStock(Coin.$5Cent.getStock() - $5cent);
            Coin.$10Cent.setStock(Coin.$10Cent.getStock() - $10cent);
            Coin.$20Cent.setStock(Coin.$20Cent.getStock() - $20cent);
            Coin.$50Cent.setStock(Coin.$50Cent.getStock() - $50cent);
            return false;
        }


        System.out.printf("RM %.2f is returned.", temp/100.0);
        Coin.$5Cent.setStock(Coin.$5Cent.getStock() + $5cent);
        Coin.$10Cent.setStock(Coin.$10Cent.getStock() + $10cent);
        Coin.$20Cent.setStock(Coin.$20Cent.getStock() + $20cent);
        Coin.$50Cent.setStock(Coin.$50Cent.getStock() + $50cent);
        return true;
    }

    public void newDeal() {
        coinBag.clear();
    }

}
