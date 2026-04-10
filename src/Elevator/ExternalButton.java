package Elevator;

import Elevator.Enums.ElevatorDirection;

public class ExternalButton {
    public ExternalButtonDispatcher dispatcher;

    public ExternalButton(ExternalButtonDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void pressButton(int destinationFloor, ElevatorDirection direction) {
        dispatcher.submitExternalRequest(destinationFloor, direction);
    }
}
