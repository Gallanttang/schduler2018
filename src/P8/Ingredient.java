package P8;

import java.util.ArrayList;
import java.util.Objects;

public class Ingredient extends Observer {
    String name;
    private ArrayList<Recipe> LOFP;

    public Ingredient(String name, ArrayList<Recipe> fp){
        this.name = name;
        LOFP = fp;
    }

    public void addFoodPlan(Recipe fp){
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

    @Override
    public void update(Recipe fp) {
        System.out.println(this.name + " has been added to " + fp.name);
    }
}
