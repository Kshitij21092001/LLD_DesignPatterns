package Elevator;

import Elevator.Enums.ElevatorDirection;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy {
    public int minDistance = Integer.MAX_VALUE;
    public ElevatorController best = null;


    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor, ElevatorDirection direction) {
        for(ElevatorController controller : controllers) {
            int currentFloor=controller.elevatorCar.currentFloor;

            boolean isSameDirection = (controller.elevatorCar.movingDirection == direction)&&
                    ((direction==ElevatorDirection.UP&&requestFloor>=currentFloor)||(direction==ElevatorDirection.DOWN&&requestFloor<=currentFloor));

            int diff=Math.abs(currentFloor-requestFloor);

            if(diff<minDistance && isSameDirection){
                minDistance=diff;
                best=controller;
            }
        }

        if(best==null) {
            for(ElevatorController controller : controllers) {
                if(controller.elevatorCar.movingDirection==ElevatorDirection.IDLE){
                    best=controller;
                    break;
                }
            }

            if(best==null) {
                best=controllers.get(0);
            }
        }
        return best;
    }
}
