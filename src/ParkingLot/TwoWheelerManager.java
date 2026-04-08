package ParkingLot;

import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager{
    public TwoWheelerManager(List<ParkingSpot> parkingSpots){
        super(parkingSpots, new NearToEntrance());
    }
}
