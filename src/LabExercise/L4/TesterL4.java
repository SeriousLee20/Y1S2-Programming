package LabExercise.L4;

/*
 * Author: Hui Xin
 * 28 Feb 2021
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TesterL4 {

    public static void main(String[] args) {
        //Q1();
        //Q2();
        //Q3();
        //Q4();
        //Q5();
        Q6();
    }

    public static void Q1() {

        Random rnd = new Random();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();

        int[] num = new int[10];

        for (int i = 0; i < num.length; i++) {
            num[i] = rnd.nextInt(101);
        }

        System.out.print("The random numbers are : ");

        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        System.out.println("Insert the random numbers at the back of the linked list");

        for (int i : num) {
            list.append(i);
        }

        list.printList();
        System.out.println();

        for (int i : num) {
            list2.prepend(i);
        }

        System.out.println("Insert the random numbers in front of the linked list");
        list2.printList();
        System.out.println();

        for (int i : num) {
            list3.addSortNode(i);
        }

        System.out.println("Insert the random numbers in a sorted linked list");
        list3.printList();
        System.out.println();

        //System.out.println(list.isEmpty());

        System.out.println("Length of list: " + list.length());

        list.getBack();
        System.out.println();

        list.addNodeByPosition(6, 9);
        list.printList();

        list.deleteNodeByPosition(8);
        list.printList();

        list.replaceFront(2);
        list.printList();

        list.getFront();
        System.out.println();

        list.replace(10, 3);
        list.printList();

        list.get(5);

        list.contains(10);

        list.clearList();
        list.printList();
    }

    public static void Q2() {
        Scanner in = new Scanner(System.in);
        LinkedList<Character> charList = new LinkedList<>();

        System.out.print("Enter a word : ");
        String str = in.next();

        for (int i = 0; i < str.length(); i++) {
            charList.append(str.charAt(i));
        }

        System.out.print("The original list : ");
        charList.printList();

        //charList.splitList();

        ListNode[] list = charList.alternateSplit(charList.head);
        System.out.print("First list : ");
        charList.printList(list[0]);

        System.out.print("Second list : ");
        charList.printList(list[1]);

        charList = charList.mergeList(list[0], list[1]);
        charList.printList();

        System.out.println("Reverse the list. Recursive method in the LinkedList");
        ListNode<Character> reversed = charList.reverseList(charList.head);
        charList.printList(reversed);

        System.out.println("Reverse the list. Recursive method in tester class");
        Q2Reverse(charList.head);
        charList.printList(reversed);
    }

    public static ListNode<Character> Q2Reverse(ListNode<Character> current) {

        if (current == null || current.next == null) {
            return current;
        }

        ListNode<Character> temp = Q2Reverse(current.next);

        current.next.next = current;
        current.next = null;

        return temp;
    }

    public static void Q3() {

        Course stud1 = new Course();
        stud1.insertData("WXX101", "Programming", 5, 'B');
        stud1.insertData("WXX201", "Networking", 4, 'C');
        stud1.insertData("WXX301", "Operating System", 3, 'A');

        System.out.println("The list consist of ");
        stud1.dataList.printListSpaceArrow();

        System.out.println("Total point is " + stud1.totalPoints);
        System.out.println("Total credit is " +stud1.sumCreditHours);
        System.out.println("Grade point average is " + stud1.GPA());
    }

    public static void Q4() {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int numPlayer = in.nextInt();
        StarList[] player = new StarList[numPlayer];

        in.nextLine();

        for (int i = 0; i < player.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            player[i] = new StarList(in.nextLine());
        }

        int[] temp = new int[player.length];

        for (int i = 0; i < player.length; i++) {
            temp[i] = player[i].rollDice();
        }

        for (int i = 0; i < player.length; i++) {
            System.out.println(player[i].player + ": " + temp[i]);
        }

        // rearrange the position of the players based on dice values
        for (int i = 0; i < temp.length; i++) {
            for (int j = i; j < temp.length - 1; j++) {
                if (temp[j] < temp[j + 1]) {
                    StarList t = player[j];
                    player[j] = player[j + 1];
                    player[j + 1] = t;
                }
            }
        }

        System.out.println(player[0].player + " start first");

        boolean noWin = true;

        while (noWin) {

            for (int i = 0; i < player.length; i++) {
                noWin = player[i].playGame();

                if (!noWin) {
                    break;
                }
            }
        }
    }

    public static void Q5() {

        LinkedList<String> str = new LinkedList<>();
        String[] arr = {"ARS", "CHE", "LEI", "MAN", "LIV", "TOT"};

        for(String i : arr)
            str.append(i);

        System.out.print("The list consists of ");
        str.printList();

        LinkedList<String>.LinkedListIterator linkedListIterator = str.new LinkedListIterator();

        System.out.println("Remove all the word that consists of the A character using iterator.");
        while (linkedListIterator.hasNext()) {
            String node = linkedListIterator.next();
            //System.out.println("Current node: " + node);
            if (node.contains("A")) {
                str.deleteNode(node);
            }
        }

        System.out.print("The updated list consists of ");
        str.printList();
    }

    public static void Q6() {

        Random rnd = new Random();

        DoubleLinkedList<Integer> num = new DoubleLinkedList<>();

        for (int i = 0; i < 10; i++) {
            num.append(rnd.nextInt(101));
        }

        System.out.println("Original list: ");
        num.printList();

        System.out.println("\nRemove number at the third position (index 2): ");
        num.deleteByPosition(2);
        num.printList();

        //num.addByPosition(6, 999);
        num.replace(6, 999);

        System.out.println("\nReplace number in 7th position with 999 (index 6): ");
        num.printList();

        for (int i = 0; i < num.length();) {
            int temp = num.getData(i);
            if (temp % 2 == 0 && temp != 0) {
                num.deleteByPosition(i);
            } else
                i++;
        }

        System.out.println("\nRemove all even numbers: ");
        num.printList();
    }
}
