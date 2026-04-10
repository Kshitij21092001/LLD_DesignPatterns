package Elevator;

import Elevator.Enums.ElevatorDirection;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class ElevatorController implements Runnable {
    ElevatorCar elevatorCar;

    PriorityBlockingQueue<Integer> upMinHeap;
    PriorityBlockingQueue<Integer> downMaxHeap;

    private final Object monitor = new Object();

    public ElevatorController(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
        upMinHeap = new PriorityBlockingQueue<>();
        downMaxHeap = new PriorityBlockingQueue<>(10, Comparator.reverseOrder());
    }

    public void submitRequest(int destinationFloor){
        enqueueRequest(destinationFloor);
        return;
    }

    public void enqueueRequest(int destinationFloor){
        System.out.println("Requesting " + destinationFloor);
        if(elevatorCar.currentFloor==destinationFloor){
            elevatorCar.door.openDoor(elevatorCar.id);
            return;
        }
        if(elevatorCar.nextFloorStoppage<=destinationFloor){
            if(!upMinHeap.contains(destinationFloor)){
                upMinHeap.offer(destinationFloor);
            }
        }
        else{
            if(!downMaxHeap.contains(destinationFloor)){
                downMaxHeap.offer(destinationFloor);
            }
        }

        synchronized (monitor) {
            monitor.notify();
        }
    }

    @Override
    public void run(){
        controlElevator();
    }

    public void controlElevator(){
        while(true){
            synchronized (monitor){
                if(upMinHeap.isEmpty() &&  downMaxHeap.isEmpty()){
                    try {
                        System.out.println("Elevator "+ elevatorCar.id+" is idle.");
                        elevatorCar.movingDirection= ElevatorDirection.IDLE;
                        monitor.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            while(!upMinHeap.isEmpty()){
                int floor = upMinHeap.poll();
                System.out.println("Elevator "+elevatorCar.id+" is serving floor "+floor);
                elevatorCar.moveElevator(floor);
            }

            while(!downMaxHeap.isEmpty()){
                int floor = downMaxHeap.poll();
                System.out.println("Elevator "+elevatorCar.id+" is serving floor "+floor);
                elevatorCar.moveElevator(floor);
            }
        }
    }
}
