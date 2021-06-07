package trafficlight.gui;


import trafficlight.Observer.Observer;

import java.awt.*;

class TrafficLight extends Light implements Observer{

    public TrafficLight(Color color) {
        super(color);
    }

    public void turnOn(boolean a) {
        isOn = a;
        repaint();
    }

    public boolean isOn() {
        return isOn;
    }

    //TODO implement a part of the pattern here

    @Override

    public void update() {

        turnOn(!isOn);
        /*
        turnOn(false);
        try {
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        turnOn(true);

         */

    }
}
