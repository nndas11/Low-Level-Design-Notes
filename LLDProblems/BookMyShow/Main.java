package BehaviouralDesignPatterns.LLDProblems.BookMyShow;

import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Seat.Seat;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BookMyShow bookMyShow = BookMyShow.getInstance();
//        create user
        User user1 = new User(1, "Nihad","abc@gmail.com", "9846556109");

//        create city
        City bangalore = new City("Bangalore");
        bookMyShow.addCity(bangalore);

        //        create movies
        Movie avatar = new Movie(1, "Avatar", 100, "Fantasy");
        Movie f1 = new Movie(2, "F1", 120, "Sports");

//        create theatre
        Theatre pvr = new Theatre(1, "PVR");

//        create screen
        Screen audi1 = new Screen(1, "AUDI 1",100);
        Screen audi2 = new Screen(2,"AUDI 2", 80);

        pvr.addScreen(audi1);
        pvr.addScreen(audi2);
        bangalore.addTheatre(pvr);

//        create shows
        Show show1 = new Show(1, avatar, audi1, LocalDateTime.of(2025, 10, 6, 6,0),LocalDateTime.of(2025, 10, 6, 9,0));
        Show show2 = new Show(2, f1, audi2, LocalDateTime.of(2025, 10, 6, 1,0),LocalDateTime.of(2025, 10, 6, 5,0));
        audi1.addShow(show1);
        audi2.addShow(show2);






//        seat -> we don't create -> internally done.
        Set<String> cities = bookMyShow.getCities();
        System.out.println("Available cities: ");
        System.out.println(cities);

        //        get movies by city.
        System.out.println("Movies in: " + bangalore);
        System.out.println(bookMyShow.getMoviesByCity(bangalore));

//        get theaters by city and movie.
        System.out.println("CIty by movie");
        System.out.println(bookMyShow.getTheatresByCityMovie(bangalore, avatar));
        System.out.println(bookMyShow.getTheatresByCityMovie(bangalore, f1));

        //        get shows
        System.out.println("SHOWs");
        System.out.println(bookMyShow.getShowsByMovieTheatre(pvr, avatar));
        System.out.println(bookMyShow.getShowsByMovieTheatre(pvr, f1));

//       avaialble seats
        System.out.println("Available seats");
        System.out.println(bookMyShow.getAvailableSeats(show1));
        List<Seat> seats = bookMyShow.getAvailableSeats(show1);

        //        book movie -> create + confirm
        System.out.println("Booking Tickets");
        System.out.println(bookMyShow.bookTicket(user1, show1, Arrays.asList(seats.get(0).getId(), seats.get(1).getId())));

        System.out.println(bookMyShow.getAvailableSeats(show1));
        seats = bookMyShow.getAvailableSeats(show1);


//        future scope
//        payment
//        locking of seats


    }
}
