package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ListOfMeals implements ListInterface {
    List<Meals> meals = new ArrayList<>();

    public List<Meals> getMeals(){
        return meals;
    }


    public void add(Meals meal) {
        meals.add(meal);
    }


    public void remove(Meals meal) {
        meals.remove(meal);
    }


    // REQUIRES: New meals parameters
    // MODIFIES: this
    // EFFECTS:  Adds a meal to the list, deletes a meal if the time given is the same
    public void addMeal(String name, int time, String foodPlan) {
        Meals meal = new Meals(name, time, foodPlan);
        if (!(time < 0 || time >= 24)) {
            for (int i = 0; i < meals.size(); i++) {
                if (time == meals.get(i).getTime()) {
                    System.out.println(meals.get(i).getName() + " has been removed.");
                    meals.remove(i);
                    meals.add(meal);
                    System.out.println(name + " has been added.");
                    break;
                }
            }
        }
        if (!meals.contains(meal)) {
            meals.add(meal);
            System.out.println(name + " has been added.");
        }
    }


    // REQUIRES: Meal name
    // MODIFIES: this
    // EFFECTS:  removes a meal with the given name from the list
    public void remove(String name) {
        for (int i = 0; i < meals.size(); i++) {
            if (name.equals(meals.get(i).getName())) {
                System.out.println(meals.get(i).getName() + " is removed.");
                meals.remove(i);
                break;
            }
        }
    }


    // REQUIRES: Meal name
    // MODIFIES: Nothing
    // EFFECTS:  Finds the meal with the given name list and returns true if found, false if not
    public boolean find(String name) {
        int pmTime;
        for (Meals m : meals) {
            if (name.equals(m.getName())) {
                if (m.getTime() < 12) {
                    System.out.println(m.getName() + " is at " + m.getTime() + "am, and you need to eat " + m.getPlan());
                } else {
                    pmTime = m.getTime() - 12;
                    System.out.println(m.getName() + " is at " + pmTime + "pm, and you need to eat " + m.getPlan());
                }
                return true;
            }
        }
        System.out.println("That meal is not found");
        return false;
    }

    @Override
    public void save(Path saveTo) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Meals meal : meals) {
            lines.add(meal.getName() + "," + meal.getTime() + "," + meal.getPlan());
        }
        Files.write(saveTo, lines);
    }

    @Override
    public void load(Path from) throws IOException {
        meals.clear();
        List<String> lines = Files.readAllLines(from);
        for (String workout : lines) {
                String[] split = workout.split(",", 3);
                Meals meal = new Meals(split[0], Integer.parseInt(split[1]), split[2]);
                meals.add(meal);
        }
    }
}


