package ParkingLot;

public class MinutePricingStrategy implements PricingStrategy {
    @Override
    public int price(Ticket ticket) {
        long currentTime=System.currentTimeMillis();
        long  timeElapsed=currentTime-ticket.getEntryTime();
        long minutes=timeElapsed/60000L;
        return (int)(minutes*ticket.getParkingSpot().getPrice());
    }
}
