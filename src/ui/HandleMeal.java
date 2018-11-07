package ui;

import Exceptions.InvalidTimeException;
import model.HashMapOfMeals;
import model.Meals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static ui.Checks.checkValidTime;



public class HandleMeal {
    private static String newName;
    private static String newPlan;
    private static int newTime;


    static HashMapOfMeals meals = new HashMapOfMeals();

    final static Meals breakfast = new Meals("Breakfast", 7, "Hey it's 7! The sun is rising, " +
            "it's time for breakfast! Eat 2 eggs and an apple");
    final static Meals lunch = new Meals("Lunch", 13, "Hey it's 13! The sun is up high, it's time for lunch! " +
            "Eat pasta with any sauce and protein of choice");
    final static Meals dinner = new Meals("Dinner", 19, "Hey it's 19! The sun is setting, it's time for dinner!" +
            " Eat whatever you want, it's been a long day");

    protected static void generateMeals() {
        meals.getMeals().put(breakfast.getTime(), breakfast);
        meals.getMeals().put(lunch.getTime(), lunch);
        meals.getMeals().put(dinner.getTime(), dinner);
    }

    protected static void timeToEat(int time, HashMapOfMeals meals) {
        if (meals.getMeals().containsKey(time)) {
            if (time == meals.get(time).getTime()) {
                System.out.println(meals.get(time).getPlan());
            }
        }
    }

    protected static void findMeal(Scanner reader) {
        reader.nextLine();
        System.out.println("What is the name of the meal you are looking for?");
        newName = reader.nextLine();
        meals.find(newName);
    }

    protected static void addMeal(Scanner reader) {
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
        checkValidTime(newTime);
        reader.nextLine();
        System.out.println("What will you eat during this meal?");
        newPlan = reader.nextLine();
    }

    //Requires: User Input
    //Modifies: Nothing
    //Effects:  Creates a txt document with existing workout plan
    protected static Path createPlanMeals(String name) {
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
    protected static Path loadPlanMeals(String name) {
        File file = new File(name + "Meals.txt");
        if (!file.exists()) {
            return null;
        }
        return file.toPath();
    }


}
