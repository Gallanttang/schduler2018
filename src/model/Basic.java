package model;

public abstract class Basic{

    String name;
    int time;
    String plan;

    // REQUIRES: Meal or workout
    // MODIFIES: NOTHING
    // EFFECTS: returns the name parameter
    public String getName() {
        return name;
    }

    // REQUIRES: Meal or workout
    // MODIFIES: NOTHING
    // EFFECTS: returns the plan parameter
    public String getPlan(){
        return plan;
    }

    // REQUIRES: Meal or workout
    // MODIFIES: NOTHING
    // EFFECTS: returns the time parameter
    public int getTime(){
        return time;
    }

    // REQUIRES: Meal or workout
    // MODIFIES: NOTHING
    // EFFECTS:  Changes the name parameter
    public void changeName(String newName){
        this.name = newName;
    }

    // REQUIRES: Meal or workout
    // MODIFIES: NOTHING
    // EFFECTS:  Changes the name parameter
    public void changeTime(int newTime){
        this.time = newTime;
    }

    // REQUIRES: Meal or workout
    // MODIFIES: NOTHING
    // EFFECTS:  Changes the name parameter
    public void changePlan(String newFP){
        this.plan = newFP;
    }
}
