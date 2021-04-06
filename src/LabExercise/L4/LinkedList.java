package LabExercise.L4;

/*
 * Author: Hui Xin
 * 23 Feb 2021
 */

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Comparable<LinkedList> {

    ListNode<T> head;

    public void append(T data) {

        ListNode<T> newNode = new ListNode<>(data);
        newNode.next = null;

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // delete last node
    public void pop() {

        if (head == null) {
            System.out.println("The list is empty");
            return;
        }

        ListNode<T> current = head;
        ListNode<T> previous = head;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;

        System.out.println("Last node is deleted.");
    }

    public void prepend(T data) {

        ListNode<T> newNode = new ListNode<>(data);

        newNode.next = head;

        head = newNode;
    }

    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("The list is empty. No node is deleted.");
            return;
        }
        head = head.next;

        System.out.println("First node is deleted.");
    }

    public void clearList() {
        head = null;
        System.out.println("The list is cleared.");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int length() {
        if (isEmpty()) {
            return 0;
        }

        ListNode<T> current = head;

        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        //System.out.println("The length of the list: " + count);
        return count;
    }

    public void contains(T data) {

        ListNode<T> current = head;

        int count = 0;
        while (current != null) {

            if (current.data.equals(data)) {
                System.out.println(data + " is found at index " + count);
                return;
            }
            current = current.next;
            count++;
        }

        System.out.println("The list doesn't contain " + data);
    }

    // add node next to
    public void addNodeByPosition(T data, int index) {

        ListNode<T> newNode = new ListNode<>(data);

        if (index == 0) {
            prepend(data);

        } else if (index == length() - 1) {
            append(data);

        } else if (index >= length() || index < 0) {
            System.out.println("Invalid index. Index out of bound.");

        } else {
            int count = 0;
            ListNode<T> current = head;

            for (int i = 1; i < index; i++) {
                current = current.next;
            }

            ListNode<T> temp = current.next;
            current.next = newNode;
            newNode.next = temp;
        }

       System.out.println(data + " is added next to the index " + index);
    }

    public void deleteNodeByPosition(int index) {

        if (index == 0) {
            deleteFirstNode();
        } else if (index == length() - 1) {
            pop();
        } else if (index >= length() || index < 0) {
            System.out.println("Invalid index. No node is added");
        } else {
            ListNode<T> current = head;
            ListNode<T> prev = head;

            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            prev.next = current.next;

            System.out.println("The node at index " + index + " is deleted.");
        }
    }

    public void deleteNode(T data) {

        if (head == null) {
            System.out.println("The list is empty.");
            return;
        } else if (head.data.equals(data)) {
            head = head.next;
            return;
        }

        ListNode<T> current = head;
        ListNode<T> prev = head;

        while (current != null) {
            if (current.data.equals(data)) {
                prev.next = current.next;
                //System.out.println(data + " is deleted.");
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void replaceFront(T data) {

        if (head == null) {
            System.out.println("The first node cannot be empty.");
            return;
        }

        ListNode<T> newNode = new ListNode<>(data);

        newNode.next = head.next;
        head = newNode;

        System.out.println("First node is replaced with " + data);
    }

    public void replaceBack(T data) {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return;
        }

        ListNode<T> newNode = new ListNode<>(data);
        newNode.next = null;
        ListNode<T> current = head;
        ListNode<T> previous = head;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = newNode;

        System.out.println("The last node is replaced with " + data);
    }

    public void replace(T data, int index) {

        if (isEmpty()) {
            System.out.println("The list is empty. Replacement failed.");
            return;
        }

        if (index == 0) {
            replaceFront(data);

        } else if (index == length() - 1) {
            replaceBack(data);

        } else if (index >= length() || index < 0) {
            System.out.println("Invalid index. Replacement failed.");

        } else {
            ListNode<T> newNode = new ListNode<>(data);
            ListNode<T> prev = head;
            ListNode<T> current = head;

            for (int i = 0; i < index; i++) {
                prev = current;
                current = current.next;
            }

            newNode.next = current.next;
            prev.next = newNode;
            System.out.println("The data at index " + index + " is replaced with " + data);
        }
    }

    public ListNode<T> getFront() {

        if (isEmpty()) {
            System.out.println("The list is empty. No node is obtained");
            return null;
        }

        System.out.println("The first node is " + head.data);
        return head;
    }

    public ListNode<T> getBack() {

        if (isEmpty()) {
            System.out.println("The list is empty. No node is obtained");
            return null;
        }

        ListNode<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        System.out.println("The last node is " + current.data);
        return current;
    }

    public ListNode<T> get(int index) {

        if (isEmpty()) {
            System.out.println("The list is empty. No node is obtained");
            return null;
        }

        if (index == 0) {
            getFront();

        } else if (index == length() - 1) {
            getBack();

        } else if (index >= length() || index < 0) {
            System.out.println("Invalid index. Failed to obtain data");
            return null;

        }
            ListNode<T> current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.println("Data at index " + index + " is " + current.data);

            return current;

    }

    public void addSortNode(T data) {

        ListNode<T> newNode = new ListNode<>(data);

        if (head == null || newNode.data.compareTo(head.data) < 0 || newNode.data.compareTo(head.data) == 0) {
            newNode.next = head;
            head = newNode;

        } else {
            ListNode<T> current = head;

            while (current.next != null && current.next.data.compareTo(newNode.data) < 0) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // split the list into two,
    // if number of elements is odd, the extra element belongs the first list
    public void splitList() {

        if (isEmpty()) {
            System.out.println("Please enter a word.");
        } else {

            System.out.println("Split the list into two");
            ListNode<T> current = head;

                for (int i = 0; i < 2; i++) {

                    LinkedList<T> list = new LinkedList<>();

                    int j = 0;

                    if(length() % 2 == 0) {
                        do {
                            assert current != null;
                            list.append(current.data);
                            current = current.next;
                            j++;
                        } while (j < length() / 2);
                    } else {
                  outer:
                        do {
                            if (current == null) {
                                break outer;
                            }
                            list.append(current.data);
                            current = current.next;
                            j++;
                        } while (j <= length() / 2);
                    }

                    switch (i) {
                        case 0 -> {
                            System.out.print("First list : ");
                            list.printList();
                        }
                        case 1 -> {
                            System.out.print("Second list: ");
                            list.printList();
                        }
                    }
                }
        }
    }

    // split the list's element alternatively
    public ListNode[] alternateSplit(ListNode<T> current) {

        if (isEmpty() || current.next == null) {
            System.out.println("Please enter a word.");
            return null;
        } else {
            System.out.println("Split the list by alternating the nodes");

            ListNode<T> list1, temp1, list2, temp2;
            list1 = temp1 = current;
            System.out.print("Temp1: ");
            printList(temp1);
            System.out.print("List1: ");
            printList(list1);

            list2 = temp2 = current.next;
            System.out.print("Temp2: ");
            printList(temp2);
            System.out.print("List2: ");
            printList(list2);

            current = current.next.next;

            while (current.next != null) {

                temp1.next = current;
                System.out.print("Temp1: ");
                printList(temp1);
                System.out.print("List1: ");
                printList(list1);

                temp2.next = current.next;
                System.out.print("Temp2: ");
                printList(temp2);
                System.out.print("List2: ");
                printList(list2);

                temp1 = temp1.next;
                System.out.print("Temp1: ");
                printList(temp1);
                System.out.print("List1: ");
                printList(list1);

                temp2 = temp2.next;
                System.out.print("Temp2: ");
                printList(temp2);
                System.out.print("List2: ");
                printList(list2);

                current = current.next.next;

            }

            temp1.next = current;
            System.out.print("Temp1: ");
            printList(temp1);
            System.out.print("List1: ");
            printList(list1);

            temp1 = temp1.next;
            System.out.print("Temp1: ");
            printList(temp1);
            System.out.print("List1: ");
            printList(list1);

            temp1.next = null;
            temp2.next = null;

            return new ListNode[] {list1, list2};
        }
    }

    // merge two list by alternating the elements
    public LinkedList<T> mergeList(ListNode<T> node1, ListNode<T> node2) {

        System.out.println("Merge First List and Second List by alternating the nodes");
        ListNode<T> current1 = node1;
        ListNode<T> current2 = node2;

        LinkedList<T> list = new LinkedList<>();

        while (current1 != null || current2 != null) {

            if(current1 != null) {
                list.append(current1.data);
                current1 = current1.next;
            }
            if(current2 != null) {
                list.append(current2.data);
                current2 = current2.next;
            }
        }
        return list;
    }

    public ListNode<T> reverseList(ListNode<T> head) {

        if (head == null) {
            //System.out.println("Null");
            return head;
        }

        if (head.next == null) {
            //System.out.print(head.data + "--> ");
            return head;
        }

        //System.out.print(head.data + " ");
        ListNode<T> newHead = reverseList(head.next);

        // next node of the current node's next node is the current node
        // eg. 7->6->5->4->3->null
        // current node: 4, next node of 4 = 3, 3's next node is set to 4
        head.next.next = head;

        // next node of current node is set to null
        // connection from 4 to 3 is cancelled
        head.next = null;

        return newHead;
    }

    public void printList(ListNode head) {

        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            ListNode<T> current = head;

            while (current != null) {
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void printList() {

        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            ListNode<T> current = head;

            while (current != null) {
                System.out.print(current.data + "--> ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void printListSpaceArrow() {

        if (head == null) {
            System.out.println("The list is empty.");
        } else {
            ListNode<T> current = head;

            while (current != null) {
                System.out.print(current.data + " --> ");
                current = current.next;
                System.out.println();
            }
        }
    }


    class LinkedListIterator implements Iterator<T>, Iterable<T> {

        ListNode<T> current = head;
        ListNode<T> iteratorPointer = this.current;
        ListNode<T> nextNode = current.next;

        private void resetIteratorPointer() {
            iteratorPointer = this.current;
        }

        @Override
        public Iterator<T> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {

            if (iteratorPointer == null) {
                resetIteratorPointer();
                return false;
            }

            return true;
        }

        @Override
        public T next() {
            T data = iteratorPointer.data;

            iteratorPointer = iteratorPointer.next;

            return data;
        }
    }

    public Iterator<T> listIterator() {
        LinkedListIterator li = new LinkedListIterator();
        return li.iterator();
    }

    @Override
    public int compareTo(LinkedList o) {
        return 0;
    }
}
