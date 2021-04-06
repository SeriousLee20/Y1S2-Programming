package TutExercise.T1;

/*
 * Author: Hui Xin
 * 11 Mar 2021
 */

public class Person {

    public Person() {
        System.out.println("(1) Performs Person's tasks");
    }
}

class Employee extends Person {

    public Employee() {
        this("(2) Invoke Employee's overloaded constructor");
        System.out.println("(3) Performs Employee's tasks");
    }

    public Employee(String s) {
        System.out.println(s);
    }
}

class Faculty extends Employee {

    public Faculty(String s) {
        super(s);
    }

    public Faculty() {
        System.out.println("(4) Performs Faculty's tasks");
    }

    public static void main(String[] args) {
        new Faculty();
        System.out.println("-".repeat(20));
        new Faculty("(5) Testing");
    }
}

// the constructors are inherited
/*
(1) Performs Person's tasks
(2) Invoke Employee's overloaded constructor
(3) Performs Employee's tasks
(4) Performs Faculty's tasks
*/