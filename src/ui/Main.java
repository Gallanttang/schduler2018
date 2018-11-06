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
    public static String name = "Gallant";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        generateWorkOuts();
        generateMeals();
        dateHandler();
        System.out.println("type \"quit\" at any time to quit");
        isItTime(workOuts, meals);
        whatToDo(reader);
    }
}