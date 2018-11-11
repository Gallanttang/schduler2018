package ui;

import java.io.IOException;
import java.util.*;

import static ui.DateAndTime.dateHandler;
import static ui.DateAndTime.isItTime;
import static ui.HandleMeal.generateMeals;
import static ui.HandleMeal.meals;
import static ui.HandleWorkOut.generateWorkOuts;
import static ui.HandleWorkOut.workOuts;
import static ui.HandlesInput.whatToDo;
import static ui.Web.weather;

public class Main {
    public static String name = "Gallant";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try{weather();} catch (IOException e) {System.out.println("Weather cannot be found");}
        generateWorkOuts();
        generateMeals();
        dateHandler();
        System.out.println("type \"quit\" at any time to quit");
        isItTime(workOuts, meals);
        whatToDo(reader);
    }
}