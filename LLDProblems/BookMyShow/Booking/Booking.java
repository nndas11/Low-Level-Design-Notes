package BehaviouralDesignPatterns.LLDProblems.BookMyShow.Booking;

import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Seat.Seat;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Show;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.User;

import java.util.List;

public class Booking {
    private int id;
    private Show show;
    private User user;
    private List<Integer> bookedSeats;
    private float totalCost;
    private BookingStatus bookingStatus;

    public Booking(int id, Show show, List<Integer> bookedSeats) {
        this.id = id;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.bookingStatus = BookingStatus.REQUESTED;
    }

//    bookingStatus -> confirmed.
//    Show -> seats -> booked.
    public void confirmBooking(){
        this.bookingStatus = BookingStatus.CONFIRMED;
        for (Integer seatID: bookedSeats){
            this.show.bookSeat(seatID);
        }
    }

    public void cancelBooking(){
        this.bookingStatus = BookingStatus.CANCELLED;
        for (Integer seatID: bookedSeats){
            this.show.releaseSeat(seatID);
        }
    }

    public int getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public User getUser() {
        return user;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", show=" + show +
                ", user=" + user +
                ", bookedSeats=" + bookedSeats +
                ", totalCost=" + totalCost +
                ", bookingStatus=" + bookingStatus +
                '}';
    }
}
