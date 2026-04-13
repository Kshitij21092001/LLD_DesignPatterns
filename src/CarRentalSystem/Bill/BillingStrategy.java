package CarRentalSystem.Bill;

import CarRentalSystem.Reservation.Reservation;

public interface BillingStrategy {
    Bill generateBill(Reservation reservation);
}
