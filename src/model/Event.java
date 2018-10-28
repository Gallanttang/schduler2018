package model;

public abstract class Event{
    String name;
    int time;
    String plan;

    // REQUIRES: this
    // MODIFIES: NOTHING
    // EFFECTS: returns the name parameter
    public String getName() {
        return name;
    }

    // REQUIRES: this
    // MODIFIES: NOTHING
    // EFFECTS: returns the plan parameter
    public String getPlan(){
        return plan;
    }

    // REQUIRES: this
    // MODIFIES: NOTHING
    // EFFECTS: returns the time parameter
    public int getTime(){
        return time;
    }

    // REQUIRES: this
    // MODIFIES: NOTHING
    // EFFECTS:  Changes the name parameter
    public void changeName(String newName){
        this.name = newName;
    }

    // REQUIRES: this
    // MODIFIES: NOTHING
    // EFFECTS:  Changes the name parameter
    public void changeTime(int newTime){
        this.time = newTime;
    }

    // REQUIRES: this
    // MODIFIES: NOTHING
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
