package model;

public class Meals extends Event{
    boolean isAMeal = true;
    public Meals(String name, int time, String plan) {
        super(name, time, plan);
        super.isAMeal = true;
    }
}


