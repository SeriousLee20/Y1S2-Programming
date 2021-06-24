package PYQ.S1_2017;

/*
 * Author: Hui Xin
 * 22 Jun 2021
 */

public class ListNode<Item> {

    Item data;
    ListNode<Item> next;

    public ListNode() {
    }

    public ListNode(Item data) {
        this.data = data;
    }

    public ListNode<Item> getNext() {
        return next;
    }

    public void setNext(ListNode<Item> next) {
        this.next = next;
    }

    public String toString() {
        return data + "";
    }
}
