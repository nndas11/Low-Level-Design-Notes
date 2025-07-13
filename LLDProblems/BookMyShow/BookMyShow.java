package BehaviouralDesignPatterns.LLDProblems.BookMyShow;

import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Booking.Booking;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Seat.Seat;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Service.BookingService;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Service.SearchService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookMyShow {

//    SINGLETON DESIGN PATTERN
    public static BookMyShow bookMyShowInstance;
    private Map<String, City> cities;
    private SearchService searchService;
    private BookingService bookingService;


//    we can list/ map to store all cities and user here at this level
//    so whenever a new user ot city created, we add it the data structure
//    then we can have get all cities.

    private BookMyShow() {
        searchService = new SearchService();
        bookingService = new BookingService();
        cities = new HashMap<>();
    }

    public static synchronized BookMyShow getInstance(){
        if (bookMyShowInstance == null)
            return new BookMyShow();
        return bookMyShowInstance;
    }

    public void addCity(City city){
//        cities.putIfAbsent(city, )
        cities.put(city.getName(), city);
    }



    public Set<String> getCities() {
        return cities.keySet();
    }

    public Set<Movie> getMoviesByCity(City city){
        return searchService.getMoviesByCity(city);
    }

    public Set<Theatre> getTheatresByCityMovie(City city, Movie movie){
        return searchService.getTheatresByCityMovie(city, movie);
    }

    public List<Show> getShowsByMovieTheatre(Theatre theatre, Movie movie){
        return searchService.getShowsByMovieTheatre(theatre, movie);
    }

    public List<Seat> getAvailableSeats(Show show){
        return show.availableSeats();
    }

    public Booking bookTicket(User user, Show show, List<Integer> seats){
        Booking booking = bookingService.createBooking(user, show, seats);
        return booking;
    }


}
