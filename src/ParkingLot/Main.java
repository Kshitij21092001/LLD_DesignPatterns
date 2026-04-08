package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ParkingSpot[] twoWheelerSpots = new ParkingSpot[2];
        ParkingSpot[] fourWheelerSpots = new ParkingSpot[4];
        for(int i = 0; i < twoWheelerSpots.length; i++){
            twoWheelerSpots[i] = new TwoWheelerSpot();
        }

        for(int i = 0; i < fourWheelerSpots.length; i++){
            fourWheelerSpots[i]=new FourWheelerSpot();
        }

        TwoWheelerManager twoWheelerManager=new TwoWheelerManager(new ArrayList<>(List.of(twoWheelerSpots)));
        FourWheelerManager fourWheelerManager=new FourWheelerManager(new ArrayList<>(List.of(fourWheelerSpots)));

        ParkingSpotManagerFactory parkingSpotManagerFactory=new ParkingSpotManagerFactory(twoWheelerManager,fourWheelerManager);

        EntranceGate entranceGate=new EntranceGate(parkingSpotManagerFactory,1);
        ExitGate exitGate=new ExitGate(parkingSpotManagerFactory,new CostComputationFactory(),2);

        Vehicle vehicle=new Vehicle(2457,VehicleType.TWO_WHEELER);

        Ticket ticket=entranceGate.generateTicket(vehicle);

        try{
            Thread.sleep(120000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        int cost=exitGate.processExit(ticket,"minute");
    }
}
