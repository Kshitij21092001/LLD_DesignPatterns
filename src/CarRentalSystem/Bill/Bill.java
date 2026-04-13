package CarRentalSystem.Bill;

public class Bill {
    private final int billID;
    private final int reservationID;
    private double billAmount;
    private boolean billPaid;

    public Bill(int billID, int reservationID, double billAmount) {
        this.billID = billID;
        this.reservationID = reservationID;
        this.billAmount = billAmount;
        this.billPaid = false;
    }

    public int getBillID(){
        return billID;
    }

    public int getReservationID(){
        return reservationID;
    }

    public double getBillAmount(){
        return billAmount;
    }

    public boolean isBillPaid(){
        return billPaid;
    }

    public void setBillPaid(boolean billPaid) {
        this.billPaid = billPaid;
    }
}
