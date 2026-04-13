package CarRentalSystem.Payment;

import java.util.Date;

public class Payment {
    private final int paymentId;
    private final int billId;
    private final double amount;
    private final PaymentMode paymentMode;
    private final Date paymentDate;

    public Payment(int paymentId, int billId, double amount, PaymentMode paymentMode, Date paymentDate) {
        this.paymentId = paymentId;
        this.billId = billId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paymentDate = paymentDate;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public int getBillId() {
        return billId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }
}
