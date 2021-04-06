package TutExercise.T1;

/*
 * Author: Hui Xin
 * 11 Mar 2021
 */

public class Telephone {
    private String areaCode;
    private int number;
    static int numberOfTelephoneObject;

    public Telephone(String areaCode, int number) {
        this.areaCode = areaCode;
        this.number = number;
        numberOfTelephoneObject++;
        System.out.println("Number of object created: " + numberOfTelephoneObject);
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String makeFullNumber() {
        return areaCode + "-" + number;
    }
}
