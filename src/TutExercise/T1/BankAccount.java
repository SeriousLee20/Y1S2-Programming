package TutExercise.T1;

/*
 * Author: Hui Xin
 * 11 Mar 2021
 */

public class BankAccount implements Account {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(int x) {
        balance += x;
    }

    @Override
    public boolean withdraw(int y) {
        if (y <= balance) {
            balance -= y;
            return true;
        }
        return false;
    }
}
