package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekSchedule {
    HashMap<String, DaySchedule> weekSchedule = new HashMap<>(7);
    List<String> days = new ArrayList<>();
    DaySchedule DS;

    public WeekSchedule(){
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        for (String s: days) {
            weekSchedule.put(s, DS = new DaySchedule(s));
        }
    }

    public HashMap<String, DaySchedule> getWeekSchedule(){
        return weekSchedule;
    }

    public DaySchedule getDS() {
        return DS;
    }

    public void putWorkOut(WorkOut wo){
        for (Map.Entry<String, DaySchedule> entry: weekSchedule.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(wo.day)){
                entry.getValue().putWorkOut(wo);
            }
        }
    }

    public void putMeal(Meals m){
        for (Map.Entry<String, DaySchedule> entry: weekSchedule.entrySet()) {
            entry.getValue().putMeal(m);
        }
    }


}
