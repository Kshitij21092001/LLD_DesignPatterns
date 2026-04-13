package CarRentalSystem.Payment;

import CarRentalSystem.Bill.Bill;

public interface PaymentStrategy {
    Payment processPayment(Bill bill);
}
