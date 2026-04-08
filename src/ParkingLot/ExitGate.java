package ParkingLot;

public class ExitGate {
    ParkingSpotManagerFactory parkingSpotManagerFactory;
    CostComputationFactory costComputationFactory;
    int gateNumber;

    public ExitGate(ParkingSpotManagerFactory parkingSpotManagerFactory,CostComputationFactory costComputationFactory, int gateNumber){
        this.parkingSpotManagerFactory = parkingSpotManagerFactory;
        this.costComputationFactory = costComputationFactory;
        this.gateNumber=gateNumber;
    }

    public int processExit(Ticket ticket, String pricingType){
        PricingStrategy priceCalc= costComputationFactory.getCostComputation(pricingType);
        int cost= priceCalc.price(ticket);
        Vehicle currVehicle=ticket.getVehicle();
        ParkingSpotManager spotManager= parkingSpotManagerFactory.getParkingSpotManager(currVehicle.getVehicleType());
        spotManager.removeVehicle(ticket.getParkingSpot());
        System.out.println("FinalPrice"+cost);
        return cost;
    }
}
