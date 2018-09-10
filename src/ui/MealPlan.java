package ui;



public class MealPlan {

    private String username = "Gallant Tang";

    private MealPlan() {
        System.out.println("Hello, " + username + "!");
    }

    private void breakfast() {
        System.out.println("The sun is rising, it's time for breakfast!");
    }

    private void lunch() {
        System.out.println("The sun is up high, it's time for lunch!");
    }

    private void dinner() {
        System.out.println("The sun is setting, it's time for dinner!");
    }


    public static void main(String args[]) {
        MealPlan mealPlan = new MealPlan();

        int time = 13;

        if (time < 13) {
            mealPlan.breakfast();
        } else {
            if (time < 18) {
                mealPlan.lunch();
            } else {
                mealPlan.dinner();
            }
        }
    }
}




