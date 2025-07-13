package BehaviouralDesignPatterns.LLDProblems.BookMyShow.Service;

import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Booking.Booking;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Booking.BookingStatus;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Show;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingService {
    private Map<Integer, Booking> bookings;
//    private PaymentService paymentService;

    public BookingService() {
        this.bookings = new HashMap<>();
    }

    public synchronized Booking createBooking(User user, Show show, List<Integer> seatIds){
//        check if seats are available
        for (Integer seatId: seatIds){
            if(!show.isSeatAvailable(seatId)){
                throw new IllegalArgumentException("Seat is Not Available: " + seatId);
            }
        }

        for (Integer seatId : seatIds) {
            show.reserveSeat(seatId);
        }

        int bookingID = generateBookingId();
        Booking booking = new Booking(bookingID, show, seatIds);

        bookings.put(bookingID, booking);
        return booking;
    }

    private int generateBookingId() {
        return (int)System.currentTimeMillis();
    }

    public boolean confirmBooking(int id){
        Booking booking = bookings.get(id);
        if (booking == null || booking.getBookingStatus() != BookingStatus.REQUESTED) {
            return false;
        }

//        Payment pending todo after writing paymentservice


        booking.confirmBooking();
        return true;
    }

    public void cancelBooking(int bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.cancelBooking();
        }
    }


}
