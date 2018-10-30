package Test;

import model.WorkOut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.HashMapOfWorkOuts;

import java.io.File;
import java.io.IOException;

public class TestSaveAndLoad{


        HashMapOfWorkOuts test = new HashMapOfWorkOuts();
        WorkOut legs = new WorkOut("Legs", 18,"Monday", "Squats and lunges");
        WorkOut arms = new WorkOut("Arms", 18,"Tuesday", "Biceps curls and triceps dips");
        WorkOut torso = new WorkOut("Torso", 18,"Wednesday", "Bench Presses and pull ups");
        WorkOut core = new WorkOut("Core", 18,"Thursday", "Sit ups and leg raises exercises");
        WorkOut cardio = new WorkOut("Cardio",18, "Friday", "Run 2.4km and do 5 minutes of power rope");
        WorkOut back = new WorkOut("Back",18, "Saturday", "Dead lifts and lats pull down");
        WorkOut rest = new WorkOut("Rest", 18,"Sunday", "no working out today");
        WorkOut neck = new WorkOut("Neck", 18,"Monday", "programming");




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
