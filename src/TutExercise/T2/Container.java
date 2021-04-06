package TutExercise.T2;

/*
 * Author: Hui Xin
 * 16 Mar 2021
 */

public class Container<T> {

    private T t;

    public Container() {
    }

    public void setT(T t) {
        this.t = t;
    }

    public T retrieve() {
        return t;
    }

    public static void main(String[] args) {

        Container<Integer> conInt = new Container<>();
        Container<String> conStr = new Container<>();

        conInt.setT(50);
        conStr.setT("Java");

        System.out.println(conInt.retrieve());
        System.out.println(conStr.retrieve());
    }
}
