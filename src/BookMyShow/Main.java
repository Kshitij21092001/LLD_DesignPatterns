package BookMyShow;

import BookMyShow.Controller.BookingController;
import BookMyShow.Controller.TheatreController;
import BookMyShow.Entities.*;
import BookMyShow.Enums.City;
import BookMyShow.Enums.SeatCategory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private TheatreController theatreController;
    private BookingController bookingController;

    public static void main(String[] args) {
        Main main = new Main();
        main.initialize();
        main.userFlow();
    }

    private void initialize(){
        bookingController = new BookingController();
        theatreController = new TheatreController();

        Movie Dhurandhar = new Movie("Dhurandhar",235);
        Movie RRR = new Movie("RRR",180);
        Movie Interstellar = new Movie("Interstellar",170);

        Screen pvrScreen1 = new Screen(101,createSeats());
        Screen pvrScreen2 = new Screen(102,createSeats());
        Screen inoxScreen1 = new Screen(201,createSeats());
        Screen inoxScreen2 = new Screen(202,createSeats());

        Theatre pvr = new Theatre("PVR", City.BANGALORE,List.of(pvrScreen1,pvrScreen2));
        Theatre inox = new Theatre("INOX",City.BANGALORE,List.of(inoxScreen1,inoxScreen2));

        theatreController.addTheatre(pvr);
        theatreController.addTheatre(inox);

        Show inoxMorningShowToday = new Show(Dhurandhar,inoxScreen1, LocalDate.now(), LocalTime.of(10,0));
        Show pvrMorningShowToday = new Show(Dhurandhar,pvrScreen1, LocalDate.now(), LocalTime.of(11,0));
        Show inoxEveningShowToday = new Show(Interstellar,inoxScreen2, LocalDate.now(), LocalTime.of(18,0));
        Show pvrEveningShowTomorrow = new Show(Dhurandhar,pvrScreen2, LocalDate.now().plusDays(1), LocalTime.of(19,0));

        inoxScreen1.addShow(inoxMorningShowToday);
        inoxScreen2.addShow(inoxEveningShowToday);
        pvrScreen1.addShow(pvrMorningShowToday);
        pvrScreen2.addShow(pvrEveningShowTomorrow);
    }

    private void userFlow(){
        User Kshitij = new User(1,"Kshitij");
        System.out.println("User logged in "+ Kshitij.getUserName());

        City selectedCity = City.BANGALORE;
        System.out.println("Selected City: "+ selectedCity);

        LocalDate selectedDate = LocalDate.now();
        System.out.println("Selected Date: "+ selectedDate);

        Set<Movie> availableMovies = theatreController.getMovies(selectedCity, selectedDate);
        System.out.println("Available Movies :");
        availableMovies.forEach(movie->System.out.println("--"+movie.getName()));

        Movie selectedMovie = availableMovies.iterator().next();
        System.out.println("Selected Movie: "+ selectedMovie.getName());

        List<Theatre> theatres = theatreController.getTheatres(selectedCity,selectedMovie,selectedDate);
        System.out.println("Available Theatres :");
        theatres.forEach(theatre->System.out.println("--"+theatre.getName()));

        Theatre selectedTheatre = theatres.get(0);
        System.out.println("Selected Theatre: "+ selectedTheatre.getName());

        List<Show> shows = theatreController.getShows(selectedTheatre,selectedMovie,selectedDate);
        System.out.println("Available Shows :");
        shows.forEach(show->System.out.println("--"+show.getStartTime()));

        Show selectedShow = shows.get(0);
        System.out.println("Selected show: "+selectedShow.getMovie().getName()+selectedShow.getStartTime());

        List<Integer> seats = List.of(1,2,3);
        System.out.println("Selected Seats :"+seats);

        Booking newBooking = bookingController.createBooking(Kshitij,selectedShow,seats);
        Payment payment = new Payment();
        payment.makePayment(payment);
        System.out.println("Booking successfull with booking id: "+ newBooking.getBookingId());
    }

    private List<Seat> createSeats(){
        List<Seat> seats = new ArrayList<>();
        for(int i=1;i<=20;i++){
            seats.add(new Seat(i, SeatCategory.PLATINUM));
        }

        return seats;
    }
}
