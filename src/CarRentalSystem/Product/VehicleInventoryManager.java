package CarRentalSystem.Product;

import CarRentalSystem.DateInterval;
import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.Reservation.ReservationRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class VehicleInventoryManager {
    //vehicleID->vehicle
    private final ConcurrentMap<Integer,Vehicle> vehicles = new ConcurrentHashMap<>();

    //VehicleId->all reservations on that vehicle
    private final ConcurrentMap<Integer, List<Integer>> vehicleBookingIds = new ConcurrentHashMap<>();

    //vehicleID->individual locks
    private final ConcurrentMap<Integer, ReentrantLock> vehicleLocks = new ConcurrentHashMap<>();

    ReservationRepository reservationRepository;

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getVehicleID(), vehicle);
    }

    public Optional<Vehicle> getVehicle(int vehicleID) {
        return Optional.ofNullable(vehicles.get(vehicleID));
    }

    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //for each vehicle there will be only one lock
    public ReentrantLock lockForVehicle(int vehicleID) {
        vehicleLocks.putIfAbsent(vehicleID, new ReentrantLock());
        return vehicleLocks.get(vehicleID);
    }

    //checking availability
    public boolean isAvailable(int vehicleID, LocalDate from, LocalDate to){
        Vehicle vehicle = vehicles.get(vehicleID);

        if(vehicle == null)return false;
        if(vehicle.getVehicleStatus().equals(VehicleStatus.MAINTENANCE))return false;

        DateInterval requested = new DateInterval(from, to);

        List<Integer> reservationIDs = vehicleBookingIds.get(vehicleID);
        if(reservationIDs == null || reservationIDs.isEmpty()){
            return true;
        }
        for(int reservationID : reservationIDs){
            Reservation reservation = reservationRepository.getReservation(reservationID).get();
            LocalDate bookedFrom = reservation.getDateBookedFrom();
            LocalDate bookedTo = reservation.getDateBookedTo();
            DateInterval bookedInterval =  new DateInterval(bookedFrom, bookedTo);
            if(bookedInterval.overlapse(requested)){
                return false;
            }
        }
        return true;
    }

    //Atomic Reserve vehicle
    public boolean reserve (int vehicleID,int reservationID, LocalDate from, LocalDate to){
        ReentrantLock lock = lockForVehicle(vehicleID);
        lock.lock();
        try{
            if(!isAvailable(vehicleID,from,to)){
                System.out.println("Vehicle "+vehicles.get(vehicleID).getVehicleNumber()+" not available");
                return false;
            }

            vehicleBookingIds.putIfAbsent(vehicleID,new ArrayList<>());
            vehicleBookingIds.get(vehicleID).add(reservationID);

            vehicles.get(vehicleID).setVehicleStatus(VehicleStatus.BOOKED);
            return true;
        }finally {
            lock.unlock();
        }
    }

    //Atomic release vehicle
    public void release(int vehicleID, int reservationID){
        ReentrantLock lock = lockForVehicle(vehicleID);
        lock.lock();
        try{
            List<Integer> reservationIDs = vehicleBookingIds.get(vehicleID);
            if(!(reservationIDs == null || reservationIDs.isEmpty())){
                reservationIDs.remove(reservationID);
            }

            if(reservationIDs == null || reservationIDs.isEmpty()){
                vehicles.get(vehicleID).setVehicleStatus(VehicleStatus.AVAILABLE);
            }

        }finally {
            lock.unlock();
        }
    }

    //searching using stream(),filter(), collect()
    public List<Vehicle> getAvailableVehicles(VehicleType type, LocalDate from, LocalDate to){
        return vehicles.values()
                .stream()
                .filter(v->v.getVehicleType()==type)
                .filter(v->isAvailable(v.getVehicleID(),from,to))
                .collect(Collectors.toList());
    }
}
