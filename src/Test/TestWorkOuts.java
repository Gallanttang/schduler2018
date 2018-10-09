package Test;



import static org.junit.jupiter.api.Assertions.assertTrue;

import model.WorkOut;
import org.junit.jupiter.api.Test;

public class TestWorkOuts {

    WorkOut legs = new WorkOut("Legs", 18,"Monday", "Squats and lunges");

    @Test
    public void testChangingParameters() {
        legs.changeName("Arms");
        legs.changeDay("Tuesday");
        legs.changePlan("Biceps curls and triceps dips");
        assertTrue(legs.getName() == "Arms");
        System.out.println(legs.getDay());
        assertTrue(legs.getDay() == "Tuesday");
        assertTrue(legs.getPlan() == "Biceps curls and triceps dips");
    }
}


