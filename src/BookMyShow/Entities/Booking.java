package BookMyShow.Entities;

import BookMyShow.Enums.PaymentStatus;

import java.util.List;
import java.util.UUID;

public class Booking {
    private final UUID bookingId;
    private final User user;
    private final Show show;
    private final List<Integer> seats;
    private final Payment  payment;

    public Booking(User user, Show show, List<Integer> seats, Payment payment ) {
        this.bookingId = UUID.randomUUID();
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public Show getShow() {
        return show;
    }

    public Payment getPayment() {
        return payment;
    }
}
