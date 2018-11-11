package model;

public class Meal extends Event{

    public Meal(String name, int time, String plan) {
        super(name, time, plan);
        super.isAMeal = true;
    }
}


