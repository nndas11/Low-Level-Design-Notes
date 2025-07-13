package BehaviouralDesignPatterns.LLDProblems.BookMyShow.Service;

import BehaviouralDesignPatterns.LLDProblems.BookMyShow.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchService {
//    in each service layer, we can have link to theatre, movie service if needed ,

//    those services will store  the links like map of city to shows etc.. if needed
//    may be needed as per requirement, and we store these in the service layer in LLD
//    as there is no repo layer and hence no db for persistent storage.

//    if any doubts in using streams -> just do for loop

    public Set<Movie> getMoviesByCity(City city){
        Set<Movie> movies = new HashSet<>();

        for (Theatre theatre: city.getTheatres()){
            for (Screen screen: theatre.getListOfScreens()){
                for (Show show: screen.getShows()){
                    movies.add(show.getMovie());
                }
            }
        }

        return movies;
    }

    public Set<Theatre> getTheatresByCityMovie(City city, Movie movie){
        Set<Theatre> theatres = new HashSet<>();

//        for (Theatre theatre: city.getTheatres()){
//            boolean isMovieFound = false;
//            for (Screen screen: theatre.getListOfScreens()){
//                for (Show show: screen.getShows()){
//                   if(show.getMovie().equals(movie)){
//                       theatres.add(theatre);
//                       isMovieFound = true;
//                       break;
//                   }
//                }
//                if (isMovieFound)   break;
//            }
//        }

        for (Theatre theatre: city.getTheatres()){
            if(isMovieInTheatre(movie, theatre)){
                theatres.add(theatre);
            }
        }
        return theatres;
    }

//    we can add helper function if needed
    public boolean isMovieInTheatre(Movie movie, Theatre theatre){
            for (Screen screen: theatre.getListOfScreens()){
                for (Show show: screen.getShows()){
                    if(show.getMovie().equals(movie)){
                       return  true;
                    }
                }
            }
        return false;
    }

    public List<Show> getShowsByMovieTheatre(Theatre theatre, Movie movie){
        List<Show> shows = new ArrayList<>();

        for (Screen screen: theatre.getListOfScreens()){
            for (Show show: screen.getShows()){
                if(show.getMovie().equals(movie))
                    shows.add(show);
            }
        }

        return shows;
    }


}
