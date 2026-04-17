package BookMyShow.Controller;

import BookMyShow.Entities.Booking;
import BookMyShow.Entities.Show;
import BookMyShow.Entities.User;
import BookMyShow.Services.BookingService;

import java.util.List;
import java.util.UUID;

public class BookingController {
    private final BookingService bookingService;

    public BookingController() {
        this.bookingService = new BookingService();
    }

    public Booking createBooking(User user, Show show, List<Integer> seatIds){
        return bookingService.bookTickets(user,show,seatIds);
    }

    public Booking getBooking(UUID bookingId){
        return bookingService.getBooking(bookingId);
    }

    public List<Booking> getBookingByUser(User user){
        return bookingService.getBookingForUser(user);
    }
}
