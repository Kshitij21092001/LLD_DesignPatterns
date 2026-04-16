package BookMyShow.Entities;

import BookMyShow.Enums.SeatCategory;

public class Seat {
    private final int seatId;
    private final SeatCategory seatCategory;

    public Seat(int seatId, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.seatCategory = seatCategory;
    }

    public int getSeatId() {
        return seatId;
    }
}
