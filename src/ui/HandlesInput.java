package ui;

import Exceptions.InvalidInput;

import java.io.IOException;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

import static ui.HandleMeal.*;
import static ui.HandleWorkOut.*;


public class HandlesInput {
    private static int input;
    private static String newName;

    protected static void whatToDo(Scanner reader) {
        while (true) {
            System.out.println("Would you like to:");
            System.out.println("1. add work out/meal? - type \"1\"");
            System.out.println("2. find a work out or a meal? - type \"2\"");
            System.out.println("3. Would you like to save the current plan? - type \"3\"");
            System.out.println("4. Would you like to load a plan? - type \"4\"");
            String line = reader.nextLine();
            if (line.equalsIgnoreCase("quit")) {
                break;
            } else {
                try {
                    input = Integer.parseInt(line);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                    continue;
                }
            }
            try {
                inputHandle(reader);
            } catch (InvalidInput e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e){
                System.out.println("Bad input.");
                reader.nextLine();
                whatToDo(reader);
            }
        }
    }

    protected static void inputHandle(Scanner reader) throws InvalidInput, InputMismatchException{
        if (!(0 > input || input > 4)) {
            if (input == 1) {
                try{handleInput1(reader);} catch (InvalidInput e) {
                    System.out.println(e.getMessage());
                    handleInput1(reader);
                }
            } else if (input == 2) {
                try{handleInput2(reader);} catch (InvalidInput e){
                    System.out.println(e.getMessage());
                    handleInput2(reader);
                }
            } else if (input == 3) {
                handleInput3(reader);
            } else if (input == 4) {
                handleInput4(reader);
            }
        } else throw new InvalidInput(input);
    }

    private static void handleInput1(Scanner reader) throws InvalidInput{
        System.out.println("Press 1 to add work out, 2 to add a meal.");
        input = reader.nextInt();
        if (input == 1){
            System.out.println("Adding a workout on a day that already has a workout will delete that workout.");
            addWorkOut(reader);
        } else if (input == 2){
            System.out.println("Adding a meal at the same time as another meal will delete that meal.");
            addMeal(reader);
        } else throw new InvalidInput(input);

    }

    private static void handleInput2(Scanner reader) throws InvalidInput{
        System.out.println("Press 1 to find a workout, 2 to find a meal.");
        input = reader.nextInt();
        if (input == 1){
            findWorkOut(reader);
        } else if (input == 2){
            findMeal(reader);
        } else throw new InvalidInput(input);
    }

    private static void handleInput3(Scanner reader){
        System.out.println("What would you like to name the current plan?");
        newName = reader.nextLine();
        Path pathWorkOuts = createPlanWorkOuts(newName);
        Path pathMeals = createPlanMeals(newName);
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
        System.out.println("What plan would you like to load?");
        newName = reader.nextLine();
        Path pathWorkOuts = loadPlanWorkOuts(newName);
        Path pathMeals = loadPlanMeals(newName);
        if(pathMeals == null && pathWorkOuts == null){
            System.out.println("That plan is not found, please try again.");
            handleInput4(reader);
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
}
