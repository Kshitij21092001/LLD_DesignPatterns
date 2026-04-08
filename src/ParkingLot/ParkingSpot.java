package ParkingLot;

public abstract class ParkingSpot {
    public int id;
    public boolean isEmpty;
    public Vehicle vehicle;
    public int price;

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        isEmpty=false;
    }

    public void removeVehicle(){
        this.vehicle=null;
        isEmpty=true;
    }

    public int getPrice(){
        return price;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

    public int getId(){
        return id;
    }
}
