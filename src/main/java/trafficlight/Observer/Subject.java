////https://www.philipphauer.de/study/se/design-pattern/observer.php

package trafficlight.Observer;
import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<Observer> observerList = new ArrayList<>();

    public void removeObserver(Observer newObserver) {
        this.observerList.remove(newObserver);
    }

    public void addObserver(Observer newObserver){
        this.observerList.add(newObserver);
    }

    public void notifyObserver(){
        for (Observer newObserver : this.observerList){
            newObserver.update();
        }
    }
}