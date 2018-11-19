package ui;

import model.HashMapOfMeals;
import model.HashMapOfWorkOuts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static ui.HandleMeal.timeToEat;
import static ui.HandleWorkOut.timeToWorkOut;
import static ui.Main.name;

public class DateAndTime {
    final private static int sleep = 0;
    private static String day;
    private static int time;


    private static String getDayOfWeek(int value) {
        switch (value) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }
    protected static void dateHandler(){
            DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
            Date dateobj = new Date();
            Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
            calendar.setTime(dateobj);   // assigns calendar to given date
            calendar.get(Calendar.MONTH);
            System.out.println(df.format(dateobj));
            day = getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));        // gets hour in 12h format
            time = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
    }

    private static String whatDay() {
        return "It is " + day + "!";
    }

    protected static void isItTime(HashMapOfWorkOuts workOuts, HashMapOfMeals meals) {
        System.out.println("Hello, " + name + "! " + whatDay());
        timeToEat(time, meals);
        timeToWorkOut(time, workOuts, day);
        notTimeOrTimeToSleep(time);
    }

    private static void notTimeOrTimeToSleep(int time) {
        if (time == sleep) {
            System.out.print("It's late, time to get some sleep");
        } else {
            notTime(time);
        }
    }


    private static void notTime(int time) {
        if (time < 12) {
            System.out.println("It's " + time + "am, that's not time to eat!");
        } else if (time == 12) {
            System.out.println(time + "pm, that's not time to eat!");
        } else {
            int newTime = time - 12;
            System.out.println("It's " + newTime + "pm, that's not time to eat!");
        }
    }
}
