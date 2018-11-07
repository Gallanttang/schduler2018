package ui;

import model.*;

import java.util.Map;

import static ui.HandleMeal.meals;
import static ui.HandleWorkOut.workOuts;

public class HandleSchedule {

    public static WeekSchedule  ws = new WeekSchedule();
    final static Meals breakfast = new Meals("Breakfast", 7, "Hey it's 7! The sun is rising, " +
            "it's time for breakfast! Eat 2 eggs and an apple");
    final static Meals lunch = new Meals("Lunch", 13, "Hey it's 13! The sun is up high, it's time for lunch! " +
            "Eat pasta with any sauce and protein of choice");
    final static Meals dinner = new Meals("Dinner", 19, "Hey it's 19! The sun is setting, it's time for dinner!" +
            " Eat whatever you want, it's been a long day");

    final static WorkOut legs = new WorkOut("Legs", 18, "Squats and lunges", "Monday");
    final static WorkOut arms = new WorkOut("Arms", 18, "Biceps curls and triceps dips", "Tuesday");
    final static WorkOut torso = new WorkOut("Torso", 18, "Bench Presses and pull ups", "Wednesday");
    final static WorkOut core = new WorkOut("Core", 18, "Sit ups and leg raises exercises", "Thursday");
    final static WorkOut cardio = new WorkOut("Cardio", 18, "Run 2.4km and do 5 minutes of power rope", "Friday");
    final static WorkOut back = new WorkOut("Back", 18, "Dead lifts and lats pull down", "Saturday");
    final static WorkOut rest = new WorkOut("Rest", 18, "no working out today", "Sunday");


    public static void generateSchedule(){
        ws.putMeal(breakfast);
        ws.putMeal(lunch);
        ws.putMeal(dinner);
        ws.putWorkOut(legs);
        ws.putWorkOut(arms);
        ws.putWorkOut(torso);
        ws.putWorkOut(core);
        ws.putWorkOut(cardio);
        ws.putWorkOut(back);
        ws.putWorkOut(rest);
        }
    public static void printOutSchedule(){
        for (Map.Entry<String, DaySchedule> entry: ws.getWeekSchedule().entrySet()) {
            for(Map.Entry<Integer, Event> e: entry.getValue().getDaySchedule().entrySet()) {
                if(e.getValue() != null)
                    System.out.println(entry.getValue().getName() + " " + e.getKey() + " " + e.getValue().getName());
            }
        }
    }
}
