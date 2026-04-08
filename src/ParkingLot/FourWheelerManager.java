package ParkingLot;

import java.util.List;

public class FourWheelerManager extends ParkingSpotManager{
    public  FourWheelerManager(List<ParkingSpot> parkingSpots){
        super(parkingSpots, new NearToEntrance());
    }
}
