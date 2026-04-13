package CarRentalSystem.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reservation {
    private final int reservationID;
    private final int vehicleID;
    private final int userID;
    private final LocalDate dateBookedFrom;
    private final LocalDate dateBookedTo;
    private final ReservationType reservationType;
    private ReservationStatus reservationStatus;

    public Reservation(int reservationID,int vehicleID,int userID,LocalDate dateBookedFrom,LocalDate dateBookedTo,ReservationType reservationType){
        this.reservationID = reservationID;
        this.vehicleID = vehicleID;
        this.userID = userID;
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTo = dateBookedTo;
        this.reservationType = reservationType;
        this.reservationStatus=ReservationStatus.SCHEDULED;
    }

    //final variables, only getters
    public int getReservationID() {
        return reservationID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public int getUserID() {
        return userID;
    }

    public LocalDate getDateBookedFrom() {
        return dateBookedFrom;
    }

    public LocalDate getDateBookedTo() {
        return dateBookedTo;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
