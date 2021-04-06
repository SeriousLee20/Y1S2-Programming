package LabExercise.L1;

/*
 * Author: Hui Xin
 * 19 Feb 2021
 */

public abstract class Banner {

    public abstract void print(char c);
}

class AtoG extends Banner {
    @Override
    public void print(char c) {
        switch (c) {
            case 'A':
                System.out.println("     *\n" +
                        "    *  *\n" +
                        "   *    *\n" +
                        "  ********\n" +
                        " *        *\n" +
                        "*          *\n");
            case 'B':
                System.out.println("    ***\n" +
                                   "   *           *\n" +
                                    "*           *" +
                        "*      *" +
                        "*      *" +
                        "*     *" +
                        "*    *" +
                        "*   *" +
                        "* *" +
                        "* *" +
                        "*  *" +
                        "*   *");
        }



    }
}
