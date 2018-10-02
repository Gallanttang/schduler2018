package Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.WorkOut;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.ListOfWorkOuts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public class TestSaveAndLoad{


        ListOfWorkOuts test = new ListOfWorkOuts();
        WorkOut legs = new WorkOut("Legs", "Monday", "Squats and lunges");
        WorkOut arms = new WorkOut("Arms", "Tuesday", "Biceps curls and triceps dips");
        WorkOut torso = new WorkOut("Torso", "Wednesday", "Bench Presses and pull ups");
        WorkOut core = new WorkOut("Core", "Thursday", "Sit ups and leg raises exercises");
        WorkOut cardio = new WorkOut("Cardio", "Friday", "Run 2.4km and do 5 minutes of power rope");
        WorkOut back = new WorkOut("Back", "Saturday", "Dead lifts and lats pull down");
        WorkOut rest = new WorkOut("Rest", "Sunday", "no working out today");
        WorkOut neck = new WorkOut("Neck", "Monday", "programming");




    @Test
    public void testSave() throws IOException {
        test.add(neck);
        test.add(arms);
        test.add(torso);
        test.add(core);
        test.add(cardio);
        test.add(back);
        test.add(rest);

        File file = new File("test.txt");
        test.save(file.toPath());
        Assertions.assertTrue(file.exists());
    }

    @Test
    public void testLoad() throws IOException {
        test.add(legs);
        test.add(arms);
        test.add(torso);
        test.add(core);
        test.add(cardio);
        test.add(back);
        test.add(rest);
        File file = new File("test.txt");
        test.load(file.toPath());
        Assertions.assertTrue(test.find("Monday")&&test.find("Sunday"));
    }
}
