import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trafficlight.Observer.Observer;
import trafficlight.ctrl.TrafficLightCtrl;
import trafficlight.states.State;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrafficLightTest {
    private static TrafficLightCtrl farbe;
    State greenState;
    State yellowState;
    State previousState;
    State currentState;

    @BeforeAll
    static void init(){
        farbe = new TrafficLightCtrl();
    }

    @Test
    @DisplayName("pass is valid")
    public void testIsValid_Scenario1(){
        greenState = new State() {
            @Override
            public State getNextState() {
                previousState = currentState;
                //TODO useful to update the current state and the old one
                currentState.notifyObserver();
                yellowState.notifyObserver();

                return yellowState;
            }
            @Override
            public String getColor() {
                return "green";
            }
        };
    }
}
