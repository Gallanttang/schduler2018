package Test;

import model.FoodPlan;
import model.Ingredient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestReflexive {
    ArrayList<Ingredient> testLOI = new ArrayList<>();
    ArrayList<FoodPlan> testLOFP = new ArrayList<>();

    FoodPlan fp = new FoodPlan("testFP", testLOI);
    FoodPlan fp2 = new FoodPlan("testFP", testLOI);
    Ingredient i = new Ingredient("testI", testLOFP);

    @Test
    public void testEquals() {
        fp.addIngredient(i);
        assertTrue(fp.equals(fp2));
    }
}
