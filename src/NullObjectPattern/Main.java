package NullObjectPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("Bike");
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Vehicle fuel Capacity: "+vehicle.getFuelCapacity());
        System.out.println("Vehicle seating Capacity: "+vehicle.getSeatingCapacity());
    }
}
