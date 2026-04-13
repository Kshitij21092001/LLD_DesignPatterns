package CarRentalSystem.Payment;

import CarRentalSystem.Bill.Bill;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class PaymentManager {
    private PaymentStrategy strategy;
    private final ConcurrentMap<Integer,Payment> payments = new ConcurrentHashMap<>();

    public PaymentManager(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public Payment makePayment(Bill bill) {
        Payment payment = strategy.processPayment(bill);
        payments.put(payment.getPaymentId(),  payment);
        return payment;
    }

    public Optional<Payment> getPayment(int paymentId) {
        return Optional.ofNullable(payments.get(paymentId));
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
}
