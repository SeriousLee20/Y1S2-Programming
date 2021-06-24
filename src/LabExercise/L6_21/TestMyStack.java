package LabExercise.L6_21;

/*
 * Author: Hui Xin
 * 13 Apr 2021
 */

public class TestMyStack {
    public static void main(String[] args) {
        //Q1();

        /*MyStack<Integer> numStack = new MyStack<>();

        for (int i = 1; i < 6; i++) {
            numStack.push(i);
        }

        Q3(numStack);*/

        //palindrome("madam");

    }

    public static void Q1() {
        MyStack<Character> stack = new MyStack<>();

        stack.push('a');
        stack.push('b');
        stack.push('c');

        System.out.println("Stack: " + stack);

        System.out.println("stack contains b: " + stack.search('b'));
        System.out.println("stack contains k: " + stack.search('k'));

        System.out.println();

        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        System.out.println("intStack: " + intStack.toString());
        System.out.println("intStack contains 6: " + intStack.search(6));
    }

    public static void Q3(MyStack<Integer> stack) {

        while(stack.getSize() > 1) {
            int x = stack.pop();
            int y = stack.pop();

            stack.push(x + y);
        }

        System.out.println("Sum: " + stack);

    }

    public static void palindrome(String str) {
        MyStack<Character> forward = new MyStack<>();
        MyStack<Character> backward = new MyStack<>();
        boolean isPalindrome = true;

        for (int i = 0; i < str.length(); i++) {
            forward.push(str.charAt(i));
        }

        for (int i = str.length() - 1; i > -1; i--) {
            backward.push(str.charAt(i));
        }

        while (!forward.isEmpty() && !backward.isEmpty()) {
            if (forward.pop() != backward.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("The string is a palindrome: " + isPalindrome);
    }

    public static void hanoiTower(int numOfDisk) {
    }
}
