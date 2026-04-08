package ParkingLot;


import java.util.List;

public abstract class ParkingSpotManager {
    List<ParkingSpot> spots;
    ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> spots, ParkingStrategy parkingStrategy) {
        this.spots = spots;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot findParkingSpot(){
        ParkingSpot temp=null;
        temp=parkingStrategy.findParkingSpot(spots);
        if(temp==null){
            System.out.println("ParkingSpot not found");
        }
        return temp;
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        spots.add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot){
        spots.remove(parkingSpot);
    }


    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot=findParkingSpot();
        if(spot==null){
            System.out.println("ParkingSpot not found");
        }
        else{
            spot.parkVehicle(vehicle);
        }
        return spot;
    }

    public void removeVehicle(ParkingSpot spot){
        spot.removeVehicle();
    }
}
