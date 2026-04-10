package Elevator;

import Elevator.Enums.DoorState;

public class Door {
    public DoorState doorState;

    public Door(){
        this.doorState = DoorState.DOOR_CLOSED;
    }

    public void openDoor(int id){
        this.doorState = DoorState.DOOR_OPEN;
        System.out.println("Door is open for lift "+ id);
    }

    public void closeDoor(int id){
        this.doorState = DoorState.DOOR_CLOSED;
        System.out.println("Door is closed for lift "+ id);
    }
}
