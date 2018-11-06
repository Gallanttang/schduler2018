package ui;

import model.*;

import java.util.Map;

import static ui.HandleMeal.meals;
import static ui.HandleWorkOut.workOuts;

public class HandleSchedule {

    static WeekSchedule  ws = new WeekSchedule();

    public static void generateSchedule(){
        for (Map.Entry<String, DaySchedule> entry : ws.getWeekSchedule().entrySet()) {
            for (Map.Entry<Integer, Meals> m: meals.getMeals().entrySet()) {
                entry.getValue().putMeal(m.getValue());
            }
            for (Map.Entry<String, WorkOut> wo: workOuts.getWorkOuts().entrySet()) {
                if(wo.getValue().getDay().equalsIgnoreCase(entry.getKey())){
                    entry.getValue().putWorkOut(wo.getValue());
                }
            }
        }
    }
}
