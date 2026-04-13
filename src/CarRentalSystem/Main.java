package CarRentalSystem;

import CarRentalSystem.Bill.Bill;
import CarRentalSystem.Bill.DailyBillingStrategy;
import CarRentalSystem.Payment.Payment;
import CarRentalSystem.Payment.UPIPaymentStrategy;
import CarRentalSystem.Product.Vehicle;
import CarRentalSystem.Product.VehicleType;
import CarRentalSystem.Reservation.Reservation;
import CarRentalSystem.Reservation.ReservationType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to CarRentalSystem");

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(new ArrayList<>(), new ArrayList<>());

        //crating store at a location
        Location location = new Location(10, "Jalgaon Road", "SambhajiNagar","Maharashtra", 431001);

        Store store1 = new Store(1001,location);
        vehicleRentalSystem.addStore(store1);

        User user1 = new User(001,"Kshitij","MH20LD2020");
        User user2 = new User(002, "Manshi", "UK07YU2021");
        vehicleRentalSystem.addUser(user1);
        vehicleRentalSystem.addUser(user2);

        Vehicle v1 = new Vehicle(101,"MH20DK2457", VehicleType.FOUR_WHEELER);
        v1.setDailyRentalCost(1000);

        Vehicle v2 = new Vehicle(102,"UK074822", VehicleType.FOUR_WHEELER);
        v2.setDailyRentalCost(2000);

        store1.getVehicleInventoryManager().addVehicle(v1);
        store1.getVehicleInventoryManager().addVehicle(v2);

        //Selecting store and searching vehicle
        Store selectedStore = vehicleRentalSystem.getStore(1001);

        LocalDate from = LocalDate.of(2026,3,15);
        LocalDate to = LocalDate.of(2026,3,20);

        System.out.println("Available vehicles at selected store and given time: "+ selectedStore.getStoreID());
        List<Vehicle> available = selectedStore.getVehicleInventoryManager().getAvailableVehicles(VehicleType.FOUR_WHEELER,from,to);
        for(Vehicle v : available){
            System.out.println("--"+v.getVehicleType()+"--"+v.getVehicleID()+"--"+v.getDailyRentalCost());
        }

        Thread.sleep(3000);
        //creating reservation
        Reservation reservation1 = selectedStore.createReservation(102,002,from,to, ReservationType.DAILY);
        System.out.println("Reservation 1: "+reservation1.getReservationID());

        Thread.sleep(3000);
        //starting trip
        selectedStore.startTrip(reservation1.getReservationID());
        System.out.println("Trip started for reservation1: "+reservation1.getReservationID());

        Thread.sleep(3000);
        //submitting vehicle
        selectedStore.endTrip(reservation1.getReservationID());
        System.out.println("Trip ended for reservation1: "+reservation1.getReservationID());

        Thread.sleep(3000);
        //generating bill
        Bill bill = selectedStore.generateBill(reservation1.getReservationID(), new DailyBillingStrategy(selectedStore.getVehicleInventoryManager()));
        System.out.println("BillId: "+bill.getBillID()+" Bill Amount: "+ bill.getBillAmount());

        Thread.sleep(3000);
        //payment
        Payment payment = selectedStore.makePayment(bill,new UPIPaymentStrategy());
        if(bill.isBillPaid()){
            System.out.println("Payment paid for "+bill.getBillID()+ " payment amount: "+ bill.getBillAmount()+ " payment date : "+ payment.getPaymentDate());
        }
        else{
            System.out.println("Payment failed, please try again different method");
        }

        //things to learn - start from small, and keep clubbing the smalls in a large one like for encapsulation and abstraction
    }
}
