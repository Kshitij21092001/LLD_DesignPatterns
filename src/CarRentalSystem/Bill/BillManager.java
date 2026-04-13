package CarRentalSystem.Bill;

import CarRentalSystem.Reservation.Reservation;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BillManager {
    private BillingStrategy billingStrategy;
    public BillManager(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    private ConcurrentMap<Integer,Bill> bills = new ConcurrentHashMap<>();

    public Bill generateBill(Reservation reservation) {
        Bill bill = billingStrategy.generateBill(reservation);
        bills.put(bill.getBillID(), bill);
        return bill;
    }

    public Optional<Bill> getBill(int billID) {
        return Optional.ofNullable(bills.get(billID));
    }

    public void setBillingStrategy(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }
}
