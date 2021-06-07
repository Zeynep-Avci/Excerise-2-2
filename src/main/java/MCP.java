import trafficlight.ctrl.TrafficLightCtrl;
//worked with Nur Sarhan and Greta Berdynaj

public class MCP {
    public static void main(String[] args) {
        TrafficLightCtrl ctrl = TrafficLightCtrl.getController();
        ctrl.run();
    }
}