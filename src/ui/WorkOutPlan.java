package ui;

import model.WorkOut;

import java.util.ArrayList;

public class WorkOutPlan {




    public static void main(String[] args) {
        int maxTime = 24;
        int time = 0;
        String day = "";
        String work = "";
        WorkOutPlan workOutPlan = new WorkOutPlan();
        WorkOut workOut = new WorkOut(time, day, work);
        System.out.println("Welcome, Gallant!");
        ArrayList<WorkOut> workOuts = new ArrayList<>();

        WorkOut legs = new WorkOut(19, "Monday", "Squats and lunges");
        WorkOut arms = new WorkOut(19, "Tuesday", "Biceps and triceps exercises");
        WorkOut torso = new WorkOut(19, "Wednesday", "Chest presses, dead lifts, and lat exercise");
        WorkOut core = new WorkOut(19, "Thursday", "Sit ups and leg raises exercises");

        workOuts.add(legs);
        workOuts.add(arms);
        workOuts.add(torso);
        workOuts.add(core);

        for (WorkOut type : workOuts) {
            if(day.equals(type.getDay())) {
            }
        }


    }

}
