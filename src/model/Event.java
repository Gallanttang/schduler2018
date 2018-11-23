package model;

public abstract class Event{
    String name;
    int time;
    String plan;
    boolean isAMeal;

    // EFFECTS: returns the name parameter
    public String getName() {
        return name;
    }

    // EFFECTS: returns the plan parameter
    public String getPlan(){
        return plan;
    }

    // EFFECTS: returns the time parameter
    public int getTime(){
        return time;
    }

    public Boolean getIsAMeal(){
        return isAMeal;
    }

    // MODIFIES: name
    // EFFECTS:  Changes the name parameter
    public void changeName(String newName){
        this.name = newName;
    }

    // MODIFIES: time
    // EFFECTS:  Changes the name parameter
    public void changeTime(int newTime){
        this.time = newTime;
    }

    // MODIFIES: plan
    // EFFECTS:  Changes the name parameter
    public void changePlan(String newFP){
        this.plan = newFP;
    }

    public Event(String name, int time, String plan){
        this.name = name;
        this.time = time;
        this.plan = plan;
    }

}
