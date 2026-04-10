package Elevator;

import Elevator.Enums.ElevatorDirection;

import java.util.List;

public class LeastBusyStrategy implements ElevatorSelectionStrategy {
    public int minRequest=Integer.MAX_VALUE;
    public ElevatorController best=null;

    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers, int requestFloor, ElevatorDirection direction){
        for(ElevatorController controller:controllers){
            int load = controller.upMinHeap.size()+controller.downMaxHeap.size();

            if(load<minRequest){
                minRequest=load;
                best=controller;
            }
        }
        return best;
    }
}
