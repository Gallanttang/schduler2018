package ui;


import model.HashMapOfMeals;
import model.HashMapOfWorkOuts;
import model.Meals;
import model.WorkOut;


import java.util.*;


import static ui.DateAndTime.dateHandler;
import static ui.DateAndTime.isItTime;
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


    static HashMapOfWorkOuts workOuts = new HashMapOfWorkOuts();
    static HashMapOfMeals meals = new HashMapOfMeals();

    private final static WorkOut legs = new WorkOut("Legs", 18, "Squats and lunges", "Monday");
    private final static WorkOut arms = new WorkOut("Arms", 18, "Biceps curls and triceps dips", "Tuesday");
    private final static WorkOut torso = new WorkOut("Torso", 18, "Bench Presses and pull ups", "Wednesday");
    private final static WorkOut core = new WorkOut("Core", 18, "Sit ups and leg raises exercises", "Thursday");
    private final static WorkOut cardio = new WorkOut("Cardio", 18, "Run 2.4km and do 5 minutes of power rope", "Friday");
    private final static WorkOut back = new WorkOut("Back", 18, "Dead lifts and lats pull down", "Saturday");
    private final static WorkOut rest = new WorkOut("Rest", 18, "no working out today", "Sunday");

    final static Meals breakfast = new Meals("Breakfast", 7, "Hey it's 7! The sun is rising, " +
            "it's time for breakfast! Eat 2 eggs and an apple");
    final static Meals lunch = new Meals("Lunch", 13, "Hey it's 13! The sun is up high, it's time for lunch! " +
            "Eat pasta with any sauce and protein of choice");
    final static Meals dinner = new Meals("Dinner", 19, "Hey it's 19! The sun is setting, it's time for dinner!" +
            " Eat whatever you want, it's been a long day");


    private static void hello() {
        System.out.println("type \"quit\" at any time to quit");
        System.out.println("Hello, what is your name?");
    }

    public static void before() {
        workOuts.getWorkOuts().put(legs.getDay(),legs);
        workOuts.getWorkOuts().put(arms.getDay(), arms);
        workOuts.getWorkOuts().put(torso.getDay(),torso);
        workOuts.getWorkOuts().put(core.getDay(), core);
        workOuts.getWorkOuts().put(cardio.getDay(),cardio);
        workOuts.getWorkOuts().put(back.getDay(),back);
        workOuts.getWorkOuts().put(rest.getDay(),rest);
        meals.getMeals().put(breakfast.getTime(), breakfast);
        meals.getMeals().put(lunch.getTime(), lunch);
        meals.getMeals().put(dinner.getTime(), dinner);
        dateHandler();
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
