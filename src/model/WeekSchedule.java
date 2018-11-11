package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekSchedule {
    HashMap<String, DaySchedule> weekSchedule = new HashMap<>(7);
    List<String> days = new ArrayList<>();
    DaySchedule DS;

    public WeekSchedule() {
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");
        for (String s : days) {
            weekSchedule.put(s, DS = new DaySchedule(s));
        }
    }

    public HashMap<String, DaySchedule> getWeekSchedule() {
        return weekSchedule;
    }

    public DaySchedule getDS() {
        return DS;
    }

    public void putWorkOut(WorkOut wo) {
        for (Map.Entry<String, DaySchedule> entry : weekSchedule.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(wo.day)) {
                entry.getValue().putWorkOut(wo);
            }
        }
    }

    public void putMeal(Meal m) {
        for (Map.Entry<String, DaySchedule> entry : weekSchedule.entrySet()) {
            entry.getValue().putMeal(m);
        }
    }

    //Requires: Path
    //Modifies: Nothing
    //Effects:  creates a new file with existing work out plan
    public void save(Path saveTo) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        for (Map.Entry<String, DaySchedule> e : weekSchedule.entrySet()) {
            for (Map.Entry<Integer, Event> entry : e.getValue().day.entrySet()) {
                if (entry.getValue() != null) {
                        lines.add(e.getKey() + "," + entry.getValue().name
                                + "," + entry.getValue().time + "," + entry.getValue().plan + "," + entry.getValue().isAMeal);
                }
            }
            Files.write(saveTo, lines);
        }
    }

    //Requires: User Input
    //Modifies: this
    //Effects:  Over rides existing plan with a plan from a txt document
    public void load(Path from) throws IOException {
        weekSchedule.clear();
        for (String s : days) {
            weekSchedule.put(s, DS = new DaySchedule(s));
        }

        List<String> lines = Files.readAllLines(from);
        for (String string : lines) {
            String[] split = string.split(",", 6);
            if(split[5].equalsIgnoreCase("true")){
               Meal m = new Meal(split[1],Integer.parseInt(split[2]),split[3]);
               putMeal(m);
            } else {
                WorkOut wo = new WorkOut(split[1], Integer.parseInt(split[2]), split[3], split[0]);
                putWorkOut(wo);
            }
        }
    }
}
