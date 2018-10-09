package model;

public abstract class Event extends Basic{
    public Event(String name, int time, String plan){
        super.name = name;
        super.time = time;
        super.plan = plan;
    }

}
