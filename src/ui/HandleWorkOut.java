package ui;

import Exceptions.InvalidDayException;
import Exceptions.InvalidTimeException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static ui.Checks.checkValidDay;
import static ui.Checks.checkValidTime;
import static ui.Main.workOuts;
import static ui.Main.newName;
import static ui.Main.newPlan;
import static ui.Main.newTime;
import static ui.Main.newDay;

public class HandleWorkOut {
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
        try{
        workOuts.addAndReplace(newName, newTime, newPlan, newDay);}
        catch (InvalidDayException | InvalidTimeException e){
            e.getMessage();
            addWorkOut(reader);
        }
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
