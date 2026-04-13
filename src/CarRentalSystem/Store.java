package CarRentalSystem;

import CarRentalSystem.Bill.Bill;
import CarRentalSystem.Bill.BillManager;
import CarRentalSystem.Bill.BillingStrategy;
import CarRentalSystem.Bill.DailyBillingStrategy;
import CarRentalSystem.Payment.Payment;
import CarRentalSystem.Payment.PaymentManager;
import CarRentalSystem.Payment.PaymentStrategy;
import CarRentalSystem.Payment.UPIPaymentStrategy;
import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleInventoryManager;
import CarRentalSystem.Product.VehicleType;
import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.Reservation.ReservationManager;
import CarRentalSystem.Reservation.ReservationType;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Store {
    private final int storeID;
    private final Location location;
    private final VehicleInventoryManager vehicleInventoryManager;
    private final ReservationManager reservationManager;
    private final BillManager billManager;
    private final PaymentManager paymentManager;

    public Store(int storeID, Location location) {
        this.storeID = storeID;
        this.location = location;
        this.vehicleInventoryManager = new VehicleInventoryManager();
        this.reservationManager = new ReservationManager(vehicleInventoryManager);
        this.billManager = new BillManager(new DailyBillingStrategy(vehicleInventoryManager));
        this.paymentManager = new PaymentManager(new UPIPaymentStrategy());
    }

    //searching vehicles
    public List<Vehicle> getAvailableVehicles(VehicleType type, LocalDate from, LocalDate to) {
        return vehicleInventoryManager.getAvailableVehicles(type,from,to);
    }

    //creating reservation
    public Reservation createReservation(int vehicleID, int userID, LocalDate from, LocalDate to, ReservationType type) {
        return reservationManager.createReservation(vehicleID,userID,from,to,type);
    }

    //managing reservations
    public void startTrip(int reservationID){
        reservationManager.startTrip(reservationID);
        return;
    }

    public void endTrip(int reservationID){
        reservationManager.submitVehicle(reservationID);
        return;
    }

    public void cancelReservation(int reservationID){
        reservationManager.cancelReservation(reservationID);
        return;
    }

    //Bills and payments
    public Bill generateBill(int reservationId, BillingStrategy billingStrategy) {
        Optional<Reservation> r = reservationManager.findByID(reservationId);
        if(!r.isPresent()){
            throw  new RuntimeException("Reservation does not exist");
        }

        Reservation reservation = r.get();
        billManager.setBillingStrategy(billingStrategy);
        return billManager.generateBill(reservation);
    }

    public Payment makePayment(Bill bill, PaymentStrategy paymentStrategy) {
        paymentManager.setStrategy(paymentStrategy);
        Payment payment = paymentManager.makePayment(bill);

        if(!bill.isBillPaid()) throw new RuntimeException("Bill is not paid");

        reservationManager.removeReservation(bill.getReservationID());
        return payment;
    }

    public VehicleInventoryManager getVehicleInventoryManager() {
        return vehicleInventoryManager;
    }

    public Integer getStoreID() {
        return storeID;
    }
}
