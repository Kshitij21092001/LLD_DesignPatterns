package BookMyShow.Services;

import BookMyShow.Entities.*;
import BookMyShow.Enums.PaymentStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingService {
    private final Map<UUID, Booking> bookings= new HashMap<>();

    public Booking bookTickets(User user, Show show, List<Integer> seatIds){
        if(!show.lockSeats(seatIds))throw new RuntimeException("Seats unavailable");

        Payment payment = new Payment();
        payment.makePayment(payment);

        if(payment.getPaymentStatus()== PaymentStatus.SUCCESS){
            show.confirmSeats(seatIds);
            Booking booking = new Booking(user,show,seatIds,payment);
            bookings.put(booking.getBookingId(), booking);
            return booking;
        }
        else{
            show.releaseSeats(seatIds);
            throw new RuntimeException("Payment failed");
        }
    }

    public Booking getBooking(UUID bookingId){
        return bookings.get(bookingId);
    }

    public List<Booking> getBookingForUser(User user){
        return bookings.values()
                .stream()
                .filter(b->b.getUser()==user).toList();
    }
}
