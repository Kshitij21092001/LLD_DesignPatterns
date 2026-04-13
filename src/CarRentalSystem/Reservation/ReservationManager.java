package CarRentalSystem.Reservation;

import CarRentalSystem.Product.VehicleInventoryManager;
import CarRentalSystem.Product.VehicleType;

import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ReservationManager {
    private final VehicleInventoryManager inventoryManager;
    private final ReservationRepository reservationRepository;

    private final AtomicInteger reservationIDGenerator = new AtomicInteger(20000);

    public ReservationManager(VehicleInventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.reservationRepository = new ReservationRepository();
        inventoryManager.setReservationRepository(reservationRepository);
    }

    //get reservations
    public Optional<Reservation> findByID(int reservationID) {
        return reservationRepository.getReservation(reservationID);
    }

    //create new reservation
    public Reservation createReservation(int vehicleID, int userID, LocalDate from, LocalDate to, ReservationType type){
        int reservationID = reservationIDGenerator.getAndIncrement();
        boolean isAvailable = inventoryManager.isAvailable(vehicleID,from,to);

        if(!isAvailable){
            throw new RuntimeException("Vehicle is not available");
        }

        Reservation newReservation = new Reservation(reservationID,vehicleID,userID,from,to,type);
        reservationRepository.saveReservation(newReservation);
        return newReservation;
    }

    //cancel existing reservation
    public void cancelReservation(int reservationID){
        Optional<Reservation> reservation = reservationRepository.getReservation(reservationID);
        if(!reservation.isPresent()){
            throw  new RuntimeException("Reservation does not exist");
        }

        Reservation reservationToCancel = reservation.get();
        reservationToCancel.setReservationStatus(ReservationStatus.CANCELLED);

        inventoryManager.release(reservationToCancel.getVehicleID(),reservationToCancel.getReservationID());
        reservationRepository.removeReservation(reservationID);
    }

    //start trip
    public void startTrip(int reservationID){
        Optional<Reservation> r=reservationRepository.getReservation(reservationID);
        if(!r.isPresent()){
            throw  new RuntimeException("Reservation does not exist");
        }

        Reservation reservation = r.get();
        reservation.setReservationStatus(ReservationStatus.IN_USE);
    }

    //submit vehicle
    public void submitVehicle(int reservationID){
        Optional<Reservation> r=reservationRepository.getReservation(reservationID);
        if(!r.isPresent()){
            throw  new RuntimeException("Reservation does not exist");
        }

        Reservation reservation = r.get();
        reservation.setReservationStatus(ReservationStatus.COMPLETED);

        inventoryManager.release(reservation.getVehicleID(),reservation.getReservationID());
    }

    //remove reservation
    public void removeReservation(int  reservationID){
        reservationRepository.removeReservation(reservationID);
    }
}