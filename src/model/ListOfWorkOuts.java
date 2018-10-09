package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ListOfWorkOuts extends ListInterface{
     List<WorkOut> workOuts = new ArrayList<>();

    public List<WorkOut> getWorkOuts() {
        return workOuts;
    }

    // REQUIRES: New work out parameters
    // MODIFIES: this
    // EFFECTS:  Adds a WorkOut to the list and removes a work out that is on the same day
    public void add(WorkOut w){
        workOuts.add(w);
    }

    //Requires: A workout
    //Modifies: this
    //Effects:  removes that work out from the list if it exists in the list
    public void remove(WorkOut w){
        workOuts.remove(w);
    }

    // REQUIRES: index of work out (0<= i < workOut.size())
    // MODIFIES: nothing
    // EFFECTS:  returns work out in that position
    public WorkOut get(int i){
        return workOuts.get(i);
    }

    //Requires: Work Out list
    //Modifies: Nothing
    //Effects:  Returns the size of the list
    public int size() { return workOuts.size(); }

    //Requires: User Input
    //Modifies: this
    //Effects:  Over rides existing plan with a loaded plan
    public void addAndReplace(String name, int time, String work, String day) {
        WorkOut WO = new WorkOut(name, time, work, day);
        if(!workOuts.contains(WO)){
            workOuts.add(WO);
            System.out.println(WO.getName() + " has been added on " + WO.getDay());
        }
        for (WorkOut wo: workOuts) {
            if(!wo.equals(WO)){
                if(wo.getDay().equalsIgnoreCase(WO.getDay())){
                    System.out.println(wo.getName() + " on " + wo.getDay() + " has been removed");
                    workOuts.remove(wo);
                    break;
                }
            }
        }
    }

    //Requires: Path
    //Modifies: Nothing
    //Effects:  creates a new file with existing work out plan
    @Override
    public void save(Path saveTo) throws IOException{
        List<String> lines = new ArrayList<>();
        for(WorkOut wo : workOuts) {
            lines.add(wo.getName() +  ","+ Integer.toString(wo.getTime()) + ","+ wo.getDay() + "," + wo.getPlan());
        }
        Files.write(saveTo, lines);
    }

    //Requires: User Input
    //Modifies: this
    //Effects:  Over rides existing plan with a plan from a txt document
    @Override
    public void load(Path from) throws IOException {
        workOuts.clear();
        List<String> lines = Files.readAllLines(from);
        for(String workout : lines) {
            String[] split = workout.split(",", 4);
            WorkOut wo = new WorkOut(split[0], Integer.parseInt(split[1]), split[2], split[3]);
            workOuts.add(wo);
        }
    }


    // REQUIRES: The name of a work out in the list and a new work parameter
    // MODIFIES: this
    // EFFECTS:  Changes the work parameter of a workout in the list with the name provided
    public void changeWork(String name, String work){
        for (WorkOut wo: workOuts) {
            if(name.equals(wo.getName())) {
                wo.changePlan(work);
                break;
            }
        }
    }


    // REQUIRES: A day of the week
    // MODIFIES: this
    // EFFECTS: Removes a WorkOut on a given day
    public void remove(String day) {
        for (WorkOut WO : workOuts) {
            if (day.equals(WO.getDay())) {
                workOuts.remove(WO);
                System.out.println(WO.getName() + " has been removed.");
                break;
            }
        }
    }

    // REQUIRES: The day of a work out
    // MODIFIES: nothing
    // EFFECTS: prints out what day that work out is on and what needs to be done
    public boolean find(String day) {
        for (int i = 0; i < workOuts.size(); i++) {
            if(workOuts.get(i).getDay().equals(day)){
                System.out.println(workOuts.get(i).getName() + " is found, it is done on " + workOuts.get(i).getDay() + "!");
                return true;
            }
        }
        return false;
    }



}
