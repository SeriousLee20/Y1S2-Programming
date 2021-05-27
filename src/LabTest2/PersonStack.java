package LabTest2;

/*
 * Author: Hui Xin
 * 06 May 2021
 */

public class PersonStack {
    public static void main(String[] args) {

        Stack<Person> raw = new Stack("Raw list");
        raw.push("ali", 32, "m", "doctor");
        raw.push("lisa", 29, "f", "nurse");
        raw.push("tanaka", 41);
        raw.push("ahmad", 18, "m", "developer");
        raw.push("maria", 20, "f", "accountant");
        raw.push("chong", 70, "m", "lawyer");
        raw.push("raju", 55, "m", "police");
        raw.push("alex", 16, "f", "business man ");
        Person katie = new Person("katie", 36, "f", "teacher");
        raw.push(katie);
        raw.displayStack();

        Stack<Person> frontliners = new Stack<>("Frontliners");
        Stack<Person> others = new Stack<>("Others");

        for (int i = raw.getSize() - 1; i > -1; i--) {
            Person temp = raw.pop();
            if (temp.isFrontLiner()) {
                frontliners.push(temp);
            } else {
                others.push(temp);
            }
        }

        System.out.println("~~~~~~~Sort into frontliners and others~~~~~\n");
        raw.displayStack();
        frontliners.displayStack();
        others.displayStack();

        System.out.println("~~~~~~~Sort into Vaccine list~~~~~\n");
        Stack<Person> priority = new Stack<>("Vaccine Priority List");
        sortPriority(frontliners, others, priority);
        others.displayStack();
        frontliners.displayStack();
        priority.displayStack();

    }

    public static Stack<Person> sortPriority(Stack<Person> frontliners, Stack<Person> others, Stack<Person> priority) {
        others.sort();
        frontliners.sort();

        for (int i = others.getSize() - 1; i > -1; i--) {

            priority.push(others.pop());
        }

        for (int i = frontliners.getSize() - 1; i > -1; i--) {
            priority.push(frontliners.pop());
        }

        return priority;
    }
}
