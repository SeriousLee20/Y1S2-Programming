package Testss;

/*
 * Author: Hui Xin
 * 30 Apr 2021
 */

import java.util.*;

public class TesterOnly {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("D");
        list.add(1);
        m(list);

        /*float f = 5.2;
        char c = 2.2;
        byte b = 256;
        boolean b = False;
        double d = 1.8;*/

        int i = 1;
        switch (i) {
            default -> System.out.println("default");
            case 0 -> System.out.println("zero");
            case 1-> System.out.println("one");
            case 2 -> System.out.println("two");

        }

        Stack<Integer> stack1 = new Stack<>();
        int n = 12;
        while (n > 0) {
            stack1.push(n % 2);
            n = n / 2;
        }
        String result = "";
        while (!stack1.isEmpty()) {
            result += stack1.pop();
        }

        System.out.println(result);

        LinkedList<Object> list1 = new LinkedList<>();

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int j = 1; j <= 9; j += 2) {
            queue.add(j);
        }

        while ((!queue.isEmpty())) {
            stack2.add(queue.poll());
        }

        while (!stack2.isEmpty()) {
            queue.add(stack2.pop());
        }


        System.out.println(queue);

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        System.out.println(intList);

        Stack<Integer> stack = new Stack<>();
        for (int j = 0; j < 10; j++) {
            stack.push(++j);

            stack.pop();
            stack.pop();
            stack.pop();
        }

        Integer x = stack.peek();
        System.out.println(x);
    }


    private static void m(List list) {
        System.out.println(list);
    }
}
