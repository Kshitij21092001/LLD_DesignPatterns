package CarRentalSystem.Reservation;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


public class ReservationRepository {
    //this is to map and store reservationID->reservation
    private final Map<Integer,Reservation> reservations;

    public ReservationRepository() {
        this.reservations = new ConcurrentHashMap<>();
    }

    public void saveReservation(Reservation reservation) {
        reservations.put(reservation.getReservationID(), reservation);
    }

    public Optional<Reservation> getReservation(int reservationID) {
        return Optional.ofNullable(reservations.get(reservationID));
    }

    public void removeReservation(int reservationID){
        reservations.remove(reservationID);
    }

    public Map<Integer,Reservation> getAllReservations() {
        return reservations;
    }
}
