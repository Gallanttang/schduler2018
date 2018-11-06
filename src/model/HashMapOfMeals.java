package model;

import Exceptions.InvalidTimeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HashMapOfMeals implements HashMapAbstract {
    private HashMap<Integer, Meals> meals;

    public HashMapOfMeals() {
        meals = new HashMap<>(24);
    }

    public HashMap<Integer, Meals> getMeals() {
        return meals;
    }

    // EFFECTS:  returns the meal at the given index
    public Meals get(Integer t) {
        return meals.get(t);
    }


    // REQUIRES: New meals parameters
    // MODIFIES: this
    // EFFECTS:  Adds a meal to the list, deletes a meal if the time given is the same
    public void addMeal(String name, int time, String plan) throws InvalidTimeException {
        Meals meal = new Meals(name, time, plan);
        if (!(time < 0 || time >= 24)) {
            if (!meals.containsKey(time)) {
                meals.put(time, meal);
                System.out.println(name + " has been added.");
            } else {
                System.out.println(meals.get(time).getName() + " has been removed.");
                meals.remove(time);
                meals.put(time, meal);
                System.out.println(name + " has been added.");
            }
        } else throw new InvalidTimeException(time);
    }


    // MODIFIES: this
    // EFFECTS:  removes a meal at a given time from the list
    public void remove(int time) {
        if (meals.containsKey(time)) {
            meals.remove(time);
        }
        System.out.println("No meal with that time is found");
    }

    // MODIFIES: this
    // EFFECTS:  removes a meal at a given time from the list
    public void remove(String name) {
        for (Map.Entry<Integer, Meals> e: meals.entrySet()) {
            if(e.getValue().getName().equalsIgnoreCase(name)){
                System.out.println(e.getValue().getName() + " has been removed.");
                meals.remove(e.getKey());
                return;
            }
        }
        System.out.println("No meal with that time is found");
    }


    // REQUIRES: Meal name
    // MODIFIES: Nothing
    // EFFECTS:  Finds the meal with the given time and returns true if found, false if not
    public boolean find(String name) {
        int pmTime;
        for (Map.Entry<Integer, Meals> e: meals.entrySet()) {
            if(e.getValue().getName().equalsIgnoreCase(name)){
                if (e.getValue().getTime() < 12) {
                    System.out.println(e.getValue().getName() + " is at " + e.getValue().getTime()
                            + "am, and you need to eat " + e.getValue().getPlan());
                } else {
                    pmTime = e.getValue().time - 12;
                    System.out.println(e.getValue().getName() + " is at " + pmTime +
                            "pm, and you need to eat " + e.getValue().getPlan());
                }
                return true;
            }
        }
        System.out.println("That meal is not found");
        return false;
    }

    // REQUIRES: Meal name
    // MODIFIES: Nothing
    // EFFECTS:  Finds the meal with the given time and returns true if found, false if not
    public boolean find(int time) {
        int pmTime;
        if (meals.containsKey(time)) {
            if (time < 12) {
                System.out.println(meals.get(time).getName() + " is at " + time + "am, and you need to eat " + meals.get(time).getPlan());
            } else {
                pmTime = time - 12;
                System.out.println(meals.get(time).getName() + " is at " + pmTime + "pm, and you need to eat " + meals.get(time).getPlan());
            }
            return true;
        }
        System.out.println("That meal is not found");
        return false;
    }


    @Override
    public void save(Path saveTo) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Map.Entry<Integer, Meals> e: meals.entrySet()) {
            lines.add(e.getValue().getName() + "," + e.getValue().getTime() + "," + e.getValue().getPlan());
        }
            Files.write(saveTo, lines);
        }


    @Override
    public void load(Path from) throws IOException {
        meals.clear();
        List<String> lines = Files.readAllLines(from);
        for (String meal : lines) {
            String[] split = meal.split(",", 3);
            Meals m = new Meals(split[0], Integer.parseInt(split[1]), split[2]);
            meals.put(m.getTime(), m);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMapOfMeals that = (HashMapOfMeals) o;
        return Objects.equals(meals, that.meals);
    }

    @Override
    public int hashCode() {

        return Objects.hash(meals);
    }
}


