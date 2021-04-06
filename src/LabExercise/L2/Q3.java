package LabExercise.L2;

/*
 * Author: Hui Xin
 * 20 Feb 2021
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Q3 {

    abstract class ADT {
        abstract void draw();
    }

    class ArrayUno extends ADT{
        private String[] colour = {"Yellow", "Green", "Red", "Blue", "Pick Colour"};
        private String[] func = {"Zero", "One", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                "Draw Two", "Draw Four", "Reverse", "Skip"};
        private int numOfDraw;
        private String player;
        private String card;

        public ArrayUno(int numOfDraw, String player) {
            this.numOfDraw = numOfDraw;
            this.player = player;
        }

        @Override
        void draw() {
            Random rnd = new Random();

            System.out.println("\nArray Implementation");
            System.out.println(player + " draws " + numOfDraw + " times ");

            for (int i = 0; i < numOfDraw; i++) {

                card = "";
                int color = rnd.nextInt(5);
                int name = rnd.nextInt(13);

                if (color == 4) {
                    card += colour[color];
                } else {
                    card += colour[color] + " " + func[name];
                }

                System.out.print(toString());
            }
        }

        public String toString() {
            return card + " :: ";
        }
    }

    public class LinkedListUno extends ADT {
        private LinkedList<String> colorList = new LinkedList<>();

        private LinkedList<String> funcList = new LinkedList<>();

        private int numOfDraw;
        private String player;

        private String card;

        public LinkedListUno(int numOfDraw, String player) {
            this.numOfDraw = numOfDraw;
            this.player = player;
            setColorList();
            setFuncList();
        }

        public void setColorList() {
            String[] colour = {"Yellow", "Green", "Red", "Blue", "Pick Colour"};
            colorList.addAll(Arrays.asList(colour));
        }

        public LinkedList<String> getColorList() {
            return colorList;
        }

        public LinkedList<String> getFuncList() {
            return funcList;
        }

        public void setFuncList() {
            String[] func = {"Zero", "One", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                    "Draw Two", "Draw Four", "Reverse", "Skip"};
            funcList.addAll(Arrays.asList(func));
        }

        @Override
        void draw() {

            System.out.println("\nLinked List Implementation");
            System.out.println(player + " draws " + numOfDraw + " times ");

            Random rnd = new Random();

            for (int i = 0; i < numOfDraw; i++) {
                card = "";

                int color = rnd.nextInt(5);
                int func = rnd.nextInt(13);

                if (color == 4) {
                    card += colorList.get(color);
                } else {
                    card += colorList.get(color) + " " + funcList.get(func);
                }
                System.out.print(toString());
            }
        }

        public String toString() {
            return card + " :: ";
        }
    }

    public static void main(String[] args) {

        Q3 q3 = new Q3();


        Q3.ArrayUno arrayP1 = q3.new ArrayUno(7, "Player 1");
        arrayP1.draw();

        Q3.ArrayUno arrayP2 = q3.new ArrayUno(7, "Player 2");
        arrayP2.draw();

        System.out.println();

        Q3.LinkedListUno listP1 = q3.new LinkedListUno(7, "Player 1");
        Q3.LinkedListUno listP2 = q3.new LinkedListUno(7, "Player 2");

        listP1.draw();
        listP2.draw();
    }
}
