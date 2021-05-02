package LabExercise.Stack_Extra;

/*
 * Author: Hui Xin
 * 02 May 2021
 */

import LabExercise.L6_21.MyStack;

public class InfixPostFixPrefix {

    public String InfixToPostFix(String expression) {

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
        return postFix;
    }


    public String infixToPrefix(String expression) {

        StringBuilder exp = reverse(expression);

        for (int i = 0; i < expression.length(); i++) {
            if (exp.charAt(i) == '(') {
                exp = exp.replace(i, i + 1, ")");
                i++;
            } else if (exp.charAt(i) == ')') {
                exp = exp.replace(i, i + 1, "(");
                i++;
            }
        }

        String prefix = InfixToPostFix(exp.toString());
        prefix = reverse(prefix).toString();
        System.out.println("Prefix: " + prefix);
        return prefix;
    }

    public StringBuilder reverse(String exp) {

        StringBuilder reverse = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            reverse.append(exp.charAt(i));
        }

        return reverse.reverse();
    }
    public boolean higherEqualPrecedence(char prev, char current) {

        if ((prev == '*' || prev == '/' || prev == '%') && (current == '-' || current == '+') )
            return true;

        /*if ((prev == '-' || prev == '+') && (current == '-' || current == '+')) {
            return true;
        }*/

        /*if ((prev == '*' || prev == '/' || prev == '%') && (current == '*' || current == '/' || current == '%')) {
            return true;
        }*/

        return false;
    }


    public double calcPostFix(String postfixExp) {

        MyStack<Double> operands = new MyStack<>();

        for (int i = 0; i < postfixExp.length(); i++) {

            char current = postfixExp.charAt(i);

            if (Character.isDigit(current)) {
                String temp = String.valueOf(current);
                operands.push(Double.parseDouble(temp));

            } else {

                double y = operands.pop();
                double x = operands.pop();
                operands.push(operations(x, y, current));
            }
        }

        return operands.pop();
    }

    public double operations(double x, double y, char operator) {

        switch (operator) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '%':
                return x % y;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        InfixPostFixPrefix one = new InfixPostFixPrefix();

        String exp1 =  one.InfixToPostFix("((1+2)*3-4)*5");
        one.InfixToPostFix("((A+B)*C-D)*E");
        one.InfixToPostFix("A*(B+C)");

        System.out.println(one.calcPostFix(exp1));

        one.infixToPrefix("A * B + C / D");

        one.infixToPrefix("(A - B/C) * (A/K-L)");
        one.infixToPrefix("x+y*z/w+u");
    }
}
