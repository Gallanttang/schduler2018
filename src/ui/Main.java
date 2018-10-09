package ui;


import model.ListOfMeals;
import model.ListOfWorkOuts;
import model.Meals;
import model.WorkOut;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static String name;
    private static String day;
    private static int time;
    private static int input;
    static String newName;
    static String newDay;
    static String newPlan;
    static int newTime;

    private static int maxHours = 24;


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

    private static void whatToDo(Scanner reader) {
        while (true) {
            System.out.println("Would you like to:");
            System.out.println("1. add work out/meal? - type \"1\"");
            System.out.println("2. find out what work out is on what day? - type \"2\"");
            System.out.println("3. Would you like to save the current plan? - type \"3\"");
            System.out.println("4. Would you like to load a plan? - type \"4\"");
            String line = reader.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                break;
            } else {
                try {
                    input = Integer.parseInt(line);
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                    continue;
                }
            }
            inputHandle(reader);
        }
    }

    public static void inputHandle(Scanner reader) {
        if (!(0 > input || input > 4)) {
            if (input == 1) {
                handleInput1(reader);
            } else if (input == 2) {
                handleInput2(reader);
            } else if (input == 3) {
                handleInput3(reader);
            } else if (input == 4) {
                handleInput4(reader);
            }
        } else {
            System.out.println("Invalid input.");
        }
    }

    private static void handleInput1(Scanner reader){
        System.out.println("Press 1 to add work out, 2 to add a meal.");
        input = reader.nextInt();
        if (input == 1){
            System.out.println("Adding a workout on a day that already has a workout will delete that workout@");
            addWorkOut(reader);
        } else {
            addMeal(reader);
        }
    }

    private static void handleInput2(Scanner reader){
        System.out.println("Press 1 to find a workout, 2 to find a meal.");
        input = reader.nextInt();
        if (input == 1){
            findWorkOut(reader);
        } else {
            findMeal(reader);
        }
    }

    private static void handleInput3(Scanner reader){
        Path pathWorkOuts = createPlanWorkOuts(reader);
        Path pathMeals = createPlanMeals(reader);
        try {
            workOuts.save(pathWorkOuts);
            meals.save(pathMeals);
        } catch (IOException e) {
            System.out.println("Failed to save to file.");
            return;
        }
        System.out.println("Plan saved!");
    }

    private static void handleInput4(Scanner reader){
        Path pathWorkOuts = loadPlanWorkOuts(reader);
        Path pathMeals = loadPlanMeals(reader);
        if (pathWorkOuts == null) {
            return;
        }
        if (pathMeals == null) {
            return;
        }
        try {
            workOuts.load(pathWorkOuts);
            meals.load(pathMeals);
        } catch (IOException e) {
            System.out.println("Failed to load from file.");
            return;
        }
        System.out.println("Plan loaded!");
    }

    private static void addMeal(Scanner reader) {
        System.out.println("What will this new meal be called?");
        reader.nextLine();
        newName = reader.nextLine();
        System.out.println("What time do you want to eat?");
        checkValidTime(newTime, reader);
        newTime = reader.nextInt();
        reader.nextLine();
        System.out.println("What will you eat during this meal?");
        newPlan = reader.nextLine();

        meals.addMeal(newName,newTime,newPlan);
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
            if (time == meals.getMeals().get(i).getTime()) {
                System.out.println(meals.getMeals().get(i).getPlan());
            }
        }
        for (int i = 0; i < workOuts.size(); i++) {
            if (workOuts.get(i).getDay() == day && workOuts.get(i).getTime() == time) {
                System.out.println("It's " + day + " and its " + meals.getMeals().get(i).getTime() + "! let's work out " + workOuts.get(i).getName() + "!");
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

    //Requires: User Input and existing file
    //Modifies: this
    //Effects:  Over rides existing plan with a loaded plan
    private static Path loadPlanWorkOuts(Scanner reader) {
        System.out.println("What plan would you like to load?");
        String name = reader.nextLine();
        File file = new File(name + "WorkOuts.txt");
        if (!file.exists()) {
            System.out.println("Work out Plan does not exist!");
            return null;
        }
        return file.toPath();
    }

    //Requires: User Input and existing file
    //Modifies: this
    //Effects:  Over rides existing plan with a loaded plan
    private static Path loadPlanMeals(Scanner reader) {
        System.out.println("What plan would you like to load?");
        String name = reader.nextLine();
        File file = new File(name + "Meals.txt");
        if (!file.exists()) {
            System.out.println("Meal Plan does not exist!");
            return null;
        }
        return file.toPath();
    }

    //Requires: User Input
    //Modifies: Nothing
    //Effects:  Creates a txt document with existing workout plan
    private static Path createPlanWorkOuts(Scanner reader) {
        System.out.println("What would you like to name this plan?");
        String name = reader.nextLine();
        File file = new File(name + "WorkOuts.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return null;
            }
        }
        return file.toPath();
    }

    //Requires: User Input
    //Modifies: Nothing
    //Effects:  Creates a txt document with existing workout plan
    private static Path createPlanMeals(Scanner reader) {
        System.out.println("What would you like to name this plan?");
        String name = reader.nextLine();
        File file = new File(name + "Meals.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                return null;
            }
        }
        return file.toPath();
    }

    //Requires: User Input
    //Modifies: this
    //Effects:  adds a new workout to work out list, replacing the workout that occurs on the same day as
    //          the new workout
    private static void addWorkOut(Scanner reader) {
        System.out.println("What will this new work out train?");
        reader.nextLine();
        newName = reader.nextLine();
        System.out.println("What time do you want to work out?");
        checkValidTime(newTime, reader);
        newTime = reader.nextInt();
        reader.nextLine();
        System.out.println("On which day? (Note: this will remove the current workout on that day)");
        newDay = reader.nextLine();
        checkValidDay(newDay, reader);
        System.out.println("What will this work out comprise of?");
        newPlan = reader.nextLine();
        workOuts.addAndReplace(newName, newTime, newPlan, newDay);
    }

    private static void checkValidTime(int newTime, Scanner reader) {
        if (!(0 <= newTime && newTime <= 24)) {
            System.out.println("That is not a valid input.");
            addWorkOut(reader);
        }
        return;
    }

    private static void checkValidDay(String newDay, Scanner reader) {
        if (!(newDay.equals("Monday") || newDay.equals("Tuesday") || newDay.equals("Wednesday") || newDay.equals("Thursday") ||
                newDay.equals("Friday") || newDay.equals("Saturday") || newDay.equals("Sunday"))) {
            System.out.println("That is not a valid input.");
            addWorkOut(reader);
        }
        return;
    }

    private static void findWorkOut(Scanner reader) {
        reader.nextLine();
        System.out.println("On what day is the work out are you looking for?");
        newName = reader.nextLine();
        workOuts.find(newName);
    }

    private static void findMeal(Scanner reader) {
        reader.nextLine();
        System.out.println("What is the name of the meal you are looking for?");
        newName = reader.nextLine();
        meals.find(newName);
    }
}
