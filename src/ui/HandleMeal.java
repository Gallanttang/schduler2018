package ui;

import Exceptions.InvalidTimeException;
import model.HashMapOfMeals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static ui.Checks.checkValidTime;
import static ui.Main.meals;
import static ui.Main.newPlan;
import static ui.Main.newTime;
import static ui.Main.newName;


public class HandleMeal {

    protected static void timeToEat(int time, HashMapOfMeals meals) {
        if (meals.getMeals().containsKey(time)) {
            if (time == meals.get(time).getTime()) {
                System.out.println(meals.get(time).getPlan());
            }
        }
    }

    public static void findMeal(Scanner reader) {
        reader.nextLine();
        System.out.println("What is the name of the meal you are looking for?");
        newName = reader.nextLine();
        meals.find(newName);
    }

    public static void addMeal(Scanner reader) {
        askForParamMeals(reader);
        if(newTime != 18) {
            try {
                meals.addMeal(newName, newTime, newPlan);
            } catch (InvalidTimeException e) {
                e.getMessage();
                addMeal(reader);
            }
        } else {
            System.out.println("You can't have a meal at 18! You need to work out at that time.");
            addMeal(reader);
        }
    }

    private static void askForParamMeals(Scanner reader) {
        System.out.println("What will this new meal be called?");
        reader.nextLine();
        newName = reader.nextLine();
        System.out.println("What time do you want to eat?");
        newTime = reader.nextInt();
        checkValidTime(newTime, reader);
        reader.nextLine();
        System.out.println("What will you eat during this meal?");
        newPlan = reader.nextLine();
    }

    //Requires: User Input
    //Modifies: Nothing
    //Effects:  Creates a txt document with existing workout plan
    public static Path createPlanMeals(Scanner reader) {
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

    //Requires: User Input and existing file
    //Modifies: this
    //Effects:  Over rides existing plan with a loaded plan
    public static Path loadPlanMeals(Scanner reader) {
        System.out.println("What plan would you like to load?");
        String name = reader.nextLine();
        File file = new File(name + "Meals.txt");
        if (!file.exists()) {
            System.out.println("Meal Plan does not exist!");
            return null;
        }
        return file.toPath();
    }


}
