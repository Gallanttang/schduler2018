package ui;

import Exceptions.InvalidDayException;
import Exceptions.InvalidTimeException;
import model.HashMapOfWorkOuts;
import model.WorkOut;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

import static ui.Checks.checkValidDay;
import static ui.Checks.checkValidTime;

public class HandleWorkOut {
    private static String newName;
    private static String newDay;
    private static String newPlan;
    private static int newTime;

    static HashMapOfWorkOuts workOuts = new HashMapOfWorkOuts();

    private final static WorkOut legs = new WorkOut("Legs", 18, "Squats and lunges", "Monday");
    private final static WorkOut arms = new WorkOut("Arms", 18, "Biceps curls and triceps dips", "Tuesday");
    private final static WorkOut torso = new WorkOut("Torso", 18, "Bench Presses and pull ups", "Wednesday");
    private final static WorkOut core = new WorkOut("Core", 18, "Sit ups and leg raises exercises", "Thursday");
    private final static WorkOut cardio = new WorkOut("Cardio", 18, "Run 2.4km and do 5 minutes of power rope", "Friday");
    private final static WorkOut back = new WorkOut("Back", 18, "Dead lifts and lats pull down", "Saturday");
    private final static WorkOut rest = new WorkOut("Rest", 18, "no working out today", "Sunday");

    protected static void generateWorkOuts() {
        workOuts.getWorkOuts().put(legs.getDay(),legs);
        workOuts.getWorkOuts().put(arms.getDay(), arms);
        workOuts.getWorkOuts().put(torso.getDay(),torso);
        workOuts.getWorkOuts().put(core.getDay(), core);
        workOuts.getWorkOuts().put(cardio.getDay(),cardio);
        workOuts.getWorkOuts().put(back.getDay(),back);
        workOuts.getWorkOuts().put(rest.getDay(),rest);
    }

    protected static void timeToWorkOut(int time, HashMapOfWorkOuts workOuts, String day) {
        for (Map.Entry<String, WorkOut> e: workOuts.getWorkOuts().entrySet()) {
            if (e.getValue().getDay().equals(day) && e.getValue().getTime() == time) {
                System.out.println("It's " + day + " and its " + e.getValue().getTime()
                        + "! let's work out " + e.getValue().getName() + "!");
                System.out.println("Do some " + e.getValue().getPlan() + "!");
            }
        }
    }

    protected static void findWorkOut(Scanner reader) {
        reader.nextLine();
        System.out.println("On what day is the work out are you looking for?");
        newName = reader.nextLine();
        workOuts.find(newName);
    }

    //Requires: User Input
    //Modifies: this
    //Effects:  adds a new workout to work out list, replacing the workout that occurs on the same day as
    //          the new workout
    protected static void addWorkOut(Scanner reader) {
        askForParamWO(reader);
        try{workOuts.addAndReplace(newName, newTime, newPlan, newDay);}
        catch (InvalidDayException | InvalidTimeException e){
            e.getMessage();
            addWorkOut(reader);
        }
    }

    private static void askForParamWO(Scanner reader) {
        System.out.println("What will this new work out train?");
        reader.nextLine();
        newName = reader.nextLine();

        System.out.println("What time do you want to work out?");
        newTime = reader.nextInt();
        checkValidTime(newTime);
        reader.nextLine();

        System.out.println("On which day? (Note: this will remove the current workout on that day)");
        newDay = reader.nextLine();
        checkValidDay(newDay);

        System.out.println("What will this work out comprise of?");
        newPlan = reader.nextLine();
    }

    //Requires: User Input
    //Modifies: Nothing
    //Effects:  Creates a txt document with existing workout plan
    protected static Path createPlanWorkOuts(String name) {
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


    //Requires: User Input and existing file
    //Modifies: this
    //Effects:  Over rides existing plan with a loaded plan
    protected static Path loadPlanWorkOuts(String name) {
        File file = new File(name + "WorkOuts.txt");
        if (!file.exists()) {
            return null;
        }
        return file.toPath();
    }
}
