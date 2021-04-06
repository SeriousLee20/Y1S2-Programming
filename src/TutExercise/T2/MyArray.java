package TutExercise.T2;

/*
 * Author: Hui Xin
 * 16 Mar 2021
 */

public class MyArray {

    // static generic method is allowed
    // static <E> void abs(E list){}
    // static method with generic is not allowed
    // static void abs(E list){}


    public <E> void listAll(E[] array) {

        for(E i : array)
            System.out.print(i + " ");

        System.out.println();
    }

    public static void main(String[] args) {

        MyArray myArray = new MyArray();

        Integer[] integers = {1, 2, 3, 4, 5};
        String[] str = {"Jane", "Tom", "Bob"};
        Character[] chars = {'a', 'b', 'c'};

        System.out.println("Integers");
        myArray.listAll(integers);

        System.out.println("\nString");
        myArray.listAll(str);

        System.out.println("\nCharacters");
        myArray.listAll(chars);
    }
}
