package model;

public class WorkOut extends Event{
    String day;

    public WorkOut (String name, int time, String plan, String day){
        super(name, time, plan);
        this.day = day;
    }

    public String getDay(){
        return day;
    }

    public void changeDay(String newDay){
        this.day = newDay;
    }
}
