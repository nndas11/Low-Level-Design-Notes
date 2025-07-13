package BehaviouralDesignPatterns.LLDProblems.BookMyShow;

import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Seat.Seat;
import BehaviouralDesignPatterns.LLDProblems.BookMyShow.Seat.SeatType;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private int id;
    private String name;
    private List<Show> shows;
    private int totalNoOfSeats;
    private List<Seat> seats;
    private int row;
//  list of shows -> show - movie to time


    public Screen(int id, String name, int totalNoOfSeats) {
        this.id = id;
        this.name = name;
        this.shows = new ArrayList<>();
        this.totalNoOfSeats = totalNoOfSeats;
        this.seats = new ArrayList<>();
        this.row = 10;
        intialiseSeats();
    }

   @Override
    public String toString() {
        return "Screen{id=" + id + ", name='" + name + "', shows=" + shows + "}";
    }

    public void addShow(Show show){
        shows.add(show);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Show> getShows() {
        return shows;
    }

    public int getTotalNoOfSeats() {
        return totalNoOfSeats;
    }

    public List<Seat> getSeats() {
        return seats;
    }

//    how do we do seats initalising
//    total number of seats -> takes 10% -> make it premium and rest is normal
    private void intialiseSeats(){
        int col = totalNoOfSeats/row;
        int seatId = 1;

        for (int r=0;r<row;r++){
            for (int c=0;c<col;c++){
                SeatType seatType = (row < 2) ? SeatType.PREMIUM : SeatType.REGULAR;
                seats.add(new Seat(seatId++, r, c, seatType));
            }
        }
    }
}
