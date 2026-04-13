package CarRentalSystem.Bill;

import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleInventoryManager;
import CarRentalSystem.Reservation.Reservation;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DailyBillingStrategy implements BillingStrategy{
    private final VehicleInventoryManager vehicleInventoryManager;

    private final AtomicInteger billingID = new AtomicInteger(5000);

    public DailyBillingStrategy(VehicleInventoryManager vehicleInventoryManager){
        this.vehicleInventoryManager = vehicleInventoryManager;
    }

    @Override
    public Bill generateBill(Reservation reservation){
        long days = ChronoUnit.DAYS.between(reservation.getDateBookedFrom(),reservation.getDateBookedTo())+1;

        Vehicle vehicle = vehicleInventoryManager.getVehicle(reservation.getVehicleID()).get();
        double rate = vehicle.getDailyRentalCost();

        double billAmount = rate*days;

        int billId = billingID.getAndIncrement();
        return new Bill(billId, reservation.getReservationID(),  billAmount);
    }
}
