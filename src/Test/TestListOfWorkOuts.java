package Test;

import model.ListOfWorkOuts;
import model.WorkOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestListOfWorkOuts {

    String workOutName;
    String day;
    String work;

    WorkOut legs = new WorkOut("Legs", "Monday", "Squats and lunges");
    WorkOut arms = new WorkOut("Arms", "Tuesday", "Biceps curls and triceps dips");
    WorkOut torso = new WorkOut("Torso", "Wednesday", "Bench Presses and pull ups");
    WorkOut core = new WorkOut("Core", "Thursday", "Sit ups and leg raises exercises");
    WorkOut cardio = new WorkOut("Cardio", "Friday", "Run 2.4km and do 5 minutes of power rope");
    WorkOut back = new WorkOut("Back", "Saturday", "Dead lifts and lats pull down");
    WorkOut rest = new WorkOut("Rest", "Sunday", "no working out today");
    WorkOut leg = new WorkOut("Leg", "Monday", "Squats and lunges");

    @Test
    public void testAddWorkOut() {
        ListOfWorkOuts workOuts = new ListOfWorkOuts();

        workOuts.add(legs);
        workOuts.add(arms);
        workOuts.add(torso);
        workOuts.add(core);
        workOuts.add(cardio);
        workOuts.add(back);
        workOuts.add(rest);
        workOuts.addAndReplace("Leg", "Monday", "Squats and lunges");

        assertFalse(workOuts.find("Legs"));
        assertTrue(workOuts.find("Leg"));
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
    public void testChangeWork(){
        ListOfWorkOuts workOuts = new ListOfWorkOuts();

        workOuts.add(legs);
        workOuts.add(arms);
        workOuts.add(torso);
        workOuts.add(core);
        workOuts.add(cardio);
        workOuts.add(back);
        workOuts.add(rest);

        workOuts.changeWork("Legs", "Squats and Box Jumps");

        assertEquals("Squats and Box Jumps",workOuts.get(0).getPlan());
    }

}
