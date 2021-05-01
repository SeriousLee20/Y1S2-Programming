package LabExercise.Stack_Extra;

/*
 * Author: Hui Xin
 * 02 May 2021
 */

import LabExercise.L6_21.MyStack;

public class InfixPostFixPrefix {

    public void InfixToPostFix(String expression) {

        MyStack<Character> operator = new MyStack<>();

        expression = expression.replaceAll("\s+", "");
        String postFix = "";

        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);

            if (!Character.isLetterOrDigit(current)) {
                if (operator.isEmpty() || current == '(') {
                    operator.push(current);
                } else {

                    if (current == ')') {
                        while (operator.peek() != '(') {
                            postFix += operator.pop();
                        }
                        operator.pop();
                        continue;
                    }

                   while (!operator.isEmpty() && higherEqualPrecedence(operator.peek(), current)) {
                       postFix += operator.pop();
                    }
                    operator.push(current);
                }
            } else {
                postFix += current;
            }
        }

        while (!operator.isEmpty()) {
            postFix += operator.pop();
        }

        System.out.println("Post Fix: " + postFix);
    }


    public boolean higherEqualPrecedence(char prev, char current) {

        if ((prev == '*' || prev == '/' || prev == '%') && (current == '-' || current == '+') )
            return true;

        if ((prev == '-' || prev == '+') && (current == '-' || current == '+')) {
            return true;
        }

        if ((prev == '*' || prev == '/' || prev == '%') && (current == '*' || current == '/' || current == '%')) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        InfixPostFixPrefix one = new InfixPostFixPrefix();

        one.InfixToPostFix("((1+2)*3-4)*5");
        one.InfixToPostFix("((A+B)*C-D)*E");
        one.InfixToPostFix("A*(B+C)");
    }
}
