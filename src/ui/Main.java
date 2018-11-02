package ui;

import java.util.*;

import static ui.DateAndTime.dateHandler;
import static ui.DateAndTime.isItTime;
import static ui.HandleMeal.generateMeals;
import static ui.HandleMeal.meals;
import static ui.HandleWorkOut.generateWorkOuts;
import static ui.HandleWorkOut.workOuts;
import static ui.HandlesInput.whatToDo;

public class Main {
    public static String name;


    private static void hello() {
        System.out.println("type \"quit\" at any time to quit");
        System.out.println("Hello, what is your name?");
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        generateWorkOuts();
        generateMeals();
        dateHandler();
        hello();
        name = reader.nextLine();
        isItTime(workOuts, meals);
        whatToDo(reader);
    }
}
