package Test;

import P8.Recipe;
import P8.Ingredient;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestReflexive {
    ArrayList<Ingredient> testLOI = new ArrayList<>();
    ArrayList<Recipe> testLOFP = new ArrayList<>();

    Recipe fp = new Recipe("testFP", testLOI);
    Recipe fp2 = new Recipe("testFP", testLOI);
    Ingredient i = new Ingredient("testI", testLOFP);

    @Test
    public void testEquals() {
        fp.add(i);
        assertTrue(fp.equals(fp2));
    }
}
