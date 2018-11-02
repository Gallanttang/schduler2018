package model;

import java.util.ArrayList;
import java.util.Objects;

public class FoodPlan {
    String name;
    ArrayList<Ingredient> LOI;

    public FoodPlan(String name, ArrayList<Ingredient> LOI){
        this.name = name;
        this.LOI = LOI;
    }

    public void addIngredient(Ingredient i){
        if(LOI.contains(i)){
            LOI.add(i);
            i.addFoodPlan(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodPlan foodPlan = (FoodPlan) o;
        return Objects.equals(name, foodPlan.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
