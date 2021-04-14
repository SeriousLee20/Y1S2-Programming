package LabExercise.L6_21;

/*
 * Author: Hui Xin
 * 13 Apr 2021
 */

import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int x = in.nextInt();

        MyStack<Integer> stack = new MyStack<>();

        for (int i = 0; i < x; i++) {
            stack.push(1);
        }

        System.out.println(stack.getSize());

        do {
            System.out.println(stack.toString());
            stack.pop();
        } while (!stack.isEmpty());
    }
}
