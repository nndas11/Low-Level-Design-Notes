package BehaviouralDesignPatterns.LLDProblems.BookMyShow;

import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Seat.Seat;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Seat.SeatStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {
    private int id;
    private Movie movie;
//    there are time when you need bidirectional flow.
    private Screen screen;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Map<Integer, Seat> seats;
//    We need seats specific to the show -> as screen can have multiple shows
//    each show the seats booking will be different.


    public Show(int id, Movie movie, Screen screen, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = new HashMap<>();
        initializeSeats();
    }

    private void initializeSeats(){
        for (Seat seat: screen.getSeats()){
            seats.put(seat.getId(), new Seat(seat.getId(), seat.getRow(),seat.getCol(),seat.getSeatType()));
        }
    }



    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

//    public List<Seat> getBookedSeats() {
//        return seats.get;
//    }
    public void reserveSeat(int seatId) {
        Seat seat = seats.get(seatId);
        if (seat != null && seat.getSeatStatus() == SeatStatus.AVAILABLE) {
            seat.reserveSeat();
        }
    }

    @Override
    public String toString() {
        return "Show{" +
                "id=" + id +
                ", movie=" + movie +

                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", seats=" + seats +
                '}';
    }

    public void bookSeat(int id){
        Seat seat = seats.get(id);
        if(seat != null && seat.getSeatStatus() == SeatStatus.RESERVED)
            seat.bookSeat();
    }

    public void releaseSeat(int seatId) {
        Seat seat = seats.get(seatId);
        if (seat != null) {
            seat.releaseSeat();
        }
    }

    public boolean isSeatAvailable(int id){
        Seat seat = seats.get(id);
        return seat.isAvailable();
    }

    public List<Seat> availableSeats(){
        List<Seat> availableSeats = new ArrayList<>();
        for (Map.Entry<Integer, Seat> entry: seats.entrySet()){
            if(entry.getValue().isAvailable())
                availableSeats.add(entry.getValue());
        }
        return availableSeats;
    }

}
