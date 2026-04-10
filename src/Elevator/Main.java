package Elevator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try{
            ElevatorCar car1 = new ElevatorCar(1);
            ElevatorCar car2 = new ElevatorCar(2);

            ElevatorController controller1 = new ElevatorController(car1);
            ElevatorController controller2 = new ElevatorController(car2);

            List<ElevatorController> controllers = Arrays.asList(controller1, controller2);

            ElevatorScheduler elevatorScheduler = new ElevatorScheduler(controllers, new NearestElevatorStrategy());

            ExternalButtonDispatcher externalButtonDispatcher = new ExternalButtonDispatcher(elevatorScheduler);

            Building building = new Building(15,externalButtonDispatcher);

            InternalButton buttonForCar1 = new InternalButton(controller1);
            InternalButton buttonForCar2 = new InternalButton(controller2);

            new Thread(controller1,"Controller-1").start();
            new Thread(controller2,"Controller-2").start();

            building.getFloor(3).pressDownButton();
            Thread.sleep(3000);

            building.getFloor(10).pressDownButton();
            Thread.sleep(3000);

            buttonForCar1.pressButton(9);
            Thread.sleep(3000);

            buttonForCar2.pressButton(1);
            Thread.sleep(3000);
        }
        catch (InterruptedException ignored){}
    }
}
