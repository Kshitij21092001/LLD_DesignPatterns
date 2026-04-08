package ParkingLot;

public class ParkingSpotManagerFactory {
    TwoWheelerManager twoWheelerManager;
    FourWheelerManager fourWheelerManager;

    public ParkingSpotManagerFactory(TwoWheelerManager twoWheelerManager, FourWheelerManager fourWheelerManager){
        this.twoWheelerManager = twoWheelerManager;
        this.fourWheelerManager = fourWheelerManager;
    }

    public ParkingSpotManager getParkingSpotManager(VehicleType type){
        ParkingSpotManager temp = null;
        if(type==VehicleType.TWO_WHEELER)temp =  twoWheelerManager;
        if(type==VehicleType.FOUR_WHEELER)temp = fourWheelerManager;
        return temp;
    }
}
