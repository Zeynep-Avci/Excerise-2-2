package trafficlight;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.ctrl.TrafficLightCtrl;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightTest {

    @Test
    @DisplayName("Check if light goes from Green to Yellow")
    public void checkGreenToYellow() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getRedState());
    }

    @Test
    @DisplayName("Check if light goes from Green to Yellow")
    public void checkGreenToYellow2() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getGreenState());
    }


    @Test
    @DisplayName("Check if light goes from Green to Yellow")
    public void checkGreenToYellow3() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertEquals(trafficLight.getCurrentState(), trafficLight.getYellowState());
    }

    @Test
    @DisplayName("Check if light goes from Yellow to Red")
    public void checkYellowToRed2() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getYellowState());
    }

    @Test
    @DisplayName("Check if light goes from Yellow to Red")
    public void checkYellowToRed3() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getGreenState());

    }

    @Test
    @DisplayName("Check if light goes from Yellow to Red")
    public void checkYellowToRed() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        trafficLight.nextState();
        assertEquals(trafficLight.getCurrentState(), trafficLight.getRedState());
    }


    @Test
    @DisplayName("Check if light goes from Red to Yellow")
    public void checkRedToYellow() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertEquals(trafficLight.getCurrentState(), trafficLight.getYellowState());
    }

    @Test
    @DisplayName("Check if light goes from Red to Yellow")
    public void checkRedToYellow2() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getGreenState());
    }

    @Test
    @DisplayName("Check if light goes from Red to Yellow")
    public void checkRedToYellow3() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getRedState());
    }

    @Test
    @DisplayName("Check if light goes Yellow to Green")
    public void checkYellowToGreen() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getYellowState());
    }

    @Test
    @DisplayName("Light goes from  Yellow to Green")
    public void checkYellowToGreen2() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getRedState());
    }


    @Test
    @DisplayName("Light goes from  Yellow to Green")
    public void checkYellowToGreen3() {
        TrafficLightCtrl trafficLight = TrafficLightCtrl.getController();
        trafficLight.nextState();
        assertNotEquals(trafficLight.getCurrentState(), trafficLight.getGreenState());
    }
}