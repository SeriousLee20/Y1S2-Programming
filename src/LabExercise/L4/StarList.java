package LabExercise.L4;

/*
 * Author: Hui Xin
 * 07 Mar 2021
 */

import LabExercise.L1.Time;

import java.util.Random;

public class StarList {
    int stars;
    String player;
    LinkedList<Character> starList = new LinkedList<>();

    public StarList(String player) {
        this.player = player;
    }

    public boolean playGame() {

        int dice = rollDice();
        //System.out.println(dice);
        addStars(dice);

        if (stars > 20) {
            System.out.println(player + " wins the game.");
            return false;
        }
        return true;
    }

    public int rollDice() {
        Random rnd = new Random();
        return rnd.nextInt(6) + 1;
    }

    public void addStars(int dice) {

        stars += dice;

        for (int i = 0; i < dice; i++) {
            starList.append('*');
        }

        System.out.print(player + ": ");
        starList.printList(starList.head);
    }
}
