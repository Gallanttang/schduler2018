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
import static ui.Main.workOuts;
import static ui.Main.newName;
import static ui.Main.newPlan;
import static ui.Main.newTime;
import static ui.Main.newDay;

public class HandleWorkOut {
    protected static void timeToWorkOut(int time, HashMapOfWorkOuts workOuts, String day) {
        for (Map.Entry<String, WorkOut> e: workOuts.getWorkOuts().entrySet()) {
            if (e.getValue().getDay().equals(day) && e.getValue().getTime() == time) {
                System.out.println("It's " + day + " and its " + e.getValue().getTime()
                        + "! let's work out " + e.getValue().getName() + "!");
                System.out.println("Do some " + e.getValue().getPlan() + "!");
            }
        }
    }

    public static void findWorkOut(Scanner reader) {
        reader.nextLine();
        System.out.println("On what day is the work out are you looking for?");
        newName = reader.nextLine();
        workOuts.find(newName);
    }

    //Requires: User Input
    //Modifies: this
    //Effects:  adds a new workout to work out list, replacing the workout that occurs on the same day as
    //          the new workout
    public static void addWorkOut(Scanner reader) {
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
        checkValidTime(newTime, reader);
        reader.nextLine();

        System.out.println("On which day? (Note: this will remove the current workout on that day)");
        newDay = reader.nextLine();
        checkValidDay(newDay, reader);

        System.out.println("What will this work out comprise of?");
        newPlan = reader.nextLine();
    }

    //Requires: User Input
    //Modifies: Nothing
    //Effects:  Creates a txt document with existing workout plan
    public static Path createPlanWorkOuts(Scanner reader) {
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


    //Requires: User Input and existing file
    //Modifies: this
    //Effects:  Over rides existing plan with a loaded plan
    public static Path loadPlanWorkOuts(Scanner reader) {
        System.out.println("What plan would you like to load?");
        String name = reader.nextLine();
        File file = new File(name + "WorkOuts.txt");
        if (!file.exists()) {
            System.out.println("Work out Plan does not exist!");
            return null;
        }
        return file.toPath();
    }
}
