package BookMyShow.Entities;

import BookMyShow.Enums.SeatStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Show {
    private final Movie movie;
    private final LocalDate showDate;
    private final LocalTime startTime;

    private final Map<Integer,SeatStatus> seatStatusMap = new HashMap<>();
    private final Map<Integer, ReentrantLock> seatLocks = new HashMap<>();

    public Show(Movie movie,Screen screen, LocalDate showDate, LocalTime startTime) {
        this.movie = movie;
        this.showDate = showDate;
        this.startTime = startTime;

        for(Seat seat:screen.getSeats()){
            seatStatusMap.put(seat.getSeatId(),SeatStatus.AVAILABLE);
            seatLocks.put(seat.getSeatId(),new ReentrantLock());
        }
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Boolean lockSeats(List<Integer> seatIds){
        List<Integer> sortedList = new ArrayList<>(seatIds);
        Collections.sort(sortedList);

        List<ReentrantLock> acquiredLocks = new ArrayList<>();

        try{
            for(Integer seatId:sortedList){
                ReentrantLock lock = seatLocks.get(seatId);
                lock.lock();
                acquiredLocks.add(lock);
            }

            for(Integer seatId:sortedList){
                if(seatStatusMap.get(seatId).equals(SeatStatus.BOOKED) || seatStatusMap.get(seatId).equals(SeatStatus.LOCKED)){
                    return false;
                }
            }

            for(Integer seatId:sortedList){
                seatStatusMap.put(seatId,SeatStatus.LOCKED);
            }

            return true;
        }finally {
            for(ReentrantLock lock:acquiredLocks){
                lock.unlock();
            }
        }
    }

    public void confirmSeats(List<Integer> seatIds){
        for(Integer seatId:seatIds){
            seatStatusMap.put(seatId,SeatStatus.BOOKED);
        }
    }

    public void releaseSeats(List<Integer> seatIds){
        for(Integer seatId:seatIds){
            seatStatusMap.put(seatId,SeatStatus.AVAILABLE);
        }
    }
}
