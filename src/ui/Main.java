package ui;


import model.ListOfMeals;
import model.ListOfWorkOuts;
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
    static String newWork;
    String newFood;
    int newTime;

    static ListOfWorkOuts workOuts = new ListOfWorkOuts();

    final static WorkOut legs = new WorkOut("Legs", "Monday", "Squats and lunges");
    final static WorkOut arms = new WorkOut("Arms", "Tuesday", "Biceps curls and triceps dips");
    final static WorkOut torso = new WorkOut("Torso", "Wednesday", "Bench Presses and pull ups");
    final static WorkOut core = new WorkOut("Core", "Thursday", "Sit ups and leg raises exercises");
    final static WorkOut cardio = new WorkOut("Cardio", "Friday", "Run 2.4km and do 5 minutes of power rope");
    final static WorkOut back = new WorkOut("Back", "Saturday", "Dead lifts and lats pull down");
    final static WorkOut rest = new WorkOut("Rest", "Sunday", "no working out today");

    static ListOfMeals meals = new ListOfMeals();


    private static void hello() {
        System.out.println("type \"quit\" at any time to quit");
        System.out.println("Hello, what is your name?");
    }

    private static void whatDay() {
        System.out.print("It is " + day + " at ");
    }

    private static void whatTime() {
        if (time < 12) {
            System.out.println(time + "am!");
        } else if (time == 12) {
            System.out.println(time + "pm!");
        } else {
            System.out.println(time - 12 + "pm!");
        }
    }

    private static void whatToDo() {
        System.out.println("Would you like to:");
        System.out.println("1. add work out? (and remove another on on that day) - type \"1\"");
        System.out.println("2. find out what work out is on what day? - type \"2\"");
        System.out.println("3. Would you like to save the current plan? - type \"3\"");
        System.out.println("4. Would you like to load a plan? - type \"4\"");
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


    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(dateobj);   // assigns calendar to given date
        calendar.get(Calendar.MONTH);
        System.out.println(df.format(dateobj));

        Scanner reader = new Scanner(System.in);
        hello();

        name = reader.nextLine();

        day = getDayOfWeek(calendar.get(Calendar.DAY_OF_WEEK));        // gets hour in 12h format


        time = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format


        HealthPlan hp = new HealthPlan(day, time, name);
        hp.greeting();
        whatDay();
        whatTime();
        workOuts.getWorkOuts().add(legs);
        workOuts.getWorkOuts().add(arms);
        workOuts.getWorkOuts().add(torso);
        workOuts.getWorkOuts().add(core);
        workOuts.getWorkOuts().add(cardio);
        workOuts.getWorkOuts().add(back);
        workOuts.getWorkOuts().add(rest);

        hp.planHealth(time, workOuts);

        while (true) {
            whatToDo();

            String line = reader.nextLine();
            if(line.equalsIgnoreCase("quit")) {
                break;
            } else {
                try {
                    input = Integer.parseInt(line);
                } catch(Exception e) {
                    System.out.println("Invalid input.");
                    continue;
                }
            }

            if (!(0 > input || input > 4)) {
                if (input == 1) {
                    addWorkOut(reader);
                } else if (input == 2) {

                    System.out.println("What work out are you looking for?");
                    newName = reader.nextLine();
                    workOuts.find(newName);

                } else if (input == 3) {
                    Path path = createPlan(reader);
                    try {
                        workOuts.save(path);
                    } catch (IOException e) {
                        System.out.println("Failed to save to file.");
                        continue;
                    }
                    System.out.println("Plan saved!");
                } else if (input == 4) {
                    Path path = loadPlan(reader);
                    if(path == null) {
                        continue;
                    }
                    try {
                        workOuts.load(path);
                    } catch (IOException e) {
                        System.out.println("Failed to load from file.");
                        continue;
                    }
                    System.out.println("Workout loaded!");
                }
            } else {
                System.out.println("That's not a valid input");
            }
        }
    }

    //Requires: User Input and existing file
    //Modifies: this
    //Effects:  Over rides existing plan with a loaded plan
    private static Path loadPlan(Scanner reader) {
        System.out.println("What plan would you like to load?");
        String name = reader.nextLine();
        File file = new File(name+".txt");
        if(!file.exists()) {
            System.out.println("Plan does not exist!");
            return null;
        }
        return file.toPath();
    }

    //Requires: User Input
    //Modifies: Nothing
    //Effects:  Creates a txt document with existing workout plan
    private static Path createPlan(Scanner reader) {
        System.out.println("What would you like to name this plan?");
        String name = reader.nextLine();
        File file = new File(name+".txt");
        if(!file.exists()) {
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
    private static void addWorkOut(Scanner reader){
        System.out.println("What will this new work out train?");
        newName = reader.nextLine();
        System.out.println("On which day? (Note: this will remove the current workout on that day)");
        newDay = reader.nextLine();
        System.out.println("What will this work out comprise of?");
        newWork = reader.nextLine();

        workOuts.addAndReplace(newName, newDay, newWork);
    }
}
