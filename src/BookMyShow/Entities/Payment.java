package BookMyShow.Entities;

import BookMyShow.Enums.PaymentStatus;

import java.util.UUID;

public class Payment {
    private final UUID paymentId;
    private PaymentStatus paymentStatus;

    public Payment(){
        this.paymentId = UUID.randomUUID();
        this.paymentStatus=PaymentStatus.PENDING;
    }

    public void makePayment(@org.jetbrains.annotations.NotNull Payment payment){
        payment.paymentStatus=PaymentStatus.SUCCESS;
    }

    public UUID getPaymentId(){
        return paymentId;
    }

    public PaymentStatus getPaymentStatus(){
        return paymentStatus;
    }
}
