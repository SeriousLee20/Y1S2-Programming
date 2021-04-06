package LabExercise.L3;

/*
 * Author: Hui Xin
 * 22 Feb 2021
 */

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        int [] dateToday = searchDate();

        LocalDate ld = LocalDate.of(dateToday[2], dateToday[1], dateToday[0]);

        DayOfWeek dayToday = ld.getDayOfWeek();
        String day = dayToday.toString().charAt(0) + dayToday.toString().substring(1).toLowerCase();
        System.out.println("Today is on " + day);

        System.out.println("Search Date (dd/mm/yyyy): 20/8/2015");
        searchDayOfWeek(dateToday[0], dateToday[1], dateToday[2], dayToday.getValue() - 1);


    }

    public static void searchDayOfWeek(int date, int mon, int year, int day) {

        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (date == 20 && mon == 8 && year == 2015) {
            System.out.println("Search Date is on " + dayOfWeek[day]);

        } else {

            date--;
            day--;

            if (day < 0) {
                day = 6;
            }

            if (date == 0) {
                mon--;

                switch (mon) {
                    case 0:
                        mon = 12;
                        year--;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        date = 31;
                        break;
                    case 2:
                        if (year % 4 == 0 && year % 100 != 0 || year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
                            date = 29;
                        } else {
                            date = 28;
                        }
                        break;
                    default: date = 30;
                }
            }
            searchDayOfWeek(date, mon, year, day);
        }
    }

    public static int[] searchDate() {

        Scanner in = new Scanner(System.in);

        System.out.print("Search Date (dd/mm/yyyy): ");
        String[] pastDate = in.nextLine().split("/");

        int[] dateNum = new int[pastDate.length];

        int j = 0;
        for (String i : pastDate) {
            dateNum[j] = Integer.parseInt(i);
            j++;
        }

        return dateNum;
    }
}
