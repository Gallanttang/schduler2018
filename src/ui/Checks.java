package ui;

import java.util.Scanner;

public class Checks {
    public static boolean checkValidTime(int newTime, Scanner reader) {
        if (!(0 <= newTime && newTime <= 24)) {
            System.out.println("That is not a valid input.");
            return false;
        }
        return true;
    }

    public static boolean checkValidDay(String newDay, Scanner reader) {
        if (!(newDay.equals("Monday") || newDay.equals("Tuesday") || newDay.equals("Wednesday") || newDay.equals("Thursday") ||
                newDay.equals("Friday") || newDay.equals("Saturday") || newDay.equals("Sunday"))) {
            System.out.println("That is not a valid input.");
            return true;
        }
        return false;
    }
}
