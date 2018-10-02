package model;

public class Meals implements Basic{

    private String name;
    private int time;
    private String plan;

    public Meals(String name, int time, String Plan) {
        this.name = name;
        this.time = time;
        this.plan = Plan;
    }

    // REQUIRES: Meals
    // MODIFIES: NOTHING
    // EFFECTS: returns the plan parameter in Meals
    public String getPlan() {
        return plan;
    }

    // REQUIRES: Meals
    // MODIFIES: NOTHING
    // EFFECTS: returns the time parameter in Meals
    public int getTime() {
        return time;
    }

    // REQUIRES: Meals
    // MODIFIES: NOTHING
    // EFFECTS: returns the Name parameter in Meals
    public String getName(){
        return name;
    }

    // REQUIRES: Meals
    // MODIFIES: this
    // EFFECTS: Changes the name of the meal
    public void changeName(String newName){
        this.name = newName;
    }

    // REQUIRES: Meals
    // MODIFIES: this
    // EFFECTS: Changes the time of the meal
    public void changeTime(int newTime){
        this.time = newTime;
    }

    // REQUIRES: Meals
    // MODIFIES: this
    // EFFECTS: Changes the time of the meal
    public void changeFoodPlan(String newFP){
        this.plan = newFP;
    }

}


