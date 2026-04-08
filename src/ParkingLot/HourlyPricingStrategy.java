package ParkingLot;

public class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public int price(Ticket ticket){
        long currentTime=System.currentTimeMillis();
        long timeElapsed=currentTime-ticket.getEntryTime();
        long hours=timeElapsed/3600000L;
        return (int)(hours*ticket.getParkingSpot().getPrice());
    }
}
