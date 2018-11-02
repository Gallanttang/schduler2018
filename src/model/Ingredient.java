package model;

import java.util.ArrayList;
import java.util.Objects;

public class Ingredient {
    String name;
    ArrayList<FoodPlan> LOFP;

    public Ingredient(String name, ArrayList<FoodPlan> fp){
        this.name = name;
        LOFP = fp;
    }

    public void addFoodPlan(FoodPlan fp){
        if(!LOFP.contains(fp)){
            LOFP.add(fp);
            fp.addIngredient(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
