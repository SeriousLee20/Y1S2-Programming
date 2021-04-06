package LabExercise.L1;

/*
 * Author: Hui Xin
 * 17 Feb 2021
 */

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    private int hour;
    private int min;

    public Time(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public void validTime() {
        if (hour < 0 || hour > 23 || min < 0 || min > 59) {
            System.out.println("Invalid time input");
        }
    }

    public void timeAmPm() {
        try {
            LocalTime lt = LocalTime.of(hour, min);
            DateTimeFormatter fm = DateTimeFormatter.ofPattern("hh:mm a");

            System.out.println(fm.format(lt));
        } catch (DateTimeException e) {
            System.out.print("");
        }
    }
}
