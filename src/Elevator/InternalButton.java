package Elevator;

public class InternalButton {
    public ElevatorController controller;

    InternalButton(ElevatorController controller) {
        this.controller = controller;
    }

    public void pressButton(int destinationFloor){
        InternalButtonDispatcher.getInstance().submitInternalRequest(destinationFloor, controller);
    }
}
