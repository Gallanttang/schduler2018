package ui;


import model.Meals;

public class MealPlan {
    int time;

    private String username;

    final int maxHours = 24;
    final Meals breakfast = new Meals(7, "Eat 2 eggs and an apple");
    final Meals lunch = new Meals(13, "Eat pasta with a sauce and protein of choice");
    final Meals dinner = new Meals(19, "Eat whatever you want, it's been a long day");

    public MealPlan(int time, String name) {
        this.time = time;
        this.username = name;
    }

    public void greeting() {
        System.out.println("Hello, " + username + "!");
    }

    private void breakfastTime() {
        System.out.println("The sun is rising, it's time for breakfast!");
    }

    private void lunchTime() {

        System.out.println("The sun is up high, it's time for lunch!");
    }

    private void dinnerTime() {

        System.out.println("The sun is setting, it's time for dinner!");
    }


    public void notTime() {

        if (time == breakfast.getTime()) {
            breakfastTime();
            System.out.println(breakfast.getFoodPlan());
            time++;

        } else if (time == lunch.getTime()) {
            lunchTime();
            System.out.println(lunch.getFoodPlan());
            time++;

        } else if (time == dinner.getTime()) {
            dinnerTime();
            System.out.println(dinner.getFoodPlan());
            time++;

        } else {
            System.out.println("It's " + time + " that's not time to eat!");
            time++;
            notTime();
        } if (time == maxHours) {
            time = 0;
            System.out.print("It's late, time to get some sleep");
        }
    }
}



