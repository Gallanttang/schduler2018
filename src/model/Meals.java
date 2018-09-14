package model;

public class Meals {

    private int time;
    private String foodPlan;

    public Meals(int time, String foodPlan) {
        this.time = time;
        this.foodPlan = foodPlan;
    }

    public String getFoodPlan() {
        return foodPlan;
    }

    public int getTime() {
        return time;
    }
}

