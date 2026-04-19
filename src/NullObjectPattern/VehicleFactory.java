package NullObjectPattern;

public class VehicleFactory {
    static Vehicle getVehicleObject(String vehicleType){
        if(vehicleType.equals("Car")){
            return new Car();
        }
        return new NullVehicle();
    }
}
