package model;

import java.util.HashMap;
import java.util.Map;

public class Schedule {
    String name;
    HashMap<Integer, HashMap.Entry> schedule = new HashMap<>(24);
    public void Schedule(HashMapOfWorkOuts wo, HashMapOfMeals m){
        for(int i = 0; i < 24; i++){
            schedule.put(i, null);
        }
        for (Map.Entry<String, WorkOut> entry :wo.getWorkOuts().entrySet()) {
            schedule.replace(entry.getValue().getTime(), entry);
        }
        for (Map.Entry<Integer, Meals> entry :m.getMeals().entrySet()) {
            schedule.replace(entry.getKey(), entry);
        }
    }
}
