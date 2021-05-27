package LabTest2;

/*
 * Author: Hui Xin
 * 06 May 2021
 */

import java.util.ArrayList;
import java.util.Collections;

public class Stack<E> {

    private ArrayList<Person> list = new ArrayList<>();
    private String stack_name;

    public Stack(String stack_name) {
        this.stack_name = stack_name;
    }

    public int getSize() {
        return list.size();
    }

    public Person peek() {
        if (getSize() == 0) {
            System.out.println("Empty stack.");
            return null;
        }
        return list.get(getSize() - 1);
    }

    public Person pop() {
        if (list.isEmpty()) {
            System.out.println("Empty stack.");
            return null;
        }

        Person data = peek();
        //System.out.println(data + " is the last element.");

        list.remove(getSize() - 1);
        return data;
    }

    public void push(String name, int age) {
        Person newPerson = new Person(name, age);
        list.add(newPerson);
    }

    public void push(String name, int age, String gender) {
        Person newPerson = new Person(name, age, gender);
        list.add(newPerson);
    }

    public void push(String name, int age, String gender, String occupation) {
        Person newPerson = new Person(name, age, gender, occupation);

        list.add(newPerson);

        if (newPerson.getOccupation_list().contains(occupation)) {
            newPerson.setFrontLiner();
        }
    }

    public void push(Person newPerson) {
        list.add(newPerson);

        String occupation = newPerson.getOccupation();

        if (occupation != null) {
            if (newPerson.getOccupation_list().contains(occupation)) {
                newPerson.setFrontLiner();
            }
        }
    }

    public void displayStack() {

        System.out.println("---" + stack_name + "---\n");
        if (isEmpty()) {
            System.out.println("Empty stack\n");
        }
        for (int i = list.size() - 1; i > -1; i--) {
            Person current = list.get(i);

            System.out.printf("%d %s %d %s ", i, current.getName(),
                    current.getAge(), current.getGender());


            System.out.println(current.isFrontLiner() ? "Frontliner" : "Not frontliner");

            System.out.println();
        }

        System.out.println("-------------------\n");
    }

    public void sort() {
        Collections.sort(list, Collections.reverseOrder());
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: " + list.toString();
    }

    public boolean search(Person o) {
        return list.contains(o);
    }

    public Person get(int i) {
        return list.get(i);
    }
}
