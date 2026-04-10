package Elevator;

public class InternalButtonDispatcher {
    private static final InternalButtonDispatcher instance = new InternalButtonDispatcher();

    public static InternalButtonDispatcher getInstance() {
        return instance;
    }

    public void submitInternalRequest(int destinationFloor,ElevatorController controller){
        controller.submitRequest(destinationFloor);
    }
}
