package model;

public class WorkOut implements Basic{
    private String name;
    private String day;
    private String plan;

    public WorkOut (String name, String day, String plan){
        this.name = name;
        this.day = day;
        this.plan = plan;
    }

    // REQUIRES: WorkOut
    // MODIFIES: NOTHING
    // EFFECTS: returns the name parameter in WorkOut
    @Override
    public String getName() { return name; }

    // REQUIRES: WorkOut
    // MODIFIES: NOTHING
    // EFFECTS: returns the day parameter in WorkOut
    public String getDay() {
        return day;
    }

    // REQUIRES: WorkOut
    // MODIFIES: NOTHING
    // EFFECTS:  returns the plan parameter in WorkOuts
    @Override
    public String getPlan() { return plan; }

    // REQUIRES: WorkOut and a new name parameter
    // MODIFIES: NOTHING
    // EFFECTS:  Changes the name parameter in WorkOuts
    public void changeName(String newName) {
        this.name = newName;
    }

    // REQUIRES: WorkOut and a new day parameter
    // MODIFIES: NOTHING
    // EFFECTS:  Changes the day parameter in WorkOuts
    public void changeDay(String newDay) {
        this.day = newDay;
    }

    // REQUIRES: WorkOut and a new work parameter
    // MODIFIES: NOTHING
    // EFFECTS:  Changes the work parameter in WorkOuts
    public void changePlan(String newWork) {
        this.plan = newWork;
    }

}
