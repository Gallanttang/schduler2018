package ui;

public class Checks {
    protected static boolean checkValidTime(int newTime) {
        if (!(0 <= newTime && newTime <= 24)) {
            System.out.println("That is not a valid input.");
            return false;
        }
        return true;
    }

    protected static boolean checkValidDay(String newDay) {
        if (!(newDay.equals("Monday") || newDay.equals("Tuesday") || newDay.equals("Wednesday") || newDay.equals("Thursday") ||
                newDay.equals("Friday") || newDay.equals("Saturday") || newDay.equals("Sunday"))) {
            System.out.println("That is not a valid input.");
            return true;
        }
        return false;
    }
}
