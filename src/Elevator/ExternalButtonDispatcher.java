package Elevator;

import Elevator.Enums.ElevatorDirection;

public class ExternalButtonDispatcher {
    public ElevatorScheduler scheduler;

    public ExternalButtonDispatcher(ElevatorScheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void submitExternalRequest(int destinationFloor, ElevatorDirection direction) {
        ElevatorController controller = scheduler.assignElevator(destinationFloor, direction);
        controller.submitRequest(destinationFloor);
    }
}
