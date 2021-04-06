package TutExercise.T1;

/*
 * Author: Hui Xin
 * 11 Mar 2021
 */

public class C {
    public static void main(String[] args) {
        Object[] o = {new A(), new B()};
        System.out.println(o[0]);
        System.out.println(o[1]);
    }
}


// method toString is override
class A extends B{
    @Override
    public String toString() {
        return "A";
    }
}

class B {
    @Override
    public String toString() {
        return "B";
    }
}
