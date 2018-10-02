package ui;

import model.ListOfWorkOuts;
import model.Meals;
import model.WorkOut;

import java.util.ArrayList;
import java.util.List;


public class HealthPlan {
    int time;

    private String username;

    final int maxHours = 24;


    String day;

    public HealthPlan(String day, int time, String name) {
        this.day = day;
        this.time = time;
        this.username = name;
    }

    public void greeting(){
        System.out.println("Hello, " + username + "!");
    }

    ArrayList<Meals> mls = new ArrayList();
    final Meals breakfast = new Meals("Breakfast", 7, "Hey it's 7! The sun is rising, " +
            "it's time for breakfast! Eat 2 eggs and an apple");
    final Meals lunch = new Meals("Lunch", 13, "Eat pasta with any sauce and protein of choice" +
            "Hey it's 13! The sun is up high, it's time for lunch!");
    final Meals dinner = new Meals("Dinner", 19, "Hey it's 19! The sun is setting, it's time for dinner!" +
            " Eat whatever you want, it's been a long day");


    // EFFECTS: tells you what to do at a given time and day
    public void planHealth(int time, ListOfWorkOuts workOuts) {

        if (time == breakfast.getTime()) {
            System.out.println(breakfast.getPlan());
        } else if (time == lunch.getTime()) {
            System.out.println(lunch.getPlan());
        } else if (time == dinner.getTime()) {
            System.out.println(dinner.getPlan());
        } else if (time == 18) {
            for (int i = 0; i < workOuts.size(); i++) {
                if (workOuts.get(i).getDay() == day) {
                    System.out.println("It's " + day + " let's work out " + workOuts.get(i).getName() + " before dinner!");
                    System.out.println("Do some " + workOuts.get(i).getPlan() + "!");
                }
            }
        } else if (time == maxHours) {
            System.out.print("It's late, time to get some sleep");
        } else {
            if (time < 12) {
                System.out.println("It's " + time + "am, that's not time to eat!");
            } else if (time == 12) {
                System.out.println(time + "pm, that's not time to eat!");
            } else {
                int newTime = time - 12;
                System.out.println("It's " + newTime + "pm, that's not time to eat!");
            }
        }
    }



}