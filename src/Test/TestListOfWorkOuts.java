package Test;

import Exceptions.InvalidDayException;
import Exceptions.InvalidTimeException;
import model.ListOfWorkOuts;
import model.WorkOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestListOfWorkOuts {

    WorkOut legs = new WorkOut("Legs", 18, "Squats and lunges", "Monday");
    WorkOut arms = new WorkOut("Arms", 18, "Biceps curls and triceps dips", "Tuesday");
    WorkOut torso = new WorkOut("Torso", 18, "Bench Presses and pull ups", "Wednesday");
    WorkOut core = new WorkOut("Core", 18, "Sit ups and leg raises exercises", "Thursday");
    WorkOut cardio = new WorkOut("Cardio", 18, "Run 2.4km and do 5 minutes of power rope", "Friday");
    WorkOut back = new WorkOut("Back", 18, "Dead lifts and lats pull down", "Saturday");
    WorkOut rest = new WorkOut("Rest", 18, "no working out today", "Sunday");
    WorkOut leg = new WorkOut("Leg", 18, "Monday", "Squats and lunges");

    @Test
    public void testAddWorkOut() {
        ListOfWorkOuts workOuts = new ListOfWorkOuts();
        try {
            workOuts.add(legs);
            workOuts.add(arms);
            workOuts.add(torso);
            workOuts.add(core);
            workOuts.add(cardio);
            workOuts.add(back);
            workOuts.add(rest);
            workOuts.addAndReplace("Leg", 18, "Squats and lunges", "Monday");
        } catch (InvalidTimeException | InvalidDayException e) {
        }

        assertTrue(workOuts.find("Tuesday"));
    }


    @Test
    public void testRemoveWorkOut() {
        ListOfWorkOuts workOuts = new ListOfWorkOuts();

        workOuts.add(legs);
        workOuts.add(arms);
        workOuts.add(torso);
        workOuts.add(core);
        workOuts.add(cardio);
        workOuts.add(back);
        workOuts.add(rest);
        workOuts.remove("Monday");

        assertFalse(workOuts.find("Legs"));
    }

    @Test
    public void testChangeWork() {
        ListOfWorkOuts workOuts = new ListOfWorkOuts();

        workOuts.add(legs);
        workOuts.add(arms);
        workOuts.add(torso);
        workOuts.add(core);
        workOuts.add(cardio);
        workOuts.add(back);
        workOuts.add(rest);

        workOuts.changeWork("Legs", "Squats and Box Jumps");

        assertEquals("Squats and Box Jumps", workOuts.get(0).getPlan());
    }

}
