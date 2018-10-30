package Test;

import Exceptions.InvalidTimeException;

import model.HashMapOfMeals;

import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class TestListOfMeals {
    String mealName;
    int time;
    String foodPlan;


    @Test
    public void testAddMeal() {
        HashMapOfMeals ml = new HashMapOfMeals();

        try {
            ml.addMeal("Breakfast", 7, "Hey it's 7! The sun is rising, " +
                    "it's time for breakfast! Eat 2 eggs and an apple");

            ml.addMeal("Lunch", 13, "Eat pasta with any sauce and protein of choice" +
                    "Hey it's 13! The sun is up high, it's time for lunch!");
            ml.addMeal("Dinner", 19, "Hey it's 19! The sun is setting, it's time for dinner!" +
                    " Eat whatever you want, it's been a long day");
            mealName = "a";
            time = 7;
            foodPlan = "";

            ml.addMeal(mealName, time, foodPlan);
        } catch (InvalidTimeException e) {
            fail();
        }
        assertTrue(ml.find("a"));
        assertFalse(ml.find("Breakfast"));
    }

    @Test
    public void testRemoveMeal() {
        HashMapOfMeals ml = new HashMapOfMeals();
        try {
            ml.addMeal("Breakfast", 7, "Hey it's 7! The sun is rising, " +
                    "it's time for breakfast! Eat 2 eggs and an apple");
            ml.addMeal("Lunch", 13, "Eat pasta with any sauce and protein of choice" +
                    "Hey it's 13! The sun is up high, it's time for lunch!");
            ml.addMeal("Dinner", 19, "Hey it's 19! The sun is setting, it's time for dinner!" +
                    " Eat whatever you want, it's been a long day");
            mealName = "a";
            time = 7;
            foodPlan = "";
            ml.addMeal(mealName, time, foodPlan);
            ml.remove("Dinner");
        } catch (InvalidTimeException e) {

        }
        assertTrue(ml.find("a"));
        assertFalse(ml.find("Breakfast"));
        assertFalse(ml.find("Dinner"));
    }

    @Test
    public void testExceptions() {
        HashMapOfMeals ml = new HashMapOfMeals();

        try {
            ml.addMeal("Breakfast", -1, "Hey it's 7! The sun is rising, " +
                    "it's time for breakfast! Eat 2 eggs and an apple");
        } catch (InvalidTimeException e) {
        }
        try {
            ml.addMeal("Lunch", 13, "Eat pasta with any sauce and protein of choice" +
                    "Hey it's 13! The sun is up high, it's time for lunch!");
            ml.addMeal("Dinner", 19, "Hey it's 19! The sun is setting, it's time for dinner!" +
                    " Eat whatever you want, it's been a long day");
        } catch (InvalidTimeException e) {
            fail();
        }

        mealName = "a";
        time = 7;
        foodPlan = "";

        try {
            ml.addMeal(mealName, time, foodPlan);
        } catch (InvalidTimeException e) {
            fail();
        }

        assertTrue(ml.find("a"));
        assertFalse(ml.find("Breakfast"));
    }
}


