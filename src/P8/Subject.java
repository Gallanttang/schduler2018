package P8;


import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observers = new ArrayList<>();

    public void addObservers(Observer o){
        if(!observers.contains(o)){
            observers.add(o);
        }
    }

    public void notifyObservers(Recipe r){
        for (Observer o: observers) {
            o.update(r);
        }
    }
}
