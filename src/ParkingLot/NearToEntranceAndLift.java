package ParkingLot;

import java.util.List;

public class NearToEntranceAndLift implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpot(List<ParkingSpot> spots){
        ParkingSpot temp = null;
        for(int i=0;i<spots.size();i++){
            if(spots.get(i).isEmpty()) {
                temp = spots.get(i);
                break;
            }
        }
        return temp;
    }
}
