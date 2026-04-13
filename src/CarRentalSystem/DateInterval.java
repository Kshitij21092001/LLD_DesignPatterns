package CarRentalSystem;

import java.time.LocalDate;

public class DateInterval {
    private final LocalDate from;
    private final LocalDate to;

    public DateInterval(LocalDate from, LocalDate to) {
        if(to.isBefore(from)) {
            throw new IllegalArgumentException("From must be before To date");
        }
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public boolean overlapse(DateInterval requested){
        return !(this.from.isAfter(requested.getTo()) || this.to.isBefore(requested.getFrom()));
    }
}
