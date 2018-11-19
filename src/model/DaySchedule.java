package model;

import java.util.LinkedHashMap;


public class DaySchedule {
    LinkedHashMap<Integer, Event> day = new LinkedHashMap<>(24);
    String name;


    public DaySchedule(String name){
        this.name = name;
        for(int i = 0; i < 24; i++){
            day.put(i, null);
        }
    }

    public LinkedHashMap<Integer, Event> getDaySchedule() {
        return day;
    }

    public void putMeal(Meal m){
        day.replace(m.getTime(), m);
        System.out.println("The meal " + m.name + " has been added on " + name + " at " + m.getTime() + ".");
    }

    public void putWorkOut(WorkOut wo){
        day.replace(wo.getTime(), wo);
        System.out.println("The workout " + wo.name + " has been added on " + name + " at " + wo.getTime() + ".");
    }

    public String getName(){
        return name;
    }
}
