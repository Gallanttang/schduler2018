package model;

import Exceptions.InvalidDayException;
import Exceptions.InvalidTimeException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HashMapOfWorkOuts extends HashMapAbstract {
    private HashMap<String, WorkOut> workOuts;

    public HashMapOfWorkOuts() {
        workOuts = new HashMap<>(7);
    }

    public HashMap<String, WorkOut> getWorkOuts() {
        return workOuts;
    }

    // REQUIRES: New work out parameters
    // MODIFIES: this
    // EFFECTS:  Adds a WorkOut to the list and removes a work out that is on the same day
    public void add(WorkOut w){
        workOuts.put(w.getDay(), w);
    }

    //Requires: A workout
    //Modifies: this
    //Effects:  removes that work out from the list if it exists in the list
    public void remove(WorkOut w){
        workOuts.remove(w.getDay());
    }

    // REQUIRES: index of work out (0<= i < workOut.size())
    // MODIFIES: nothing
    // EFFECTS:  returns work out in that position

    public WorkOut get(String day){
        return workOuts.get(day);
    }

    //Requires: Work Out list
    //Modifies: Nothing
    //Effects:  Returns the size of the list
    public int size() { return workOuts.size(); }

    //Requires: User Input
    //Modifies: this
    //Effects:  Over rides existing plan with a loaded plan
    public void addAndReplace(String name, int time, String work, String day) throws InvalidDayException, InvalidTimeException{
        if(isAValidDayOfWeek(day)){
            throw new InvalidDayException(day);
        }
        if(validTime(time)){
            throw new InvalidTimeException(time);
        }
        WorkOut WO = new WorkOut(name, time, work, day);
        if(!workOuts.containsKey(day)){
            workOuts.put(day, WO);
            System.out.println(WO.getName() + " has been added on " + WO.getDay());
        } else {
            System.out.println(workOuts.get(day).getName() + " on " + day + " has been removed");
            workOuts.remove(day);
            System.out.println(WO.getName() + " has been added on " + WO.getDay());
            workOuts.put(day,WO);
        }
    }

    private boolean validTime(int time) {
        return !(time >= 0 && time <=24);
    }

    private boolean isAValidDayOfWeek(String day) {
        return !(day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday") || day.equals("Thursday")
        || day.equals("Friday") || day.equals("Saturday") || day.equals("Sunday"));
    }

    //Requires: Path
    //Modifies: Nothing
    //Effects:  creates a new file with existing work out plan
    @Override
    public void save(Path saveTo) throws IOException{
        ArrayList<String> lines = new ArrayList<>();
        for (Map.Entry<String, WorkOut> e: workOuts.entrySet()) {
            lines.add(e.getValue().getName() +  ","+ Integer.toString(e.getValue().getTime())
                    + ","+ e.getValue().getDay() + "," + e.getValue().getPlan());
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
        for (String workout : lines) {
            String[] split = workout.split(",", 4);
            WorkOut wo = new WorkOut(split[0], Integer.parseInt(split[1]), split[2], split[3]);
            workOuts.put(wo.getDay(), wo);
        }
    }


    // REQUIRES: The name of a work out in the list and a new work parameter
    // MODIFIES: this
    // EFFECTS:  Changes the work parameter of a workout in the list with the name provided
    public void changeWork(String name, String work){
        for (Map.Entry<String, WorkOut> e: workOuts.entrySet()) {
            if(name.equals(e.getValue().getName())) {
                e.getValue().changePlan(work);
                break;
            }
        }
    }



    // REQUIRES: A day of the week
    // MODIFIES: this
    // EFFECTS: Removes a WorkOut on a given day
    @Override
    public void remove(String day) {
        for (Map.Entry<String, WorkOut> e: workOuts.entrySet()) {
            if (isSameDay(day, e)) {
                System.out.println(e.getValue().getName() + " has been removed.");
                workOuts.remove(e.getKey());
                break;
            }
        }
    }

    // REQUIRES: The day of a work out
    // MODIFIES: nothing
    // EFFECTS: prints out what day that work out is on and what needs to be done
    @Override
    public boolean find(String day) {
        for (Map.Entry<String, WorkOut> e: workOuts.entrySet()) {
            if(isSameDay(day, e)){
                System.out.println(e.getValue().getName() + " is found, it is done on "
                        + e.getValue().getDay() + " and you need to do some " + e.getValue().getPlan() + "!");
                return true;
            }
        }
        return false;
    }

    private boolean isSameDay(String day, Map.Entry<String, WorkOut> e) {
        return e.getValue().getDay().equalsIgnoreCase(day);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMapOfWorkOuts that = (HashMapOfWorkOuts) o;
        return Objects.equals(workOuts, that.workOuts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(workOuts);
    }
}
