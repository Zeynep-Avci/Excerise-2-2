package trafficlight.ctrl;

import trafficlight.Observer.Observer;
import trafficlight.gui.TrafficLightGui;
import trafficlight.states.State;

import javax.security.auth.Subject;

public class TrafficLightCtrl{

    private State greenState;

    private State redState;

    private State yellowState;

    private State currentState;

    private State previousState;

    private final TrafficLightGui gui;

    private boolean doRun = true;

    //* Privates Klassenattribut, wird beim erstmaligen Gebrauch (nicht beim Laden) der Klasse erzeugt
    //Sie besitzt einen privaten parameterlosen Konstruktor, um zu verhindern, daß andere Klassen durch Anwendung des new-Operators
    // eine Instanz erzeugen (er verhindert allerdings auch das Ableiten anderer Klassen).
    private static TrafficLightCtrl instance;
    //* Statische Methode "getInstance()" liefert die einzige Instanz der Klasse zurück.
    //* Ist synchronisiert und somit thread-sicher.
    //Nachteil dieser Variante ist, dass auch nach der Instanziierung jeder Lesezugriff


    public TrafficLightCtrl() {
        super();
        initStates();
        gui = new TrafficLightGui(this);
        gui.setVisible(true);
        //TODO useful to update the current state
        currentState.notifyObserver();
    }

    //Implement controller as Singleton Patten:
    private static TrafficLightCtrl controller;

    public static TrafficLightCtrl getController(){
        if(controller == null){
            controller = new TrafficLightCtrl();
        }
        return controller;
    }

    public State getCurrentState() {
        return currentState;
    }

    private void initStates() {
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

        redState = new State() {
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
                return "red";
            }
        };

        yellowState = new State() {
            @Override
            public State getNextState() {
                if (previousState.equals(greenState)) {
                    previousState = currentState;
                    //TODO useful to update the current state and the old one
                    currentState.notifyObserver();
                    redState.notifyObserver();

                    return redState;
                }else {
                    previousState = currentState;
                    //TODO useful to update the current state and the old one
                    currentState.notifyObserver();
                    greenState.notifyObserver();

                    return greenState;
                }
            }
            @Override
            public String getColor() {
                return "yellow";
            }
        };
        currentState = greenState;
        previousState = yellowState;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public void run()  {
        int intervall = 1500;
        while (doRun) {
            try {
                Thread.sleep(intervall);
                nextState();
            } catch (InterruptedException e) {
                gui.showErrorMessage(e);
            }
        }
        System.out.println("Stopped");
        System.exit(0);
    }

    public void nextState() {
        currentState = currentState.getNextState();
    }

    public void stop() {
        doRun = false;
    }


}