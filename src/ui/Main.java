package ui;



import model.ListOfMeals;
import model.ListOfWorkOuts;
import model.Meals;
import model.WorkOut;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static ui.HandlesInput.whatToDo;

public class Main {
    public static String name;
    public static String day;
    public static int time;
    public static int input;
    public static String newName;
    public static String newDay;
    public static String newPlan;
    public static int newTime;

    public static int maxHours = 24;


    static ListOfWorkOuts workOuts = new ListOfWorkOuts();

    private final static WorkOut legs = new WorkOut("Legs", 18, "Squats and lunges", "Monday");
    private final static WorkOut arms = new WorkOut("Arms", 18, "Biceps curls and triceps dips","Tuesday");
    private final static WorkOut torso = new WorkOut("Torso", 18, "Bench Presses and pull ups","Wednesday");
    private final static WorkOut core = new WorkOut("Core", 18, "Sit ups and leg raises exercises","Thursday");
    private final static WorkOut cardio = new WorkOut("Cardio", 18, "Run 2.4km and do 5 minutes of power rope","Friday");
    private final static WorkOut back = new WorkOut("Back", 18, "Dead lifts and lats pull down","Saturday");
    private final static WorkOut rest = new WorkOut("Rest", 18, "no working out today","Sunday");

    final static Meals breakfast = new Meals("Breakfast", 7, "Hey it's 7! The sun is rising, " +
            "it's time for breakfast! Eat 2 eggs and an apple");
    final static Meals lunch = new Meals("Lunch", 13, "Hey it's 13! The sun is up high, it's time for lunch! " +
            "Eat pasta with any sauce and protein of choice");
    final static Meals dinner = new Meals("Dinner", 19, "Hey it's 19! The sun is setting, it's time for dinner!" +
            " Eat whatever you want, it's been a long day");


    static ListOfMeals meals = new ListOfMeals();


    private static void hello() {
        System.out.println("type \"quit\" at any time to quit");
        System.out.println("Hello, what is your name?");
    }

    private static String whatDay() {
        return "It is " + day + "!";
    }

    public static void before() {
        workOuts.getWorkOuts().add(legs);
        workOuts.getWorkOuts().add(arms);
        workOuts.getWorkOuts().add(torso);
        workOuts.getWorkOuts().add(core);
        workOuts.getWorkOuts().add(cardio);
        workOuts.getWorkOuts().add(back);
        workOuts.getWorkOuts().add(rest);
        meals.getMeals().add(breakfast);
        meals.getMeals().add(lunch);
        meals.getMeals().add(dinner);
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(dateobj);   // assigns calendar to given date
        calendar.get(Calendar.MONTH);
        System.out.println(df.format(dateobj));
        day = getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));        // gets hour in 12h format
        time = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
    }

    public static String getDayOfWeek(int value) {
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

    private static void isItTime(int time, ListOfWorkOuts workOuts, ListOfMeals meals) {
        whatDay();
        System.out.println("Hello, " + name + "! " + whatDay());
        for (int i = 0; i < meals.getMeals().size(); i++) {
            if (time == meals.get(i).getTime()) {
                System.out.println(meals.get(i).getPlan());
            }
        }
        for (int i = 0; i < workOuts.size(); i++) {
            if (workOuts.get(i).getDay().equals(day) && workOuts.get(i).getTime() == time) {
                System.out.println("It's " + day + " and its " + meals.get(i).getTime() + "! let's work out " + workOuts.get(i).getName() + "!");
                System.out.println("Do some " + workOuts.get(i).getPlan() + "!");
            }
        }
        if (time == maxHours) {
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

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        before();
        hello();
        name = reader.nextLine();
        isItTime(time, workOuts, meals);
        whatToDo(reader);
    }
}
