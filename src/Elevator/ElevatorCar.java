package Elevator;

import Elevator.Enums.DoorState;
import Elevator.Enums.ElevatorDirection;

public class ElevatorCar {
    public int id;
    public int currentFloor;
    public int nextFloorStoppage;
    public ElevatorDirection movingDirection;
    public Door door;

    public ElevatorCar(int id){
        this.id = id;
        this.currentFloor = 0;
        this.movingDirection=ElevatorDirection.IDLE;
        door=new Door();
    }

    public void showDisplay(){
        System.out.println("Elevator "+this.id+" current floor "+ this.currentFloor+" moving "+this.movingDirection);
    }

    public void moveElevator(int destinationFloor){
        this.nextFloorStoppage=destinationFloor;
        if(this.currentFloor==this.nextFloorStoppage){
            door.openDoor(id);
            return;
        }

        int startFloor=this.currentFloor;
        door.closeDoor(id);
        if(destinationFloor>startFloor){
            movingDirection=ElevatorDirection.UP;
            showDisplay();
            for(int i=startFloor+1;i<=destinationFloor;i++){
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                this.currentFloor=i;
                showDisplay();
            }
        }
        else{
            movingDirection=ElevatorDirection.DOWN;
            showDisplay();
            for(int i=startFloor-1;i>=destinationFloor;i--){
                try{
                    Thread.sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                this.currentFloor=i;
                showDisplay();
            }
        }
        door.closeDoor(id);
    }
}
