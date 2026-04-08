package ParkingLot;

public class EntranceGate {
    ParkingSpotManagerFactory parkingSpotManagerFactory;
    int gateNumber;

    public EntranceGate(ParkingSpotManagerFactory parkingSpotManagerFactory, int gateNumber){
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
        this.gateNumber = gateNumber;
    }

    public Ticket generateTicket(Vehicle vehicle){
        ParkingSpotManager spotManager=parkingSpotManagerFactory.getParkingSpotManager(vehicle.getVehicleType());
        ParkingSpot spot=spotManager.parkVehicle(vehicle);
        if(spot==null){
            System.out.println("Parking spot not found");
            return null;
        }
        return new Ticket(System.currentTimeMillis(),vehicle,spot);
    }
}
