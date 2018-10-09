package Test;

import model.Meals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestMeal {

    Meals breakfast = new Meals("Breakfast", 7, "Hey it's 7! The sun is rising, " +
            "it's time for breakfast! Eat 2 eggs and an apple");


    @Test
    public void testChangingParameters() {
        breakfast.changeName("First Meal");
        breakfast.changeTime(8);
        breakfast.changePlan("It's time for breakfast! Get some cereal and almond milk.");
        assertTrue(breakfast.getName() == "First Meal");
        assertTrue(breakfast.getTime() == 8);
        assertTrue(breakfast.getPlan() == "It's time for breakfast! Get some cereal and almond milk.");
    }


}
